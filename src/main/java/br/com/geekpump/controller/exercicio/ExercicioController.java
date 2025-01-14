package br.com.geekpump.controller.exercicio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.geekpump.controller.AbstractController;
import br.com.geekpump.entity.Exercicio;
import br.com.geekpump.entity.ExercicioImagem;
import br.com.geekpump.entity.GrupamentoMuscular;
import br.com.geekpump.service.exercicio.ExercicioService;
import br.com.geekpump.to.ExercicioTO;
import br.com.geekpump.util.Base64Utils;


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
				getTo().getExercicio().setGrupamentoMuscular(new GrupamentoMuscular());
			}else {
				Exercicio exercicio = exercicioService.recuperar(Integer.valueOf(getRequest().getParameter("parametro")));
				getTo().setExercicio(exercicio);
			}
		}else {
			getTo().setExercicios(exercicioService.pesquisar(getTo().getExercicioAcao()));
		}
	}
	
	/*
	 * O Retorno na controller geralmente é usado para a navegação entre paginas
	 */
	public String gravar() {
		comporImagem();
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
	
	private void comporImagem() {
		try {
			if(getTo().getThumbnail() != null) {
				ExercicioImagem imagem = new ExercicioImagem();
				imagem.setThumbnail(Base64Utils.base64Encode(br.com.geekpump.util.UtilArquivo.converteInputStreamEmBytes(getTo().getThumbnail().getInputStream())));
				imagem.setExecucao(Base64Utils.base64Encode(br.com.geekpump.util.UtilArquivo.converteInputStreamEmBytes(getTo().getImagemExecucao().getInputStream())));
				imagem.setAtivacao(Base64Utils.base64Encode(br.com.geekpump.util.UtilArquivo.converteInputStreamEmBytes(getTo().getImagemAtivacaoMuscular().getInputStream())));
				imagem.setExercicio(getTo().getExercicio());
				List<ExercicioImagem> imagens = new ArrayList<ExercicioImagem>();
				imagens.add(imagem);
				getTo().getExercicio().setImagens(imagens);
			}	
		}catch(Exception e) {
			
		}
	}
	
	
}
