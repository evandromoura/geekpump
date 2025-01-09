package br.com.geekpump.dao.treinousuario;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.entity.TreinoUsuario;
import br.com.geekpump.entity.Usuario;

public class TreinoUsuarioDAO extends AbstractDAO<TreinoUsuario> {

	public List<TreinoUsuario> pesquisarPorUsuario(Usuario usuario) {
		CriteriaQuery<TreinoUsuario> criteria = getCriteriaBuilder().createQuery(TreinoUsuario.class);
		Root<TreinoUsuario> root = criteria.from(TreinoUsuario.class);
		Predicate[] predicates = {getCriteriaBuilder().equal(root.get("usuario"), usuario)};
		return getManager().createQuery(criteria.select(root).where(predicates)).getResultList();
	}

	public TreinoUsuario recuperarPorUid(String uid) {
		CriteriaQuery<TreinoUsuario> criteria = getCriteriaBuilder().createQuery(TreinoUsuario.class);
		Root<TreinoUsuario> root = criteria.from(TreinoUsuario.class);
		return getManager().createQuery(criteria.select(root).where(getCriteriaBuilder().equal(root.get("uid"), uid))).getSingleResult();
	}
 
}
