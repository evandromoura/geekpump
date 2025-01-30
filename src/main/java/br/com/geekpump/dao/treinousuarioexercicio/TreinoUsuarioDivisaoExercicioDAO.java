package br.com.geekpump.dao.treinousuarioexercicio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.entity.ExecucaoTreino;
import br.com.geekpump.entity.Exercicio;
import br.com.geekpump.entity.TreinoUsuarioDivisao;
import br.com.geekpump.entity.TreinoUsuarioDivisaoExercicio;
import br.com.geekpump.util.UtilData;

public class TreinoUsuarioDivisaoExercicioDAO extends AbstractDAO<TreinoUsuarioDivisaoExercicio> {

	
	
	public List<TreinoUsuarioDivisaoExercicio> pesquisarPorTreinoUsuarioDivisao(TreinoUsuarioDivisao treinoUsuarioDivisao,Date data, boolean executado) {
		CriteriaQuery<TreinoUsuarioDivisaoExercicio> criteria = getCriteriaBuilder().createQuery(TreinoUsuarioDivisaoExercicio.class);
		Root<TreinoUsuarioDivisaoExercicio> root = criteria.from(TreinoUsuarioDivisaoExercicio.class);
		return inicializar(getManager().createQuery(
				criteria.select(root).distinct(true).where(comporPredicates(root, treinoUsuarioDivisao, data, executado)).orderBy(getCriteriaBuilder().asc(root.get("id"))))
				.getResultList());
	}
	
	private Predicate[] comporPredicates(Root<TreinoUsuarioDivisaoExercicio> root, TreinoUsuarioDivisao treinoUsuarioDivisao,Date data, boolean executado) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		predicates.add(getCriteriaBuilder().equal(root.get("treinoUsuarioDivisao"), treinoUsuarioDivisao));
		if(executado) {
			Date dataInicio = UtilData.ajustaData(data, 0, 0, 0);
			Date dataFim = UtilData.ajustaData(data, 23, 59, 59);
			Join<TreinoUsuarioDivisaoExercicio, ExecucaoTreino> join = root.join("execucoes",JoinType.LEFT);
			predicates.add(getCriteriaBuilder().greaterThanOrEqualTo(join.get("dataExecucao"),dataInicio));
			predicates.add(getCriteriaBuilder().lessThanOrEqualTo(join.get("dataExecucao"),dataFim));
		}else {
			Subquery<Long> subquery = getCriteriaBuilder().createQuery().subquery(Long.class);
	        Root<ExecucaoTreino> subRoot = subquery.from(ExecucaoTreino.class);
	        subquery.select(subRoot.get("id"))
	                .where(
	                    getCriteriaBuilder().equal(subRoot.get("treinoUsuarioDivisaoExercicio"), root.get("id")),
	                    getCriteriaBuilder().between(subRoot.get("dataExecucao"),
	                            UtilData.ajustaData(data, 0, 0, 0),
	                            UtilData.ajustaData(data, 23, 59, 59))
	                );

	        predicates.add(getCriteriaBuilder().not(getCriteriaBuilder().exists(subquery)));
		}
		return (Predicate[]) predicates.toArray(new Predicate[predicates.size()]);
		
		
	}

	public Long countPorExercicioDivisao(Exercicio exercicio, TreinoUsuarioDivisao treinoUsuarioDivisao) {
		CriteriaQuery<Long> criteriaLong = getCriteriaBuilder().createQuery(Long.class);
		Root<TreinoUsuarioDivisaoExercicio> root = criteriaLong.from(TreinoUsuarioDivisaoExercicio.class);
		criteriaLong.select(getCriteriaBuilder().count(root)).where(getCriteriaBuilder().equal(root.get("exercicio"), exercicio),
				getCriteriaBuilder().equal(root.get("treinoUsuarioDivisao"), treinoUsuarioDivisao));
		return getManager().createQuery(criteriaLong).getSingleResult();
	}
	
	private List<TreinoUsuarioDivisaoExercicio> inicializar(List<TreinoUsuarioDivisaoExercicio> lista){
		for(TreinoUsuarioDivisaoExercicio treinoUsuarioDivisaoExercicio:lista) {
			inicializar(treinoUsuarioDivisaoExercicio);
		}
		return lista;
		
	}

	private TreinoUsuarioDivisaoExercicio inicializar(TreinoUsuarioDivisaoExercicio treinoUsuarioDivisaoExercicio) {
		if(treinoUsuarioDivisaoExercicio.getExercicio() != null) {
			if(treinoUsuarioDivisaoExercicio.getExercicio().getImagens() != null) {
				treinoUsuarioDivisaoExercicio.getExercicio().getImagens().size();
			}
		}
		return treinoUsuarioDivisaoExercicio;
	}

	public TreinoUsuarioDivisaoExercicio recuperarPorUid(String uid) {
		CriteriaQuery<TreinoUsuarioDivisaoExercicio> criteria = getCriteriaBuilder().createQuery(TreinoUsuarioDivisaoExercicio.class);
		Root<TreinoUsuarioDivisaoExercicio> root = criteria.from(TreinoUsuarioDivisaoExercicio.class);
		return inicializar(getManager().createQuery(
				criteria.select(root).where(getCriteriaBuilder().equal(root.get("uid"), uid))).getSingleResult());
	}

 
}
