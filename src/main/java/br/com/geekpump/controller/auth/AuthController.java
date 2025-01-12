package br.com.geekpump.controller.auth;

import java.util.Collections;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.picketlink.Identity;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;

import br.com.geekpump.controller.AbstractController;
import br.com.geekpump.entity.PerfilEnum;
import br.com.geekpump.entity.Usuario;
import br.com.geekpump.enums.TipoAutenticacaoEnum;
import br.com.geekpump.security.CustomIdentity;
import br.com.geekpump.service.usuario.UsuarioService;
import br.com.geekpump.to.AuthTO;
import br.com.geekpump.util.UtilString;

@Model
public class AuthController extends AbstractController<AuthTO>{

	private @Inject Identity identity;
	private UtilString utilString  = new UtilString();
	private @Inject UsuarioService usuarioService;
	private @Inject CustomIdentity customIdentity;

	@PostConstruct
	private void init() {
		try {
			GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(),new GsonFactory())
					.setAudience(Collections
							.singletonList("1002306781581-3h36rn4n52cn1cie4rior1gjmena080b.apps.googleusercontent.com"))
					.build();
			GoogleIdToken idToken = verifier.verify(getRequest().getParameter("credential"));
			if (idToken != null) {
				Payload payload = idToken.getPayload();
				String nome = (String) payload.get("name");
				Usuario usuario = usuarioService.recuperarPorIdGoogle(payload.getSubject());
				if(usuario == null) {
					usuario = new Usuario();
					usuario.setNome(nome);
					usuario.setEmail(payload.getEmail());
					usuario.setImagem((String) payload.get("picture"));
					usuario.setIdGoogle(payload.getSubject());
					usuario.setPerfil(PerfilEnum.ALUNO);
					usuarioService.incluir(usuario);
				}
				customIdentity.setTipoAutenticacao(TipoAutenticacaoEnum.GOOGLE);
				customIdentity.setUsuario(usuario);
				identity.login();
			} else {
				System.out.println("Invalid ID token.");
			}
			getResponse().sendRedirect("/home");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
