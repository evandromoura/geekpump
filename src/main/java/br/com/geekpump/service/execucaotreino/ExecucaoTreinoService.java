package br.com.geekpump.service.execucaotreino;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.dao.execucaotreino.ExecucaoTreinoDAO;
import br.com.geekpump.entity.ExecucaoTreino;
import br.com.geekpump.service.AbstractService;

@Stateless
public class ExecucaoTreinoService extends AbstractService<ExecucaoTreino> {

	private @Inject ExecucaoTreinoDAO execucaoTreinoDAO;
	
	@Override
	public AbstractDAO<ExecucaoTreino> getDAO() {
		return execucaoTreinoDAO;
	}
}
