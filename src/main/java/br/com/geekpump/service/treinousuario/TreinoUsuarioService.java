package br.com.geekpump.service.treinousuario;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.dao.treinousuario.TreinoUsuarioDAO;
import br.com.geekpump.entity.TreinoUsuario;
import br.com.geekpump.entity.Usuario;
import br.com.geekpump.service.AbstractService;

@Stateless
public class TreinoUsuarioService extends AbstractService<TreinoUsuario>{

	private @Inject TreinoUsuarioDAO treinoUsuarioDAO;
	
	@Override
	public AbstractDAO<TreinoUsuario> getDAO() {
		return treinoUsuarioDAO;
	}
	
	public List<TreinoUsuario> pesquisarPorUsuario(Usuario usuario){
		return treinoUsuarioDAO.pesquisarPorUsuario(usuario);
	}
	
	public TreinoUsuario recuperarPorUid(String uid) {
		return treinoUsuarioDAO.recuperarPorUid(uid);
	}
	
	
	
}