package br.com.geekpump.dao.treinousuarioexercicio;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.entity.TreinoUsuario;
import br.com.geekpump.entity.TreinoUsuarioDivisaoExercicio;

public class TreinoUsuarioExercicioDAO extends AbstractDAO<TreinoUsuarioDivisaoExercicio> {

	public List<TreinoUsuarioDivisaoExercicio> pesquisarPorTreinoUsuario(TreinoUsuario treinoUsuario) {
		CriteriaQuery<TreinoUsuarioDivisaoExercicio> criteria = getCriteriaBuilder().createQuery(TreinoUsuarioDivisaoExercicio.class);
		Root<TreinoUsuarioDivisaoExercicio> root = criteria.from(TreinoUsuarioDivisaoExercicio.class);
		return getManager().createQuery(
				criteria.select(root).where(getCriteriaBuilder().equal(root.get("treinoUsuario"), treinoUsuario)))
				.getResultList();
	}

 
}
