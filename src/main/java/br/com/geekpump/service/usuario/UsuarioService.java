package br.com.geekpump.service.usuario;

import javax.ejb.Stateless;
import javax.inject.Inject;
import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.dao.usuario.UsuarioDAO;
import br.com.geekpump.entity.Usuario;
import br.com.geekpump.service.AbstractService;

@Stateless
public class UsuarioService extends AbstractService<Usuario>{

	private @Inject UsuarioDAO usuarioDAO;
	
	@Override
	public AbstractDAO<Usuario> getDAO() {
		return usuarioDAO;
	} 
}