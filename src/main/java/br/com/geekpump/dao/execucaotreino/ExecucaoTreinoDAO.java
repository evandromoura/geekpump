package br.com.geekpump.dao.execucaotreino;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.entity.ExecucaoTreino;
import br.com.geekpump.entity.TreinoUsuarioDivisao;
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
	
	public List<ExecucaoTreino> pesquisarPorTreinoUsuarioDivisaoData(
			List<TreinoUsuarioDivisao> treinoUsuarioDivisoes, Date data) {
		CriteriaQuery<ExecucaoTreino> criteria=getCriteriaBuilder().createQuery(ExecucaoTreino.class);
		Root<ExecucaoTreino> root = criteria.from(ExecucaoTreino.class);
		Predicate[] predicates = {
				root.get("treinoUsuarioDivisaoExercicio").get("treinoUsuarioDivisao").in(treinoUsuarioDivisoes),
				getCriteriaBuilder().greaterThanOrEqualTo(root.get("dataExecucao"), UtilData.ajustaData(data, 0, 0, 0)),
				getCriteriaBuilder().lessThanOrEqualTo(root.get("dataExecucao"), UtilData.ajustaData(data, 23, 59, 59))
		};
		return inicializarLista(getManager().createQuery(criteria.select(root).where(predicates).orderBy(getCriteriaBuilder().asc(root.get("dataExecucao")))).getResultList());
	}
	
	
	public List<ExecucaoTreino> inicializarLista(List<ExecucaoTreino> execucoes){
		
//		for(ExecucaoTreino execucao:execucoes) {
//			if(execucao.getTreinoUsuarioDivisaoExercicio().getTreinoUsuarioDivisao().getExercicios() != null) {
//				execucao.getTreinoUsuarioDivisaoExercicio().getTreinoUsuarioDivisao().getExercicios().size();
//			}
//		}
		
		return execucoes;
	}

}
