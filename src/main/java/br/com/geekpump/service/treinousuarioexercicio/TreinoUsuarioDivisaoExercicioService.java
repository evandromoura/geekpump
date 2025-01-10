package br.com.geekpump.service.treinousuarioexercicio;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.geekpump.dao.AbstractDAO;
import br.com.geekpump.dao.treinousuarioexercicio.TreinoUsuarioDivisaoExercicioDAO;
import br.com.geekpump.entity.TreinoUsuarioDivisao;
import br.com.geekpump.entity.TreinoUsuarioDivisaoExercicio;
import br.com.geekpump.service.AbstractService;
import br.com.geekpump.service.treinousuariodivisao.TreinoUsuarioDivisaoService;

@Stateless
public class TreinoUsuarioDivisaoExercicioService extends AbstractService<TreinoUsuarioDivisaoExercicio>{

	private @Inject TreinoUsuarioDivisaoService treinoUsuarioDivisaoService;
	private @Inject TreinoUsuarioDivisaoExercicioDAO treinoUsuarioDivisaoExercicioDAO; 
	
	@Override
	public AbstractDAO<TreinoUsuarioDivisaoExercicio> getDAO() {
		return treinoUsuarioDivisaoExercicioDAO;
	}

	public List<TreinoUsuarioDivisaoExercicio> pesquisarPorUidTreinoUsuarioDivisao(String uidTreinoUsuarioDivisao, Date data, boolean executado) {
		TreinoUsuarioDivisao treinoUsuarioDivisao = treinoUsuarioDivisaoService.recuperarPorUid(uidTreinoUsuarioDivisao);
		return treinoUsuarioDivisaoExercicioDAO.pesquisarPorTreinoUsuarioDivisao(treinoUsuarioDivisao,data,executado);
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString());	
	}
	
}