package br.com.geekpump.infra;

import javax.inject.Named;

import br.com.geekpump.entity.PerfilEnum;

@Named
public class CombosBean {

	
	public PerfilEnum[] getPerfis() {
		return PerfilEnum.values();
	}
}
