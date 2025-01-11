package br.com.geekpump.controller.treinousuarioexercicio;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.geekpump.controller.AbstractController;
import br.com.geekpump.entity.ExecucaoTreino;
import br.com.geekpump.entity.TreinoUsuarioDivisaoExercicio;
import br.com.geekpump.service.execucaotreino.ExecucaoTreinoService;
import br.com.geekpump.service.treinousuarioexercicio.TreinoUsuarioDivisaoExercicioService;
import br.com.geekpump.to.TreinoUsuarioDivisaoExercicioTO;
import br.com.geekpump.util.UtilData;


@Named
@ViewScoped
public class TreinoUsuarioDivisaoExercicioController extends AbstractController<TreinoUsuarioDivisaoExercicioTO> implements Serializable {

	private static final long serialVersionUID = 172034915448715026L;

	private @Inject TreinoUsuarioDivisaoExercicioService treinoUsuarioDivisaoExercicioService;
	
	private @Inject ExecucaoTreinoService execucaoTreinoService;
	
	@PostConstruct
	private void init() {
		
		getTo().setData(new Date());
		pesquisar();
	}
	
	public void reload() {
		pesquisar();
	}
	
	public void pesquisar() {
		getTo().setTreinoUsuarioExercicios(treinoUsuarioDivisaoExercicioService
				.pesquisarPorUidTreinoUsuarioDivisao(getRequest().getParameter("parametro"),getTo().getData(),false));
		
		getTo().setTreinoUsuarioExerciciosExecutados(treinoUsuarioDivisaoExercicioService
				.pesquisarPorUidTreinoUsuarioDivisao(getRequest().getParameter("parametro"),getTo().getData(),true));
		
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
	
}
