package br.com.geekpump.to;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.geekpump.entity.Exercicio;
import br.com.geekpump.entity.GrupamentoMuscular;
import br.com.geekpump.entity.HistoricoCarga;
import br.com.geekpump.entity.HistoricoRepeticao;
import br.com.geekpump.entity.TreinoUsuarioDivisao;
import br.com.geekpump.entity.TreinoUsuarioDivisaoExercicio;

public class TreinoUsuarioDivisaoExercicioTO {
	
	private TreinoUsuarioDivisaoExercicio treinoUsuarioDivisaoExercicio;
	private TreinoUsuarioDivisao treinoUsuarioDivisao;
	private List<TreinoUsuarioDivisaoExercicio> treinoUsuarioExercicios;
	private List<TreinoUsuarioDivisaoExercicio> treinoUsuarioExerciciosExecutados;
	
	private Exercicio exercicioAcao;
	private List<Exercicio> exercicios;
	private GrupamentoMuscular grupamentoMuscular;
	private Date data;
	
	private String uidDivisao;
	
	private List<HistoricoCarga> historicoCargas;
	
	private List<HistoricoRepeticao> historicoRepeticoes;

	public TreinoUsuarioDivisaoExercicio getTreinoUsuarioDivisaoExercicio() {
		return treinoUsuarioDivisaoExercicio;
	}

	public void setTreinoUsuarioDivisaoExercicio(TreinoUsuarioDivisaoExercicio treinoUsuarioDivisaoExercicio) {
		this.treinoUsuarioDivisaoExercicio = treinoUsuarioDivisaoExercicio;
	}

	public TreinoUsuarioDivisao getTreinoUsuarioDivisao() {
		return treinoUsuarioDivisao;
	}

	public void setTreinoUsuarioDivisao(TreinoUsuarioDivisao treinoUsuarioDivisao) {
		this.treinoUsuarioDivisao = treinoUsuarioDivisao;
	}
	
	public List<TreinoUsuarioDivisaoExercicio> getTreinoUsuarioExercicios() {
		return treinoUsuarioExercicios;
	}

	public void setTreinoUsuarioExercicios(List<TreinoUsuarioDivisaoExercicio> treinoUsuarioExercicios) {
		this.treinoUsuarioExercicios = treinoUsuarioExercicios;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<TreinoUsuarioDivisaoExercicio> getTreinoUsuarioExerciciosExecutados() {
		return treinoUsuarioExerciciosExecutados;
	}

	public void setTreinoUsuarioExerciciosExecutados(
			List<TreinoUsuarioDivisaoExercicio> treinoUsuarioExerciciosExecutados) {
		this.treinoUsuarioExerciciosExecutados = treinoUsuarioExerciciosExecutados;
	}

	public Exercicio getExercicioAcao() {
		if (exercicioAcao == null) {
			exercicioAcao = new Exercicio();
		}
		return exercicioAcao;
	}

	public void setExercicioAcao(Exercicio exercicioAcao) {
		this.exercicioAcao = exercicioAcao;
	}

	public List<Exercicio> getExercicios() {
		return exercicios;
	}

	public void setExercicios(List<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}

	public GrupamentoMuscular getGrupamentoMuscular() {
		if (grupamentoMuscular == null) {
			grupamentoMuscular = new GrupamentoMuscular();
		}
		return grupamentoMuscular;
	}

	public void setGrupamentoMuscular(GrupamentoMuscular grupamentoMuscular) {
		this.grupamentoMuscular = grupamentoMuscular;
	}

	public List<HistoricoCarga> getHistoricoCargas() {
		if (historicoCargas == null) {
			historicoCargas = new ArrayList<HistoricoCarga>();
		}
		return historicoCargas;
	}

	public void setHistoricoCargas(List<HistoricoCarga> historicoCargas) {
		this.historicoCargas = historicoCargas;
	}

	public List<HistoricoRepeticao> getHistoricoRepeticoes() {
		return historicoRepeticoes;
	}

	public void setHistoricoRepeticoes(List<HistoricoRepeticao> historicoRepeticoes) {
		this.historicoRepeticoes = historicoRepeticoes;
	}

	public String getUidDivisao() {
		return uidDivisao;
	}

	public void setUidDivisao(String uidDivisao) {
		this.uidDivisao = uidDivisao;
	}
	

}
