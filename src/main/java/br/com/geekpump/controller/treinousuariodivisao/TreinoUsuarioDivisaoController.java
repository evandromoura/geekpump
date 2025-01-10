package br.com.geekpump.controller.treinousuariodivisao;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.geekpump.controller.AbstractController;
import br.com.geekpump.service.treinousuariodivisao.TreinoUsuarioDivisaoService;
import br.com.geekpump.to.TreinoUsuarioDivisaoTO;


@Named
@ViewScoped
public class TreinoUsuarioDivisaoController extends AbstractController<TreinoUsuarioDivisaoTO> implements Serializable{
	
	private static final long serialVersionUID = 5893208120396926784L;
	
	private @Inject TreinoUsuarioDivisaoService treinoUsuarioDivisaoService;
	
	@PostConstruct
	private void init() {
		getTo().setTreinoUsuarioDivisoes(
				treinoUsuarioDivisaoService.pesquisarPorUidTreinoUsuario(getRequest().getParameter("parametro")));
	}

}
