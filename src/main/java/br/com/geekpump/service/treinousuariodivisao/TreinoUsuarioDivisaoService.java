package br.com.geekpump.service.treinousuariodivisao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.dao.treinousuariodivisao.TreinoUsuarioDivisaoDAO;
import br.com.geekpump.entity.TreinoUsuario;
import br.com.geekpump.entity.TreinoUsuarioDivisao;
import br.com.geekpump.service.AbstractService;
import br.com.geekpump.service.treinousuario.TreinoUsuarioService;

@Stateless
public class TreinoUsuarioDivisaoService extends AbstractService<TreinoUsuarioDivisao> {

	private @Inject TreinoUsuarioDivisaoDAO treinoUsuarioDivisaoDAO;
	private @Inject TreinoUsuarioService treinoUsuarioService;
	
	@Override
	public AbstractDAO<TreinoUsuarioDivisao> getDAO() {
		return treinoUsuarioDivisaoDAO;
	}

	public List<TreinoUsuarioDivisao> pesquisarPorUidTreinoUsuario(String uidTreinoUsuario) {
		TreinoUsuario treinoUsuario = treinoUsuarioService.recuperarPorUid(uidTreinoUsuario);
		return treinoUsuarioDivisaoDAO.pesquisarPorTreinoUsuario(treinoUsuario);
	}
	
	public TreinoUsuarioDivisao recuperarPorUid(String uidTreinoUsuarioDivisao) {
		return treinoUsuarioDivisaoDAO.recuperarPorUid(uidTreinoUsuarioDivisao);
	}

}
