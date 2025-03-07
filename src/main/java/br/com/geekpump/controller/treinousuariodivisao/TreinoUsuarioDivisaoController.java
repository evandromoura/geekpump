package br.com.geekpump.controller.treinousuariodivisao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.geekpump.controller.AbstractController;
import br.com.geekpump.entity.ExecucaoTreinoExercicio;
import br.com.geekpump.service.execucaotreino.ExecucaoTreinoExercicioService;
import br.com.geekpump.service.exercicio.ExercicioService;
import br.com.geekpump.service.treinousuario.TreinoUsuarioService;
import br.com.geekpump.service.treinousuariodivisao.TreinoUsuarioDivisaoService;
import br.com.geekpump.to.CalendarioHorizontalTO;
import br.com.geekpump.to.TreinoUsuarioDivisaoTO;
import br.com.geekpump.util.UtilData;


@Named
@ViewScoped
public class TreinoUsuarioDivisaoController extends AbstractController<TreinoUsuarioDivisaoTO> implements Serializable{
	
	private static final long serialVersionUID = 5893208120396926784L;
	
	private @Inject TreinoUsuarioDivisaoService treinoUsuarioDivisaoService;
	private @Inject TreinoUsuarioService treinoUsuarioService;
	private @Inject ExecucaoTreinoExercicioService execucaoTreinoExercicioService;
	private @Inject ExercicioService exercicioService;
	private int QTD_DIAS_CALENDARIO = 15;	
	
	@PostConstruct
	private void init() {
		pesquisar();
		inicializarValores();
		inicializarCalendario();
	}
	
	public void pesquisar() {
		getTo().setTreinoUsuario(treinoUsuarioService.recuperarPorUid(getRequest().getParameter("parametro")));
		getTo().setTreinoUsuarioDivisoes(
			treinoUsuarioDivisaoService.pesquisarPorTreinoUsuario(getTo().getTreinoUsuario()));
	}
	
	public void gravar() {
		if(getTo().getTreinoUsuarioDivisao().getId() == null) {
			getTo().getTreinoUsuarioDivisao().setTreinoUsuario(getTo().getTreinoUsuario());
			treinoUsuarioDivisaoService.incluir(getTo().getTreinoUsuarioDivisao());
		}else {
			treinoUsuarioDivisaoService.alterar(getTo().getTreinoUsuarioDivisao());
		}
		inicializarValores();
		inicializarCalendario();
		pesquisar();
	}
	
	public void excluir() {
		treinoUsuarioDivisaoService.excluir(getTo().getTreinoUsuarioDivisaoAcao());
		pesquisar();
	}
	
	private void inicializarValores() {
		getTo().setTreinoUsuarioDivisao(null);
		getTo().getTreinoUsuarioDivisao().setCor("#ffffff");
	}
	
	private void inicializarCalendario() {
		Date dataAtual = new Date();
		List<CalendarioHorizontalTO> calendarios = new ArrayList<CalendarioHorizontalTO>();
		for(int i=QTD_DIAS_CALENDARIO;i>=0;i--) {
			Date dataAjustada = UtilData.subtrairDias(dataAtual, i);
			if(getTo().getTreinoUsuarioDivisoes() != null && !getTo().getTreinoUsuarioDivisoes().isEmpty()) {
				List<ExecucaoTreinoExercicio> execucoes =  execucaoTreinoExercicioService.pesquisarPorTreinoUsuarioDivisaoData(getTo().getTreinoUsuarioDivisoes(), dataAjustada);
				if(execucoes != null && !execucoes.isEmpty()) {
					execucoes.get(0).setQtdExercicios(exercicioService.countPorTreinoUsuarioDivisao(execucoes.get(0).getTreinoUsuarioDivisaoExercicio().getTreinoUsuarioDivisao()));
				}
				calendarios.add(new CalendarioHorizontalTO(dataAjustada,execucoes));
			}else {
				calendarios.add(new CalendarioHorizontalTO(dataAjustada,null));
			}
		}
		getTo().setCalendarios(calendarios);
	}

}
