package br.com.geekpump.dao.historicocarga;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.entity.Exercicio;
import br.com.geekpump.entity.HistoricoCarga;
import br.com.geekpump.entity.Usuario;

public class HistoricoCargaDAO extends AbstractDAO<HistoricoCarga> {
	
	
	public List<HistoricoCarga> pesquisarPorExercicioUsuario(Exercicio exercicio, Usuario usuario){
		CriteriaQuery<HistoricoCarga> criteria = getCriteriaBuilder().createQuery(HistoricoCarga.class);
		Root<HistoricoCarga> root = criteria.from(HistoricoCarga.class);
		return getManager().createQuery(criteria.select(root).where(
					getCriteriaBuilder().equal(root.get("exercicio"), exercicio),
					getCriteriaBuilder().equal(root.get("usuario"), usuario)
				).orderBy(getCriteriaBuilder().asc(root.get("dataCarga")))).getResultList();
	}
	
	public HistoricoCarga recuperarUltimaCargaExercicioUsuario(Exercicio exercicio, Usuario usuario){
		try {
			CriteriaQuery<HistoricoCarga> criteria = getCriteriaBuilder().createQuery(HistoricoCarga.class);
			Root<HistoricoCarga> root = criteria.from(HistoricoCarga.class);
			return getManager().createQuery(criteria.select(root).where(
						getCriteriaBuilder().equal(root.get("exercicio"), exercicio),
						getCriteriaBuilder().equal(root.get("usuario"), usuario)
					).orderBy(getCriteriaBuilder().desc(root.get("dataCarga")))).setMaxResults(1).getSingleResult();
		}catch(Exception e) {
			return null;
		}
	}
		
}
