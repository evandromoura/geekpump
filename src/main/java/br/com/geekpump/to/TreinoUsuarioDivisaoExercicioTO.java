package br.com.geekpump.to;

import java.util.Date;
import java.util.List;

import br.com.geekpump.entity.TreinoUsuarioDivisaoExercicio;

public class TreinoUsuarioDivisaoExercicioTO {
	
	private List<TreinoUsuarioDivisaoExercicio> treinoUsuarioExercicios;
	private List<TreinoUsuarioDivisaoExercicio> treinoUsuarioExerciciosExecutados;
	
	private Date data;

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
	

}
