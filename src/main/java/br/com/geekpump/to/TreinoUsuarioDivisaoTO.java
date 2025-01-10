package br.com.geekpump.to;

import java.util.List;

import br.com.geekpump.entity.TreinoUsuarioDivisao;

public class TreinoUsuarioDivisaoTO {

	private TreinoUsuarioDivisao treinoUsuarioDivisao;
	
	private List<TreinoUsuarioDivisao> treinoUsuarioDivisoes;

	public TreinoUsuarioDivisao getTreinoUsuarioDivisao() {
		return treinoUsuarioDivisao;
	}

	public void setTreinoUsuarioDivisao(TreinoUsuarioDivisao treinoUsuarioDivisao) {
		this.treinoUsuarioDivisao = treinoUsuarioDivisao;
	}

	public List<TreinoUsuarioDivisao> getTreinoUsuarioDivisoes() {
		return treinoUsuarioDivisoes;
	}

	public void setTreinoUsuarioDivisoes(List<TreinoUsuarioDivisao> treinoUsuarioDivisoes) {
		this.treinoUsuarioDivisoes = treinoUsuarioDivisoes;
	}
	
	
}
