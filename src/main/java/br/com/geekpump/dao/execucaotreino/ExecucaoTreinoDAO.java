package br.com.geekpump.dao.execucaotreino;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.entity.ExecucaoTreino;
import br.com.geekpump.entity.TreinoUsuarioDivisaoExercicio;
import br.com.geekpump.util.UtilData;

public class ExecucaoTreinoDAO extends AbstractDAO<ExecucaoTreino> {

	public List<ExecucaoTreino> pesquisarPorTreinoUsuarioDivisaoExercicioData(
			TreinoUsuarioDivisaoExercicio treinoUsuarioDivisaoExercicio, Date data) {

		CriteriaQuery<ExecucaoTreino> criteria=getCriteriaBuilder().createQuery(ExecucaoTreino.class);
		Root<ExecucaoTreino> root = criteria.from(ExecucaoTreino.class);
		Predicate[] predicates = {
				getCriteriaBuilder().equal(root.get("treinoUsuarioDivisaoExercicio"),treinoUsuarioDivisaoExercicio),
				getCriteriaBuilder().between(root.get("dataExecucao"), UtilData.ajustaData(data, 0, 0, 0), 
						UtilData.ajustaData(data, 23, 59, 59))
		};
		return getManager().createQuery(criteria.select(root).where(predicates)).getResultList();
	}

}
