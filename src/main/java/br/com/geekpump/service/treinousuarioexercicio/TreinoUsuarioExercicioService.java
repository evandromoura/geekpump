package br.com.geekpump.service.treinousuarioexercicio;

import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.dao.treinousuarioexercicio.TreinoUsuarioExercicioDAO;
import br.com.geekpump.entity.TreinoUsuario;
import br.com.geekpump.entity.TreinoUsuarioDivisaoExercicio;
import br.com.geekpump.service.AbstractService;
import br.com.geekpump.service.treinousuario.TreinoUsuarioService;

@Stateless
public class TreinoUsuarioExercicioService extends AbstractService<TreinoUsuarioDivisaoExercicio>{

	private @Inject TreinoUsuarioService treinoUsuarioService;
	private @Inject TreinoUsuarioExercicioDAO treinoUsuarioExercicioDAO; 
	
	@Override
	public AbstractDAO<TreinoUsuarioDivisaoExercicio> getDAO() {
		return treinoUsuarioExercicioDAO;
	}

	public List<TreinoUsuarioDivisaoExercicio> pesquisarPorUidTreinoUsuario(String uidTreinoUsuario) {
		TreinoUsuario treinoUsuario = treinoUsuarioService.recuperarPorUid(uidTreinoUsuario);
		return treinoUsuarioExercicioDAO.pesquisarPorTreinoUsuario(treinoUsuario);
	}
	
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString());	
	}
	
}