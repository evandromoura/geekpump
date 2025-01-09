package br.com.geekpump.security;

import javax.inject.Inject;
import javax.inject.Named;

import org.picketlink.Identity;
import org.picketlink.annotations.PicketLink;
import org.picketlink.authentication.BaseAuthenticator;
import org.picketlink.credential.DefaultLoginCredentials;
import org.picketlink.idm.model.basic.User;

import br.com.geekpump.entity.Usuario;
import br.com.geekpump.service.usuario.UsuarioService;

@Named
@PicketLink
public class SimpleAuthenticator extends BaseAuthenticator {

	private @Inject DefaultLoginCredentials credentials;
	private @Inject Identity identity;
	
	private @Inject UsuarioService usuarioService;
	private @Inject CustomIdentity customIdentity;
	
	
	@Override
	public void authenticate() {
		Usuario usuario = usuarioService.login(credentials.getUserId(), credentials.getPassword());
		if(usuario != null) {
			customIdentity.setUsuario(usuario);
			User user = new User(credentials.getUserId());
			setAccount(user);
			setStatus(AuthenticationStatus.SUCCESS);
		}else {
			setStatus(AuthenticationStatus.FAILURE);
		}
	}
	
	public String logout() {
		customIdentity.setUsuario(null);
		identity.logout();
		return "/login?faces-redirect=true";
	}
	
	
	
	
}