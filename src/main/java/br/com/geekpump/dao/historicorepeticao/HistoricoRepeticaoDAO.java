package br.com.geekpump.dao.historicorepeticao;

import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.entity.Exercicio;
import br.com.geekpump.entity.HistoricoRepeticao;
import br.com.geekpump.entity.Usuario;

public class HistoricoRepeticaoDAO extends AbstractDAO<HistoricoRepeticao> {

	public List<HistoricoRepeticao> pesquisarPorExercicioUsuario(Exercicio exercicio, Usuario usuario) {
		CriteriaQuery<HistoricoRepeticao> criteria = getCriteriaBuilder().createQuery(HistoricoRepeticao.class);
		Root<HistoricoRepeticao> root = criteria.from(HistoricoRepeticao.class);
		return getManager().createQuery(criteria.select(root)
				.where(getCriteriaBuilder().equal(root.get("exercicio"), exercicio),
						getCriteriaBuilder().equal(root.get("usuario"), usuario))
				.orderBy(getCriteriaBuilder().asc(root.get("dataRepeticao")))).getResultList();
	}

	public HistoricoRepeticao recuperarUltimaRepeticaoExercicioUsuario(Exercicio exercicio, Usuario usuario) {
		try {
			CriteriaQuery<HistoricoRepeticao> criteria = getCriteriaBuilder().createQuery(HistoricoRepeticao.class);
			Root<HistoricoRepeticao> root = criteria.from(HistoricoRepeticao.class);
			return getManager()
					.createQuery(criteria.select(root)
							.where(getCriteriaBuilder().equal(root.get("exercicio"), exercicio),
									getCriteriaBuilder().equal(root.get("usuario"), usuario))
							.orderBy(getCriteriaBuilder().desc(root.get("dataRepeticao"))))
					.setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
}
