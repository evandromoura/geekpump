package br.com.geekpump.service.historicorepeticao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.dao.historicorepeticao.HistoricoRepeticaoDAO;
import br.com.geekpump.entity.Exercicio;
import br.com.geekpump.entity.HistoricoCarga;
import br.com.geekpump.entity.HistoricoRepeticao;
import br.com.geekpump.entity.Usuario;
import br.com.geekpump.service.AbstractService;

@Stateless
public class HistoricoRepeticaoService extends AbstractService<HistoricoRepeticao> {
	
	private @Inject HistoricoRepeticaoDAO historicoRepeticaoDAO;

	@Override
	public AbstractDAO<HistoricoRepeticao> getDAO() {
		return historicoRepeticaoDAO;
	}
	
	public HistoricoRepeticao recuperarUltimaRepeticaoExercicioUsuario(Exercicio exercicio, Usuario usuario){
		return historicoRepeticaoDAO.recuperarUltimaRepeticaoExercicioUsuario(exercicio, usuario);
	}
	
	public List<HistoricoRepeticao> pesquisarPorExercicioUsuario(Exercicio exercicio, Usuario usuario){
		return historicoRepeticaoDAO.pesquisarPorExercicioUsuario(exercicio, usuario);
	}
	
}

