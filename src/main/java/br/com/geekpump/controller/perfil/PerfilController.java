package br.com.geekpump.controller.perfil;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.geekpump.controller.AbstractController;
import br.com.geekpump.security.CustomIdentity;
import br.com.geekpump.service.usuario.UsuarioService;
import br.com.geekpump.to.PerfilTO;

@Named
@ViewScoped
	public class PerfilController extends AbstractController<PerfilTO> implements Serializable{
		
	private static final long serialVersionUID = -1926588805494216182L;
	private @Inject UsuarioService usuarioService;	
	private @Inject CustomIdentity customIdentity;
	
	@PostConstruct
	public void init() {
		getTo().setUsuario(usuarioService.recuperar(customIdentity.getUsuario().getId()));
	}
	
}
