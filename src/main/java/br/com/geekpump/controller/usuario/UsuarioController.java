package br.com.geekpump.controller.usuario;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.geekpump.controller.AbstractController;
import br.com.geekpump.entity.Usuario;
import br.com.geekpump.service.usuario.UsuarioService;
import br.com.geekpump.to.UsuarioTO;

@Named
@ViewScoped

public class UsuarioController extends AbstractController<UsuarioTO> implements Serializable {

	private static final long serialVersionUID = 1453669698073264272L;
	private @Inject UsuarioService usuarioService;
	
	
	
	@PostConstruct
	private void init() {
		if(getRequest().getParameter("parametro") != null) {
			
			if(getRequest().getParameter("parametro").equals("new")) {
				getTo().setUsuario(new Usuario());
				System.out.println("");
			}else {
				Usuario usuario = usuarioService.recuperar(Integer.valueOf(getRequest().getParameter("parametro")));
				getTo().setUsuario(usuario);
			}
			
		}else {
			getTo().setUsuarios(usuarioService.listar());
		}	
		
	}
	
	public String gravar() {
		
		if(getTo().getUsuario().getId() == null) {
			usuarioService.incluir(getTo().getUsuario());
		}else {
			usuarioService.alterar(getTo().getUsuario());
		}
		
		return "sucesso";
	}
	
	
	
}