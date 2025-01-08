package br.com.geekpump.dao.exercicio;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.entity.Exercicio;

public class ExercicioDAO extends AbstractDAO<Exercicio> {

	public List<Exercicio> pesquisar(Exercicio exercicio) {
		
		CriteriaQuery<Exercicio> criteria = getCriteriaBuilder().createQuery(Exercicio.class);
		Root<Exercicio> root = criteria.from(Exercicio.class);
		List<Exercicio> exercicios = getManager()
				.createQuery(criteria.select(root)
						.where(getCriteriaBuilder().like(getCriteriaBuilder().lower(root.get("nome")), "%" + exercicio.getNome().toLowerCase() + "%")))
				.getResultList();
		
		return exercicios;
	}

}
