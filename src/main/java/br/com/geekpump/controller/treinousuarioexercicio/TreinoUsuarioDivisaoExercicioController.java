package br.com.geekpump.controller.treinousuarioexercicio;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.geekpump.controller.AbstractController;
import br.com.geekpump.service.treinousuarioexercicio.TreinoUsuarioDivisaoExercicioService;
import br.com.geekpump.to.TreinoUsuarioDivisaoExercicioTO;


@Named
@ViewScoped
public class TreinoUsuarioDivisaoExercicioController extends AbstractController<TreinoUsuarioDivisaoExercicioTO> implements Serializable {

	private static final long serialVersionUID = 172034915448715026L;

	private @Inject TreinoUsuarioDivisaoExercicioService treinoUsuarioDivisaoExercicioService;
	
	@PostConstruct
	private void init() {
		getTo().setData(new Date());
		
		getTo().setTreinoUsuarioExercicios(treinoUsuarioDivisaoExercicioService
				.pesquisarPorUidTreinoUsuarioDivisao(getRequest().getParameter("parametro"),getTo().getData(),false));
		
		getTo().setTreinoUsuarioExerciciosExecutados(treinoUsuarioDivisaoExercicioService
				.pesquisarPorUidTreinoUsuarioDivisao(getRequest().getParameter("parametro"),getTo().getData(),true));
	}
	
}
