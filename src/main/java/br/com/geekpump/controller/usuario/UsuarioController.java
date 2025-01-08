package br.com.geekpump.controller.usuario;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.geekpump.controller.AbstractController;
import br.com.geekpump.service.usuario.UsuarioService;
import br.com.geekpump.to.UsuarioTO;

@Named
@ViewScoped

public class UsuarioController extends AbstractController<UsuarioTO> implements Serializable {

	private static final long serialVersionUID = 1453669698073264272L;
	private @Inject UsuarioService usuarioService;
	
	@PostConstruct
	private void init() {
		getTo().setUsuarios(usuarioService.listar());
	}
}