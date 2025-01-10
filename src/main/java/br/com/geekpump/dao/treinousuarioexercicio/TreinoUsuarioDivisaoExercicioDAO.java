package br.com.geekpump.dao.treinousuarioexercicio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.entity.ExecucaoTreino;
import br.com.geekpump.entity.TreinoUsuarioDivisao;
import br.com.geekpump.entity.TreinoUsuarioDivisaoExercicio;
import br.com.geekpump.util.UtilData;

public class TreinoUsuarioDivisaoExercicioDAO extends AbstractDAO<TreinoUsuarioDivisaoExercicio> {

	
	
	public List<TreinoUsuarioDivisaoExercicio> pesquisarPorTreinoUsuarioDivisao(TreinoUsuarioDivisao treinoUsuarioDivisao,Date data, boolean executado) {
		CriteriaQuery<TreinoUsuarioDivisaoExercicio> criteria = getCriteriaBuilder().createQuery(TreinoUsuarioDivisaoExercicio.class);
		Root<TreinoUsuarioDivisaoExercicio> root = criteria.from(TreinoUsuarioDivisaoExercicio.class);
		return getManager().createQuery(
				criteria.select(root).where(comporPredicates(root, treinoUsuarioDivisao, data, executado)))
				.getResultList();
	}
	
	private Predicate[] comporPredicates(Root<TreinoUsuarioDivisaoExercicio> root, TreinoUsuarioDivisao treinoUsuarioDivisao,Date data, boolean executado) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		predicates.add(getCriteriaBuilder().equal(root.get("treinoUsuarioDivisao"), treinoUsuarioDivisao));
		if(executado) {
			Date dataInicio = UtilData.ajustaData(data, 0, 0, 0);
			Date dataFim = UtilData.ajustaData(data, 23, 59, 59);
			Join<TreinoUsuarioDivisaoExercicio, ExecucaoTreino> join = root.join("execucoes",JoinType.LEFT);
			predicates.add(getCriteriaBuilder().greaterThan(join.get("dataExecucao"),dataInicio));
			predicates.add(getCriteriaBuilder().lessThan(join.get("dataExecucao"),dataFim));
		}else {
			
			//NAO EXECUTADOS
		}
		return (Predicate[]) predicates.toArray(new Predicate[predicates.size()]);
		
		
	}

 
}
