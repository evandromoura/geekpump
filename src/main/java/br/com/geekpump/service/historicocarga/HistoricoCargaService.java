package br.com.geekpump.service.historicocarga;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.dao.historicocarga.HistoricoCargaDAO;
import br.com.geekpump.entity.HistoricoCarga;
import br.com.geekpump.service.AbstractService;

@Stateless
public class HistoricoCargaService extends AbstractService<HistoricoCarga> {
	
	private @Inject HistoricoCargaDAO historicoCargaDAO;
	@Override
	public AbstractDAO<HistoricoCarga> getDAO() {
		
		return historicoCargaDAO;
	}

	
	
}
