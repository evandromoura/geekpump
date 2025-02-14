package br.com.geekpump.service.execucaotreino;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.dao.execucaotreino.ExecucaoTreinoExercicioDAO;
import br.com.geekpump.entity.ExecucaoTreinoExercicio;
import br.com.geekpump.entity.TreinoUsuarioDivisao;
import br.com.geekpump.entity.TreinoUsuarioDivisaoExercicio;
import br.com.geekpump.service.AbstractService;

@Stateless
public class ExecucaoTreinoExercicioService extends AbstractService<ExecucaoTreinoExercicio> {

	private @Inject ExecucaoTreinoExercicioDAO execucaoTreinoExercicioDAO;
	
	@Override
	public AbstractDAO<ExecucaoTreinoExercicio> getDAO() {
		return execucaoTreinoExercicioDAO;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void incluir(ExecucaoTreinoExercicio entidade) {
		execucaoTreinoExercicioDAO.incluir(entidade);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void excluir(ExecucaoTreinoExercicio entidade) {
		execucaoTreinoExercicioDAO.excluir(entidade);
	}
	
	public List<ExecucaoTreinoExercicio> pesquisarPorTreinoUsuarioDivisaoExercicioData(TreinoUsuarioDivisaoExercicio treinoUsuarioDivisaoExercicio, Date data){
		return execucaoTreinoExercicioDAO.pesquisarPorTreinoUsuarioDivisaoExercicioData(treinoUsuarioDivisaoExercicio,data);
		
	}
	
	public List<ExecucaoTreinoExercicio> pesquisarPorTreinoUsuarioDivisaoData(List<TreinoUsuarioDivisao> treinoUsuarioDivisoes, Date data){
		return execucaoTreinoExercicioDAO.pesquisarPorTreinoUsuarioDivisaoData(treinoUsuarioDivisoes,data);
		
	}
	
}
