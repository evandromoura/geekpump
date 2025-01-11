package br.com.geekpump.service.treinousuariodivisao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.dao.treinousuariodivisao.TreinoUsuarioDivisaoDAO;
import br.com.geekpump.entity.TreinoUsuario;
import br.com.geekpump.entity.TreinoUsuarioDivisao;
import br.com.geekpump.service.AbstractService;

@Stateless
public class TreinoUsuarioDivisaoService extends AbstractService<TreinoUsuarioDivisao> {

	private @Inject TreinoUsuarioDivisaoDAO treinoUsuarioDivisaoDAO;
	
	@Override
	public AbstractDAO<TreinoUsuarioDivisao> getDAO() {
		return treinoUsuarioDivisaoDAO;
	}

	public List<TreinoUsuarioDivisao> pesquisarPorTreinoUsuario(TreinoUsuario treinoUsuario) {
		return treinoUsuarioDivisaoDAO.pesquisarPorTreinoUsuario(treinoUsuario);
	}
	
	public TreinoUsuarioDivisao recuperarPorUid(String uidTreinoUsuarioDivisao) {
		return treinoUsuarioDivisaoDAO.recuperarPorUid(uidTreinoUsuarioDivisao);
	}

}
