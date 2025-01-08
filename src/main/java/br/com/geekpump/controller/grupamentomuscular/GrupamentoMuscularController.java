package br.com.geekpump.controller.grupamentomuscular;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.geekpump.controller.AbstractController;
import br.com.geekpump.entity.GrupamentoMuscular;
import br.com.geekpump.service.grupamentomuscular.GrupamentoMuscularService;
import br.com.geekpump.to.GrupamentoMuscularTO;

@Named
@ViewScoped
public class GrupamentoMuscularController extends AbstractController<GrupamentoMuscularTO> implements Serializable{

	private static final long serialVersionUID = -5387795306843424936L;
	private @Inject GrupamentoMuscularService grupamentoMuscularService;
	
	@PostConstruct
	private void init() {
		if(getRequest().getParameter("parametro")!= null) {
			if(getRequest().getParameter("parametro").equals("new")) {
				getTo().setGrupamentoMuscular(new GrupamentoMuscular());
			}else {
				getTo().setGrupamentoMuscular(grupamentoMuscularService.recuperar(Integer.valueOf(getRequest().getParameter("parametro"))));
			}
		}else {
			getTo().setGrupamentoMusculars(grupamentoMuscularService.listar());
		}
	}
	
	public String gravar() {
		if(getTo().getGrupamentoMuscular().getId()==null) {
			grupamentoMuscularService.incluir(getTo().getGrupamentoMuscular());
		}else {
			grupamentoMuscularService.alterar(getTo().getGrupamentoMuscular());
		}
		return "sucesso";
	}
}