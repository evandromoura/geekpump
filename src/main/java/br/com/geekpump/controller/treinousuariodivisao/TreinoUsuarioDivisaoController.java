package br.com.geekpump.controller.treinousuariodivisao;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.geekpump.controller.AbstractController;
import br.com.geekpump.service.treinousuario.TreinoUsuarioService;
import br.com.geekpump.service.treinousuariodivisao.TreinoUsuarioDivisaoService;
import br.com.geekpump.to.TreinoUsuarioDivisaoTO;


@Named
@ViewScoped
public class TreinoUsuarioDivisaoController extends AbstractController<TreinoUsuarioDivisaoTO> implements Serializable{
	
	private static final long serialVersionUID = 5893208120396926784L;
	
	private @Inject TreinoUsuarioDivisaoService treinoUsuarioDivisaoService;
	private @Inject TreinoUsuarioService treinoUsuarioService;
			
	
	@PostConstruct
	private void init() {
		pesquisar();
		inicializarValores();
	}
	
	public void pesquisar() {
		getTo().setTreinoUsuario(treinoUsuarioService.recuperarPorUid(getRequest().getParameter("parametro")));
		getTo().setTreinoUsuarioDivisoes(
			treinoUsuarioDivisaoService.pesquisarPorTreinoUsuario(getTo().getTreinoUsuario()));
	}
	
	public void gravar() {
		if(getTo().getTreinoUsuarioDivisao().getId() == null) {
			getTo().getTreinoUsuarioDivisao().setTreinoUsuario(getTo().getTreinoUsuario());
			treinoUsuarioDivisaoService.incluir(getTo().getTreinoUsuarioDivisao());
		}else {
			treinoUsuarioDivisaoService.alterar(getTo().getTreinoUsuarioDivisao());
		}
		inicializarValores();
		pesquisar();
	}
	
	public void excluir() {
		treinoUsuarioDivisaoService.excluir(getTo().getTreinoUsuarioDivisaoAcao());
		pesquisar();
	}
	
	private void inicializarValores() {
		getTo().setTreinoUsuarioDivisao(null);
		getTo().getTreinoUsuarioDivisao().setCor("#ffffff");
	}

}
