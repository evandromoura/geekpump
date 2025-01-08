package br.com.geekpump.service.exercicio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.dao.exercicio.ExercicioDAO;
import br.com.geekpump.entity.Exercicio;
import br.com.geekpump.service.AbstractService;

@Stateless
public class ExercicioService extends AbstractService<Exercicio> {

	
	private @Inject ExercicioDAO exercicioDAO;
	
	@Override
	public AbstractDAO<Exercicio> getDAO() {
		return exercicioDAO;
	}

	public List<Exercicio> pesquisar(Exercicio exercicio){
		
		return exercicioDAO.pesquisar(exercicio);
	}

}
