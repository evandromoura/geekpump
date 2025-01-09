package br.com.geekpump.dao.treinousuarioexercicio;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.entity.TreinoUsuario;
import br.com.geekpump.entity.TreinoUsuarioExercicio;

public class TreinoUsuarioExercicioDAO extends AbstractDAO<TreinoUsuarioExercicio> {

	public List<TreinoUsuarioExercicio> pesquisarPorTreinoUsuario(TreinoUsuario treinoUsuario) {
		CriteriaQuery<TreinoUsuarioExercicio> criteria = getCriteriaBuilder().createQuery(TreinoUsuarioExercicio.class);
		Root<TreinoUsuarioExercicio> root = criteria.from(TreinoUsuarioExercicio.class);
		return getManager().createQuery(
				criteria.select(root).where(getCriteriaBuilder().equal(root.get("treinoUsuario"), treinoUsuario)))
				.getResultList();
	}

 
}
