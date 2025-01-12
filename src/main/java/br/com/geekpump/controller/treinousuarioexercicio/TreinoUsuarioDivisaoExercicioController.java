package br.com.geekpump.controller.treinousuarioexercicio;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.geekpump.controller.AbstractController;
import br.com.geekpump.entity.ExecucaoTreino;
import br.com.geekpump.entity.Exercicio;
import br.com.geekpump.entity.GrupamentoMuscular;
import br.com.geekpump.entity.TreinoUsuarioDivisao;
import br.com.geekpump.entity.TreinoUsuarioDivisaoExercicio;
import br.com.geekpump.service.execucaotreino.ExecucaoTreinoService;
import br.com.geekpump.service.exercicio.ExercicioService;
import br.com.geekpump.service.treinousuariodivisao.TreinoUsuarioDivisaoService;
import br.com.geekpump.service.treinousuarioexercicio.TreinoUsuarioDivisaoExercicioService;
import br.com.geekpump.to.TreinoUsuarioDivisaoExercicioTO;
import br.com.geekpump.util.UtilData;


@Named
@ViewScoped
public class TreinoUsuarioDivisaoExercicioController extends AbstractController<TreinoUsuarioDivisaoExercicioTO> implements Serializable {

	private static final long serialVersionUID = 172034915448715026L;

	private @Inject TreinoUsuarioDivisaoService treinoUsuarioDivisaoService;
	private @Inject TreinoUsuarioDivisaoExercicioService treinoUsuarioDivisaoExercicioService;
	
	private @Inject ExecucaoTreinoService execucaoTreinoService;
	
	private @Inject ExercicioService exercicioService; 
	
	@PostConstruct
	private void init() {
		inicializarFiltros();
		getTo().setData(new Date());
		pesquisar();
	}
	
	public void reload() {
		pesquisar();
	}
	
	public void pesquisar() {
		getTo().setTreinoUsuarioDivisao(treinoUsuarioDivisaoService.recuperarPorUid(getRequest().getParameter("parametro")));
		
		getTo().setTreinoUsuarioExercicios(treinoUsuarioDivisaoExercicioService
				.pesquisarPorTreinoUsuarioDivisao(getTo().getTreinoUsuarioDivisao(),getTo().getData(),false));
		
		getTo().setTreinoUsuarioExerciciosExecutados(treinoUsuarioDivisaoExercicioService
				.pesquisarPorTreinoUsuarioDivisao(getTo().getTreinoUsuarioDivisao(),getTo().getData(),true));
		
		getTo().getTreinoUsuarioExerciciosExecutados().forEach(exercicio->exercicio.setSelecionado(true));
	}
	
	public void gravarExecucao() {
		for(TreinoUsuarioDivisaoExercicio exercicio:getTo().getTreinoUsuarioExercicios()) {
			if(exercicio.isSelecionado()) {
				ExecucaoTreino execucaoTreino = new ExecucaoTreino();
				execucaoTreino.setTreinoUsuarioDivisaoExercicio(exercicio);
				execucaoTreino.setDataExecucao(getTo().getData());
				execucaoTreinoService.incluir(execucaoTreino);
			}
		}
		
		Date dataInicio = UtilData.ajustaData(getTo().getData(), 0, 0, 0);
		Date dataFim = UtilData.ajustaData(getTo().getData(), 23, 59, 59);
		for(TreinoUsuarioDivisaoExercicio exercicioExecutado:getTo().getTreinoUsuarioExerciciosExecutados()) {
			if(!exercicioExecutado.isSelecionado()) {
				for(ExecucaoTreino execucaoTreino: exercicioExecutado.getExecucoesTemp()) {
					if(execucaoTreino != null && execucaoTreino.getId() != null) {
						if(UtilData.data1MaiorIgualData2(execucaoTreino.getDataExecucao(), dataInicio) && 
								UtilData.data1MenorIgualData2(execucaoTreino.getDataExecucao(), dataFim)) {
							execucaoTreinoService.excluir(execucaoTreino);
						}	
					}	
				}
			}
		}
		pesquisar();
	}
	
	public void pesquisarExercicio() {
		getTo().setExercicios(exercicioService.pesquisar(getTo().getExercicioAcao()));
		
	}
	
	private void inicializarFiltros() {
		getTo().setExercicioAcao(null);
		getTo().getExercicioAcao().setGrupamentoMuscular(new GrupamentoMuscular());
	}
	
	public void adicionarExercicios() {
		for(Exercicio exercicio:getTo().getExercicios()) {
			if(exercicio.isSelecionado()) {
				
				if(treinoUsuarioDivisaoExercicioService.countPorExercicioDivisao(exercicio, getTo().getTreinoUsuarioDivisao()) == 0) {
				
					TreinoUsuarioDivisaoExercicio treinoUsuarioDivisaoExercicio = new TreinoUsuarioDivisaoExercicio();
					treinoUsuarioDivisaoExercicio.setTreinoUsuarioDivisao(getTo().getTreinoUsuarioDivisao());
					treinoUsuarioDivisaoExercicio.setExercicio(exercicio);
					/*
					 * TODO Pegar do historico carga
					 */
					treinoUsuarioDivisaoExercicio.setCarga(Double.valueOf(0));
					treinoUsuarioDivisaoExercicioService.incluir(treinoUsuarioDivisaoExercicio);
				}	
			}
		}
		pesquisar();
	}
	
}
