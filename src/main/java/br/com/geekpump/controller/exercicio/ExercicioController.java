package br.com.geekpump.controller.exercicio;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.geekpump.controller.AbstractController;
import br.com.geekpump.entity.Exercicio;
import br.com.geekpump.service.exercicio.ExercicioService;
import br.com.geekpump.to.ExercicioTO;


@Named
@ViewScoped
public class ExercicioController extends AbstractController<ExercicioTO> implements Serializable {

	private static final long serialVersionUID = -9223004073448396375L;
	
	private @Inject ExercicioService exercicioService;

	@PostConstruct
	private void init() {
		if(getRequest().getParameter("parametro") != null) {
			if(getRequest().getParameter("parametro").equals("new")) {
				getTo().setExercicio(new Exercicio());
			}else {
				Exercicio exercicio = exercicioService.recuperar(Integer.valueOf(getRequest().getParameter("parametro")));
				getTo().setExercicio(exercicio);
			}
		}else {
			getTo().setExercicios(exercicioService.listar());
		}
	}
	
	/*
	 * O Retorno na controller geralmente é usado para a navegação entre paginas
	 */
	public String gravar() {
		if(getTo().getExercicio().getId() == null) {
			exercicioService.incluir(getTo().getExercicio());
		}else{
			exercicioService.alterar(getTo().getExercicio());
		}
		return "sucesso";
	}
	
	
	
	public void pesquisar() {
		
		getTo().setExercicios(exercicioService.pesquisar(getTo().getExercicioAcao()));
		
	}
	
	
}
