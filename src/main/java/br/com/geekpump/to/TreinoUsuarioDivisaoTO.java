package br.com.geekpump.to;

import java.util.List;

import br.com.geekpump.entity.TreinoUsuario;
import br.com.geekpump.entity.TreinoUsuarioDivisao;

public class TreinoUsuarioDivisaoTO {

	private TreinoUsuario treinoUsuario;
	private TreinoUsuarioDivisao treinoUsuarioDivisao;
	private TreinoUsuarioDivisao treinoUsuarioDivisaoAcao;
	
	private List<TreinoUsuarioDivisao> treinoUsuarioDivisoes;
	
	
	public TreinoUsuario getTreinoUsuario() {
		if (treinoUsuario == null) {
			treinoUsuario = new TreinoUsuario();
		}
		return treinoUsuario;
	}

	public void setTreinoUsuario(TreinoUsuario treinoUsuario) {
		this.treinoUsuario = treinoUsuario;
	}

	public TreinoUsuarioDivisao getTreinoUsuarioDivisao() {
		if (treinoUsuarioDivisao == null) {
			treinoUsuarioDivisao = new TreinoUsuarioDivisao();
		}
		return treinoUsuarioDivisao;
	}

	public void setTreinoUsuarioDivisao(TreinoUsuarioDivisao treinoUsuarioDivisao) {
		this.treinoUsuarioDivisao = treinoUsuarioDivisao;
	}
	
	public TreinoUsuarioDivisao getTreinoUsuarioDivisaoAcao() {
		if (treinoUsuarioDivisaoAcao == null) {
			treinoUsuarioDivisaoAcao = new TreinoUsuarioDivisao();
		}
		return treinoUsuarioDivisaoAcao;
	}

	public void setTreinoUsuarioDivisaoAcao(TreinoUsuarioDivisao treinoUsuarioDivisaoAcao) {
		this.treinoUsuarioDivisaoAcao = treinoUsuarioDivisaoAcao;
	}

	public List<TreinoUsuarioDivisao> getTreinoUsuarioDivisoes() {
		return treinoUsuarioDivisoes;
	}

	public void setTreinoUsuarioDivisoes(List<TreinoUsuarioDivisao> treinoUsuarioDivisoes) {
		this.treinoUsuarioDivisoes = treinoUsuarioDivisoes;
	}
	
	
}
