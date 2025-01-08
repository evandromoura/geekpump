package br.com.geekpump.service.grupamentomuscular;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.dao.grupamentomuscular.GrupamentoMuscularDAO;
import br.com.geekpump.entity.GrupamentoMuscular;
import br.com.geekpump.service.AbstractService;

@Stateless
public class GrupamentoMuscularService extends AbstractService<GrupamentoMuscular> {

	private @Inject GrupamentoMuscularDAO grupamentoMuscularDAO;
	
	@Override
	public AbstractDAO<GrupamentoMuscular> getDAO() {
		return grupamentoMuscularDAO;
	}

}
