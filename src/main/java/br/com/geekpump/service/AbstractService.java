package br.com.geekpump.service;

import java.io.Serializable;
import java.util.List;

import br.com.geekpump.dao.AbstractDAO;

public abstract class AbstractService<T> {

	public abstract AbstractDAO<T> getDAO();
	
    public void incluir(T entidade){
		getDAO().incluir(entidade);
	}
	
	public void alterar(T entidade){
		getDAO().alterar(entidade);
	}
	
	public void excluir(T entidade){
		getDAO().excluir(entidade);
	}
	
	public T recuperar(Serializable id){
		return getDAO().recuperar(id);
	}
	
	public List<T> listar(){
		return getDAO().listar();
	}
	
	public void incluirLista(List<T> listaEntidade){
		getDAO().incluirLista(listaEntidade);
	}
	
	
}
