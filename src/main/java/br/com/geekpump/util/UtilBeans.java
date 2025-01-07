package br.com.geekpump.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Classe utilitaria para manipulacao de Beans
 * @author Evandro Moura
 * 
 * 
 */
public class UtilBeans {

	/**
	 * Copia as propriedades de Objetos do mesmo tipo
	 * 
	 * @param <T>
	 *            Tipo do Objeto
	 * @param origem
	 *            Objeto de Origem
	 * @param destino
	 *            Objeto de Destino
	 */
	public <T> void copiarPropriedades(T origem, T destino) {
		try {
			if (origem == null || destino == null) {
				return;
			}
			Set<Field> fields = getAllFields(origem.getClass());
			for (Field field : fields) {
				field.setAccessible(true);
				Object value = field.get(origem);
				if (value != null && !Modifier.isFinal(field.getModifiers())) {
					field.set(destino, value);
				}
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(
					"Erro ao copiar as propriedades entre os objetos", e);
		}
	}

	/**
	 * Copia as propriedades de Objetos do mesmo tipo
	 * 
	 * @param <T>
	 *            Tipo do Objeto
	 * @param origem
	 *            Objeto de Origem
	 * @param destino
	 *            Objeto de Destino
	 * @param ignoreFields
	 *            Campos a serem ignorados
	 */
	public static <T> void copiarPropriedades(T origem, T destino,
			String... ignoreFields) {
		try {
			List<String> listIgnoreFields = new ArrayList<String>();
			if (origem == null || destino == null) {
				return;
			}
			if (ignoreFields != null && ignoreFields.length > 0) {
				listIgnoreFields = Arrays.asList(ignoreFields);
			}
			Set<Field> fields = getAllFields(origem.getClass());
			for (Field field : fields) {
				field.setAccessible(true);
				Object value = field.get(origem);
				if (!listIgnoreFields.contains(field.getName())) {
					if (value != null
							&& !Modifier.isFinal(field.getModifiers())) {
						field.set(destino, value);
					}
				}
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(
					"Erro ao copiar as propriedades entre os objetos", e);
		}
	}

	/**
	 * Retorna todos as propriedades de uma classe (desde sua maior abstracao -
	 * excetuando object)
	 * 
	 * @param clazz
	 *            Classe a ser verificada
	 * @return Set<Field> Set de {@link Field}
	 */

	@SuppressWarnings("rawtypes")
	public static Set<Field> getAllFields(Class clazz) {
		Set<Field> fields = new HashSet<Field>();
		Class superClass = clazz.getSuperclass();
		String className = superClass.getSimpleName();
		String objectName = Object.class.getSimpleName();
		if (!className.equals(objectName)) {
			fields.addAll(getAllFields(superClass));
		}
		fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
		return fields;
	}

}
