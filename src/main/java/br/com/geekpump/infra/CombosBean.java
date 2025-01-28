package br.com.geekpump.infra;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.geekpump.entity.GeneroEnum;
import br.com.geekpump.entity.GrupamentoMuscular;
import br.com.geekpump.entity.PerfilEnum;
import br.com.geekpump.service.grupamentomuscular.GrupamentoMuscularService;

@Named
public class CombosBean {

	
	private @Inject GrupamentoMuscularService grupamentoMuscularService;
	
	public PerfilEnum[] getPerfis() {
		return PerfilEnum.values();
	}
	
	public List<GrupamentoMuscular> getGrupamentoMusculares(){
		return grupamentoMuscularService.listar();
	}
	
	public GeneroEnum[] getGeneros() {
		return GeneroEnum.values();
	}
}
