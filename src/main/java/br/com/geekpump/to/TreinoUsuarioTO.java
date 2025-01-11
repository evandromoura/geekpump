package br.com.geekpump.to;

import java.util.List;

import br.com.geekpump.entity.TreinoUsuario;

public class TreinoUsuarioTO {
	
	private TreinoUsuario treinoUsuario;
	private TreinoUsuario treinoUsuarioAcao;
	
	private List<TreinoUsuario> treinos;

	public TreinoUsuario getTreinoUsuario() {
		if (treinoUsuario == null) {
			treinoUsuario = new TreinoUsuario();
		}
		return treinoUsuario;

	}

	public void setTreinoUsuario(TreinoUsuario treinoUsuario) {
		this.treinoUsuario = treinoUsuario;
	}

	public List<TreinoUsuario> getTreinos() {
		return treinos;
	}

	public void setTreinos(List<TreinoUsuario> treinos) {
		this.treinos = treinos;
	}

	public TreinoUsuario getTreinoUsuarioAcao() {
		if (treinoUsuarioAcao == null) {
			treinoUsuarioAcao = new TreinoUsuario();
		}
		return treinoUsuarioAcao;
	}

	public void setTreinoUsuarioAcao(TreinoUsuario treinoUsuarioAcao) {
		this.treinoUsuarioAcao = treinoUsuarioAcao;
	}
	
	
}
