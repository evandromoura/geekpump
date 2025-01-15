package br.com.geekpump.dao.exercicioimagem;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.entity.ExercicioImagem;

public class ExercicioImagemDAO extends AbstractDAO<ExercicioImagem> {

	public ExercicioImagem recuperarPorUidExercicio(String uid) {

		CriteriaQuery<ExercicioImagem> criteria = getCriteriaBuilder().createQuery(ExercicioImagem.class);
		Root<ExercicioImagem> root = criteria.from(ExercicioImagem.class);
				
		return getManager().createQuery(criteria.select(root).where(
					getCriteriaBuilder().equal(root.join("exercicio", JoinType.LEFT).get("uid"),uid)
				)).setMaxResults(1).getSingleResult();
	}

	

}
