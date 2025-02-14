package br.com.geekpump.service.exercicio;

import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.dao.exercicio.ExercicioDAO;
import br.com.geekpump.entity.Exercicio;
import br.com.geekpump.entity.TreinoUsuarioDivisao;
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

	@Override
	public void incluir(Exercicio entidade) {
		entidade.setUid(UUID.randomUUID().toString());
		super.incluir(entidade);
	}
	
	public Exercicio recuperarPorNome(String nome) {
		return exercicioDAO.recuperarPorNome(nome);
	}

	public Integer countPorTreinoUsuarioDivisao(TreinoUsuarioDivisao divisao) {
		return exercicioDAO.countPorTreinoUsuarioDivisao(divisao);
	}
	
	

}
