package br.com.geekpump.controller.treinousuarioexercicio;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.geekpump.controller.AbstractController;
import br.com.geekpump.entity.ExecucaoTreino;
import br.com.geekpump.entity.Exercicio;
import br.com.geekpump.entity.GrupamentoMuscular;
import br.com.geekpump.entity.HistoricoCarga;
import br.com.geekpump.entity.TreinoUsuarioDivisaoExercicio;
import br.com.geekpump.security.CustomIdentity;
import br.com.geekpump.service.execucaotreino.ExecucaoTreinoService;
import br.com.geekpump.service.exercicio.ExercicioService;
import br.com.geekpump.service.historicocarga.HistoricoCargaService;
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
	
	private @Inject HistoricoCargaService historicoCargaService;
	
	private @Inject CustomIdentity customIdentity;
	
	@PostConstruct
	private void init() {
		
		if(getRequest().getParameter("uid") != null) {
			inicializarView();
		}else {
			inicializarFiltros();
			getTo().setData(new Date());
			pesquisar();
		}
	}
	
	public void reload() {
		pesquisar();
	}
	
	private void inicializarView() {
		getTo().setTreinoUsuarioDivisaoExercicio(
				treinoUsuarioDivisaoExercicioService.recuperarPorUid(getRequest().getParameter("uid")));
		getTo().setHistoricoCargas(historicoCargaService.pesquisarPorExercicioUsuario(getTo().getTreinoUsuarioDivisaoExercicio().getExercicio(), customIdentity.getUsuario()));
		getTo().setUidDivisao(getRequest().getParameter("parametro"));
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
				
					HistoricoCarga historicoCarga = historicoCargaService.recuperarUltimaCargaExercicioUsuario(exercicio, customIdentity.getUsuario());
					
					TreinoUsuarioDivisaoExercicio treinoUsuarioDivisaoExercicio = new TreinoUsuarioDivisaoExercicio();
					treinoUsuarioDivisaoExercicio.setTreinoUsuarioDivisao(getTo().getTreinoUsuarioDivisao());
					treinoUsuarioDivisaoExercicio.setExercicio(exercicio);
					treinoUsuarioDivisaoExercicio.setQtdSerie(0);
					treinoUsuarioDivisaoExercicio.setQtdRepeticao(0);
					
					if(historicoCarga != null) {
						treinoUsuarioDivisaoExercicio.setCarga(historicoCarga.getCarga());
					}else {
						treinoUsuarioDivisaoExercicio.setCarga(Double.valueOf(0));
						gravarHistorico(exercicio,Double.valueOf(0));
					}
					treinoUsuarioDivisaoExercicioService.incluir(treinoUsuarioDivisaoExercicio);
				}	
			}
		}
		pesquisar();
	}
	
	public void gravarInformacoes() {
		treinoUsuarioDivisaoExercicioService.alterar(getTo().getTreinoUsuarioDivisaoExercicio());
		HistoricoCarga historicoCarga = historicoCargaService.recuperarUltimaCargaExercicioUsuario(getTo().getTreinoUsuarioDivisaoExercicio().getExercicio(), customIdentity.getUsuario());
		if(historicoCarga != null && !historicoCarga.getCarga().equals(getTo().getTreinoUsuarioDivisaoExercicio().getCarga())) {
			gravarHistorico();
		}
		inicializarView();
	}
	
	public void excluir() {
		try {
			treinoUsuarioDivisaoExercicioService.excluir(getTo().getTreinoUsuarioDivisaoExercicio());
			getResponse().sendRedirect("/treinousuariodivisaoexercicio/"+getTo().getUidDivisao());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void gravarHistorico() {
		HistoricoCarga historicoCarga = new HistoricoCarga();
		historicoCarga.setDataCarga(new Date());
		historicoCarga.setCarga(getTo().getTreinoUsuarioDivisaoExercicio().getCarga());
		historicoCarga.setExercicio(getTo().getTreinoUsuarioDivisaoExercicio().getExercicio());
		historicoCarga.setUsuario(customIdentity.getUsuario());
		historicoCargaService.incluir(historicoCarga);
	}
	
	private void gravarHistorico(Exercicio exercicio,Double carga) {
		HistoricoCarga historicoCarga = new HistoricoCarga();
		historicoCarga.setDataCarga(new Date());
		historicoCarga.setCarga(carga);
		historicoCarga.setExercicio(exercicio);
		historicoCarga.setUsuario(customIdentity.getUsuario());
		historicoCargaService.incluir(historicoCarga);
	}
	
	
	public String getHistoricoCargaDataArray() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(HistoricoCarga historicoCarga:getTo().getHistoricoCargas()) {
			sb.append("'"+UtilData.formatDate(historicoCarga.getDataCarga(),"dd/MM")+"'");
			sb.append(",");
		}
		sb.append("]");
		return sb.toString();
	}
	
	public String getHistoricoCargaArray() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(HistoricoCarga historicoCarga:getTo().getHistoricoCargas()) {
			sb.append(historicoCarga.getCarga());
			sb.append(",");
		}
		sb.append("]");
		return sb.toString();
	}
	
}
