package br.com.geekpump.dao.exercicio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.entity.Exercicio;
import br.com.geekpump.entity.TreinoUsuarioDivisao;

public class ExercicioDAO extends AbstractDAO<Exercicio> {

	public List<Exercicio> pesquisar(Exercicio exercicio) {
		
		CriteriaQuery<Exercicio> criteria = getCriteriaBuilder().createQuery(Exercicio.class);
		Root<Exercicio> root = criteria.from(Exercicio.class);
		List<Exercicio> exercicios = getManager()
				.createQuery(criteria.select(root)
						.where(comporFiltros(root, exercicio)).orderBy(getCriteriaBuilder().asc(root.get("nome"))))
				.getResultList();
		
		return inicializar(exercicios);
	}
	
	private Predicate[] comporFiltros(Root<Exercicio> root, Exercicio exercicio) {
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(exercicio.getNome() != null && !exercicio.getNome().equals("")) {
			predicates.add(getCriteriaBuilder().like(getCriteriaBuilder().lower(root.get("nome")), "%" + exercicio.getNome().toLowerCase() + "%"));
		}
		
		if(exercicio.getGrupamentoMuscular() != null && exercicio.getGrupamentoMuscular().getId() != null) {
			predicates.add(getCriteriaBuilder().equal(root.get("grupamentoMuscular"), exercicio.getGrupamentoMuscular()));
		}
		
		return (Predicate[]) predicates.toArray(new Predicate[predicates.size()]);
	}
	
	private List<Exercicio> inicializar(List<Exercicio> exercicios){
//		for(Exercicio exercicio:exercicios) {
//			if(exercicio.getImagens() != null) {
//				exercicio.getImagens().size(); 
//			}
//		}
		return exercicios;
	}

	public Integer countPorTreinoUsuarioDivisao(TreinoUsuarioDivisao divisao) {
		CriteriaQuery<Long> criteriaLong = getCriteriaBuilder().createQuery(Long.class);
		Root<Exercicio> root = criteriaLong.from(Exercicio.class);
		Predicate[] predicates  = {getCriteriaBuilder().equal(root.join("treinoUsuarioDivisaoExercicios", JoinType.LEFT).get("treinoUsuarioDivisao"),divisao)};
		criteriaLong.select(getCriteriaBuilder().count(root)).where(predicates);
		return getManager().createQuery(criteriaLong).getSingleResult().intValue();
	}

	public Exercicio recuperarPorNome(String nome) {
		try {
			CriteriaQuery<Exercicio> criteria = getCriteriaBuilder().createQuery(Exercicio.class);
			Root<Exercicio> root = criteria.from(Exercicio.class);
			return getManager().createQuery(criteria.select(root).where(getCriteriaBuilder().equal(root.get("nome"), nome))).setMaxResults(1).getSingleResult();
		}catch(Exception e) {
			return null;
		}
	}

}
