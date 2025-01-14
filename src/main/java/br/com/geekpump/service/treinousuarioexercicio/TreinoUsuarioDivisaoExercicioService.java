package br.com.geekpump.service.treinousuarioexercicio;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.dao.treinousuarioexercicio.TreinoUsuarioDivisaoExercicioDAO;
import br.com.geekpump.entity.Exercicio;
import br.com.geekpump.entity.TreinoUsuarioDivisao;
import br.com.geekpump.entity.TreinoUsuarioDivisaoExercicio;
import br.com.geekpump.service.AbstractService;
import br.com.geekpump.service.execucaotreino.ExecucaoTreinoService;

@Stateless
public class TreinoUsuarioDivisaoExercicioService extends AbstractService<TreinoUsuarioDivisaoExercicio>{

	private @Inject TreinoUsuarioDivisaoExercicioDAO treinoUsuarioDivisaoExercicioDAO; 
	
	private @Inject ExecucaoTreinoService execucaoTreinoService;
	
	@Override
	public AbstractDAO<TreinoUsuarioDivisaoExercicio> getDAO() {
		return treinoUsuarioDivisaoExercicioDAO;
	}

	public List<TreinoUsuarioDivisaoExercicio> pesquisarPorTreinoUsuarioDivisao(TreinoUsuarioDivisao treinoUsuarioDivisao, Date data, boolean executado) {
		List<TreinoUsuarioDivisaoExercicio> retorno = treinoUsuarioDivisaoExercicioDAO.pesquisarPorTreinoUsuarioDivisao(treinoUsuarioDivisao,data,executado);
		for(TreinoUsuarioDivisaoExercicio exercicio:retorno) {
			exercicio.setExecucoesTemp(execucaoTreinoService.pesquisarPorTreinoUsuarioDivisaoExercicioData(exercicio, data));
		}
		return retorno;
	}
	
	public Long countPorExercicioDivisao(Exercicio exercicio, TreinoUsuarioDivisao treinoUsuarioDivisao){
		return treinoUsuarioDivisaoExercicioDAO.countPorExercicioDivisao(exercicio,treinoUsuarioDivisao);
	}
	
	
	
	@Override
	public void incluir(TreinoUsuarioDivisaoExercicio entidade) {
		entidade.setUid(UUID.randomUUID().toString());
		super.incluir(entidade);
	}

	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString());	
	}

	public TreinoUsuarioDivisaoExercicio recuperarPorUid(String uid) {

		return treinoUsuarioDivisaoExercicioDAO.recuperarPorUid(uid);
	}
	
}