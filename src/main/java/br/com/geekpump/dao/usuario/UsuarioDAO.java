package br.com.geekpump.dao.usuario;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.entity.Usuario;

public class UsuarioDAO extends AbstractDAO<Usuario> {
 
	public Usuario login(String login, String senha) {
		try {
			CriteriaQuery<Usuario> criteria = getCriteriaBuilder().createQuery(Usuario.class);
			Root<Usuario> root = criteria.from(Usuario.class);
			Predicate[] predicates = {
					getCriteriaBuilder().equal(root.get("login"), login), 
					getCriteriaBuilder().equal(root.get("senha"), senha)
			};
			return getManager().createQuery(criteria.select(root).where(predicates)).getSingleResult();
		
		}catch(Exception e) {
			return null;
		}
	}
}
