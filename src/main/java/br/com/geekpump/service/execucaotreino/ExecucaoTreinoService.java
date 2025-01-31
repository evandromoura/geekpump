package br.com.geekpump.service.execucaotreino;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.dao.execucaotreino.ExecucaoTreinoDAO;
import br.com.geekpump.entity.ExecucaoTreino;
import br.com.geekpump.entity.TreinoUsuarioDivisao;
import br.com.geekpump.entity.TreinoUsuarioDivisaoExercicio;
import br.com.geekpump.service.AbstractService;

@Stateless
public class ExecucaoTreinoService extends AbstractService<ExecucaoTreino> {

	private @Inject ExecucaoTreinoDAO execucaoTreinoDAO;
	
	@Override
	public AbstractDAO<ExecucaoTreino> getDAO() {
		return execucaoTreinoDAO;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void incluir(ExecucaoTreino entidade) {
		execucaoTreinoDAO.incluir(entidade);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void excluir(ExecucaoTreino entidade) {
		execucaoTreinoDAO.excluir(entidade);
	}
	
	public List<ExecucaoTreino> pesquisarPorTreinoUsuarioDivisaoExercicioData(TreinoUsuarioDivisaoExercicio treinoUsuarioDivisaoExercicio, Date data){
		return execucaoTreinoDAO.pesquisarPorTreinoUsuarioDivisaoExercicioData(treinoUsuarioDivisaoExercicio,data);
		
	}
	
	public List<ExecucaoTreino> pesquisarPorTreinoUsuarioDivisaoData(List<TreinoUsuarioDivisao> treinoUsuarioDivisoes, Date data){
		return execucaoTreinoDAO.pesquisarPorTreinoUsuarioDivisaoData(treinoUsuarioDivisoes,data);
		
	}
	
}
