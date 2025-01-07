package br.com.geekpump.controller.exercicio;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.geekpump.controller.AbstractController;
import br.com.geekpump.service.exercicio.ExercicioService;
import br.com.geekpump.to.ExercicioTO;


@Named
@ViewScoped
public class ExercicioController extends AbstractController<ExercicioTO> implements Serializable {

	private static final long serialVersionUID = -9223004073448396375L;
	
	private @Inject ExercicioService exercicioService;

	@PostConstruct
	private void init() {
		System.out.println("Teste 2");
		getTo().setExercicios(exercicioService.listar());
	}
	
	
}
