package br.com.geekpump.controller.home;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.geekpump.controller.AbstractController;
import br.com.geekpump.security.CustomIdentity;
import br.com.geekpump.service.treinousuario.TreinoUsuarioService;
import br.com.geekpump.to.HomeTO;


@Named
@ViewScoped
public class HomeController extends AbstractController<HomeTO> implements Serializable {

	private static final long serialVersionUID = 172034915448715026L;

	
	private @Inject TreinoUsuarioService treinoUsuarioService;
	private @Inject CustomIdentity customIdentity;
	
	@PostConstruct
	private void init() {
		
		getTo().setTreinos(treinoUsuarioService.pesquisarPorUsuario(customIdentity.getUsuario()));
		
	}
	
	private void calcularDados() {
		
	}
	
}
