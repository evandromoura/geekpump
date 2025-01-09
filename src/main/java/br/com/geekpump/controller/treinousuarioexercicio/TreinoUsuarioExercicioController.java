package br.com.geekpump.controller.treinousuarioexercicio;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.geekpump.controller.AbstractController;
import br.com.geekpump.service.treinousuarioexercicio.TreinoUsuarioExercicioService;
import br.com.geekpump.to.TreinoUsuarioExercicioTO;


@Named
@ViewScoped
public class TreinoUsuarioExercicioController extends AbstractController<TreinoUsuarioExercicioTO> implements Serializable {

	private static final long serialVersionUID = 172034915448715026L;

	private @Inject TreinoUsuarioExercicioService treinoUsuarioExercicioService;
	
	@PostConstruct
	private void init() {
		getTo().setTreinoUsuarioExercicios(treinoUsuarioExercicioService
				.pesquisarPorUidTreinoUsuario(getRequest().getParameter("parametro")));
	}
	
}
