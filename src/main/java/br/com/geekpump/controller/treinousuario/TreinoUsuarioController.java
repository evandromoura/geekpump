package br.com.geekpump.controller.treinousuario;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.geekpump.controller.AbstractController;
import br.com.geekpump.entity.TreinoUsuario;
import br.com.geekpump.security.CustomIdentity;
import br.com.geekpump.service.treinousuario.TreinoUsuarioService;
import br.com.geekpump.to.HomeTO;
import br.com.geekpump.to.TreinoUsuarioTO;


@Named
@ViewScoped
public class TreinoUsuarioController extends AbstractController<TreinoUsuarioTO> implements Serializable {

	private static final long serialVersionUID = 172034915448715026L;

	
	private @Inject TreinoUsuarioService treinoUsuarioService;
	private @Inject CustomIdentity customIdentity;
	
	@PostConstruct
	private void init() {
		pesquisar();
	}
	
	public void pesquisar() {
		getTo().setTreinos(treinoUsuarioService.pesquisarPorUsuario(customIdentity.getUsuario()));
	}
	
	
	public void gravar() {
		if(getTo().getTreinoUsuario().getId() == null) {
			getTo().getTreinoUsuario().setUsuario(customIdentity.getUsuario());
			treinoUsuarioService.incluir(getTo().getTreinoUsuario());
		}else {
			treinoUsuarioService.alterar(getTo().getTreinoUsuario());
		}
		getTo().setTreinoUsuario(null);
		pesquisar();
	}
	
	public void excluir() {
		treinoUsuarioService.excluir(getTo().getTreinoUsuarioAcao());
		pesquisar();
	}

	
}
