package br.com.geekpump.to;

import java.util.List;

import br.com.geekpump.entity.TreinoUsuario;

public class HomeTO {
	
	private Double imc;
	
	private List<TreinoUsuario> treinos;

	public List<TreinoUsuario> getTreinos() {
		return treinos;
	}

	public void setTreinos(List<TreinoUsuario> treinos) {
		this.treinos = treinos;
	}

	public Double getImc() {
		return imc;
	}

	public void setImc(Double imc) {
		this.imc = imc;
	}
	
	
}
