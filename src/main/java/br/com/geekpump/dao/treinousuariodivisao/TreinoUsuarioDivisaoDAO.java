package br.com.geekpump.dao.treinousuariodivisao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.entity.TreinoUsuario;
import br.com.geekpump.entity.TreinoUsuarioDivisao;

public class TreinoUsuarioDivisaoDAO extends AbstractDAO<TreinoUsuarioDivisao> {

	public TreinoUsuarioDivisao recuperarPorUid(String uidTreinoUsuarioDivisao) {
		CriteriaQuery<TreinoUsuarioDivisao> criteria = getCriteriaBuilder().createQuery(TreinoUsuarioDivisao.class);
		Root<TreinoUsuarioDivisao> root = criteria.from(TreinoUsuarioDivisao.class);
		return getManager().createQuery(
				criteria.select(root).where(getCriteriaBuilder().equal(root.get("uid"), uidTreinoUsuarioDivisao)))
				.getSingleResult();
	}
	
	public List<TreinoUsuarioDivisao> pesquisarPorTreinoUsuario(TreinoUsuario treinoUsuario) {
		CriteriaQuery<TreinoUsuarioDivisao> criteria = getCriteriaBuilder().createQuery(TreinoUsuarioDivisao.class);
		Root<TreinoUsuarioDivisao> root = criteria.from(TreinoUsuarioDivisao.class);
		return getManager().createQuery(
				criteria.select(root).where(getCriteriaBuilder().equal(root.get("treinoUsuario"), treinoUsuario)).orderBy(getCriteriaBuilder().asc(root.get("id"))))
				.getResultList();
	}

}
