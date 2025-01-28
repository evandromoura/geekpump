package br.com.geekpump.controller.teste;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.geekpump.controller.AbstractController;
import br.com.geekpump.security.CustomIdentity;
import br.com.geekpump.service.imc.IMCService;
import br.com.geekpump.to.IMCTO;


@Named
@ViewScoped
public class IMCController extends AbstractController<IMCTO> implements Serializable{

	
	private static final long serialVersionUID = 5140346605944619491L;
	
	private @Inject IMCService imcService;
	
	private @Inject CustomIdentity customIdentity;
	
	@PostConstruct
	private void init() {
		getTo().setPeso(customIdentity.getUsuario().getPeso());
		getTo().setAltura(customIdentity.getUsuario().getAltura());
		getTo().setGenero(customIdentity.getUsuario().getGenero());
	}
	
	public void calcularIMC() {
		getTo().setResultado(imcService.calcularIMC(getTo().getGenero(), 
				Double.valueOf(getTo().getAltura()) / 100,
				Double.valueOf(getTo().getPeso())));
	}
	
}
