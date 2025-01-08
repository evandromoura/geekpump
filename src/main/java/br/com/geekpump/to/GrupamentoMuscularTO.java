package br.com.geekpump.to;

import java.util.List;

import br.com.geekpump.entity.GrupamentoMuscular;

public class GrupamentoMuscularTO {
	
	private GrupamentoMuscular grupamentoMuscularAcao;
	private GrupamentoMuscular grupamentoMuscular;
	private List<GrupamentoMuscular> grupamentoMusculars;
	public GrupamentoMuscular getGrupamentoMuscularAcao() {
		return grupamentoMuscularAcao;
	}
	public void setGrupamentoMuscularAcao(GrupamentoMuscular grupamentoMuscularAcao) {
		this.grupamentoMuscularAcao = grupamentoMuscularAcao;
	}
	public GrupamentoMuscular getGrupamentoMuscular() {
		return grupamentoMuscular;
	}
	public void setGrupamentoMuscular(GrupamentoMuscular grupamentoMuscular) {
		this.grupamentoMuscular = grupamentoMuscular;
	}
	public List<GrupamentoMuscular> getGrupamentoMusculars() {
		return grupamentoMusculars;
	}
	public void setGrupamentoMusculars(List<GrupamentoMuscular> grupamentoMusculars) {
		this.grupamentoMusculars = grupamentoMusculars;
	}
	
	
}
