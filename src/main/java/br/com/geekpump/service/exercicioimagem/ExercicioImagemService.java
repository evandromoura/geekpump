package br.com.geekpump.service.exercicioimagem;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.dao.exercicioimagem.ExercicioImagemDAO;
import br.com.geekpump.entity.ExercicioImagem;
import br.com.geekpump.service.AbstractService;

@Stateless
public class ExercicioImagemService extends AbstractService<ExercicioImagem> {

	
	private @Inject ExercicioImagemDAO exercicioImagemDAO;
	
	@Override
	public AbstractDAO<ExercicioImagem> getDAO() {
		return exercicioImagemDAO;
	}

	public ExercicioImagem recuperarPorUidExercicio(String uid) {
		return exercicioImagemDAO.recuperarPorUidExercicio(uid);
	}


}
