package br.com.geekpump.dao;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;

import br.com.geekpump.util.UtilBeans;


public class AbstractDAO<T> {

	@PersistenceContext(unitName="geekpump")
	private EntityManager manager;
	
	
	protected EntityManager getManager() {
		return this.manager;
	}
	
	protected CriteriaBuilder getCriteriaBuilder() {
		return this.manager.getCriteriaBuilder();
	}
	
	public void incluir(T entidade){
		getManager().persist(entidade);
	}
	
	public void alterar(T entidade){
		getManager().merge(entidade);
	}
	
	public void excluir(T entidade){
		this.getManager().remove(this.getManager().find(this.getEntityType(),getIdValue(entidade)));
	}
	
	public T recuperar(Serializable id){
		T r = (T) this.getManager().find(this.getEntityType(), id);
		if(r == null){
//			throw new BusinessException(ConstantesMensagem.NENHUM_REGISTRO_ENCONTRADO);
		}
		return r;
	}
	
	protected Class getEntityType() {
		ParameterizedType parameterizedType =
				(ParameterizedType) this.getClass().getGenericSuperclass();
		Class entityType =
				(Class) parameterizedType.getActualTypeArguments()[0];
		return entityType;
	}
	

	/**
	 * Retorna o id do objeto parametrizado
	 * 
	 * @param entity
	 *            Entidade que contem o id
	 * @return id Object
	 */
	private Map<String, Object> getId(Object entity) {
		Map<String, Object> mapa = new HashMap<String, Object>();

		try {
			Set<Field> fields = UtilBeans.getAllFields(entity.getClass());
			GOTO: for (Field field : fields) {
				Annotation[] annotationsFields = field.getAnnotations();
				for (Annotation annotation : annotationsFields) {
					if (annotation.annotationType().equals(Id.class)
							|| annotation.annotationType().equals(
									EmbeddedId.class)) {
						field.setAccessible(true);
						mapa.put(field.getName(), field.get(entity));
						break GOTO;
					}
				}
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(
					"Nao foi possivel encontrar o Id da Entidade "
							.concat(entity.getClass().getName()));
		}

		return mapa;
	}

	/**
	 * Retorna o Nome da Propriedade que representa a chave primaria da Entidade
	 * 
	 * @return string Nome do campo Id
	 */
	private String getIdName(T entity) {
		final Map<String, Object> id = this.getId(entity);
		return id.keySet().iterator().next();
	}

	private Object getIdValue(T entity) {
		return this.getId(entity).get(this.getIdName(entity));
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listar(){
		return this.getManager().createQuery(
				"FROM ".concat(this.getEntityType().getName())).getResultList();
	}
	
	public void incluirLista(List<T> listaEntidade){
		for(T objeto:listaEntidade){
			this.incluir(objeto);
		}
	}
	public void alterarLista(List<T> listaEntidade){
		for(T objeto:listaEntidade){
			this.alterar(objeto);
		}
	}

	
}
