package br.com.geekpump.util;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por oferecer serviços para os valores de string
 * 
 * @author Evandro Moura
 */
public class UtilString implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1741203844993612918L;
	private List<String> valores;

	/** M�todo construtor */
	public UtilString() {
		valores = new ArrayList<String>();
	}

	/**
	 * M�todo que verifica se est� vazio
	 * 
	 * @param valor
	 *            String
	 * @return boolean
	 */
	public boolean vazio(String valor) {
		boolean retorno = false;
		if (valor == null || valor.equals("")) {
			retorno = true;
		}
		return retorno;
	}

	/**
	 * M�todo que verifica se est� vazio
	 * 
	 * @param valor
	 *            Object
	 * @return boolean
	 */

	public boolean vazio(Object valor) {
		boolean retorno = false;
		if (valor == null || valor.toString().equals("")) {
			retorno = true;
		}
		return retorno;
	}

	/**
	 * M�todo que obtem String do valor
	 * 
	 * @param valor
	 *            String
	 * @return boolean
	 */

	public static String getString(String valor) {
		String retorno = "";
		if (valor != null) {
			retorno = valor;
		}
		return retorno;
	}

	/**
	 * Quando a condição para ser preenchido valer para todos os campos esse
	 * metodo será util para invalidar a operação em caso de um único campo
	 * não preenchido
	 * 
	 * @param valor
	 *            String...
	 * @return boolean
	 */
	public boolean vazio(String... valor) {
		boolean retorno = false;
		for (String string : valor) {
			if (vazio(string)) {
				retorno = true;
			}
		}
		return retorno;
	}

	/**
	 * Metodo para verificar valores nulos ou vazios, se um apenas estiver vazio
	 * uma excecao será lançada
	 * 
	 * @param valor
	 *            String...
	 * @return boolean
	 */
	public boolean preenchido(String... valor) {
		boolean retorno = true;
		if (vazio(valor)) {
			retorno = false;
		}
		return retorno;
	}

	/**
	 * Adiciona um valor string
	 * 
	 * @param valor
	 *            String
	 */
	public void add(String valor) {
		valores.add(valor);
	}

	/**
	 * Retorna os valores adicionados.
	 * 
	 * @return String[]
	 */
	public String[] valores() {
		return this.valores.toArray(new String[valores.size()]);
	}

	/**
	 * Reduz a string para uma apresentacao em listas e buscas, com o objetivo
	 * de n�o desformatar a interface com o cliente
	 * 
	 * @param valor
	 *            String
	 * @param qtd
	 *            Integer
	 * @return String
	 */

	public static String truncar(String valor, Integer qtd) {
		String retorno;
		if (valor.length() > qtd) {
			StringBuilder builder = new StringBuilder(valor.substring(0, qtd));
			builder.append("...");
			retorno = builder.toString();
		} else {
			retorno = valor;
		}
		return retorno;
	}
	
	public static String quebrarLinhaComBr(String valor, Integer qtd){
		String retorno = null;
		if(valor != null) {
			StringBuilder sb = new StringBuilder();
			int count = 0;
			for(char c:valor.toCharArray()) {
				sb.append(c);
				count++;
				if(count>qtd) {
					sb.append("<br />");
					count=0;
				}
			}
			retorno = sb.toString();
		}	
		return retorno;
	}

	/**
	 * Completa com zeros a esquerda, at� a string ter o tamanho tamanhoTotal
	 * 
	 * @param string
	 *            A string de entrada
	 * @param tamanhoTotal
	 *            O tamanho total da string resultate
	 * @return Uma nova string, com zeros a esquerda
	 */
	public String completaComZerosAEsquerda(String string,
			int tamanhoTotal) {
		if (string == null) {
			string = "";
		}
		for (int i = string.length(); i < tamanhoTotal; i++) {
			string = "0" + string;
		}
		return string;
	}
	
	
	/**
	 * Completa com espacos a direita, at� a string ter o tamanho tamanhoTotal
	 * 
	 * @param string
	 *            A string de entrada
	 * @param tamanhoTotal
	 *            O tamanho total da string resultate
	 * @return Uma nova string, com zeros a esquerda
	 */
	public static String completaComEspacoADireita(String string,
			int tamanhoTotal) {
		if (string == null) {
			string = "";
		}
		for (int i = string.length(); i < tamanhoTotal; i++) {
			string = string+" ";
		}
		return string;
	}

	/**
	 * Retira Caracteres Especiais
	 * 
	 * @param valor Valor
	 * @return Valor sem os caracteres
	 */
	public String retiraCaracteresEspeciais(String valor) {
		return valor.replaceAll("[^0-9a-zA-Z ]", "");
	}
	
	public String somenteNumero(String valor) {
		return valor.replaceAll("[^0-9]", "");
	}
	
	public static void main(String[] args) {
		UtilString us = new UtilString();
		System.out.println(us.retiraCaracteresEspeciais("Av Jacarandá"));
	}
	public String removeAcentos(String str) {
		  str = Normalizer.normalize(str, Normalizer.Form.NFD);
		  str = str.replaceAll("[^\\p{ASCII}]", "");
		  return str;
		 
	}

//	/**
//	 * Retorna uma String substituindo seus caracteres acentuados pelos sem
//	 * acentos e espacos em branco
//	 * 
//	 * @param valor
//	 *            String a ser transformada
//	 * @return String String transformada
//	 */
//	public static String extrairNumeroLetrasString(String valor) {
//		valor = Normalizer.normalize(valor, Normalizer.DECOMP, 0);
//		valor = valor.replaceAll("[^\\p{ASCII}]", "");
//		valor = retiraCaracteresEspeciais(valor);
//		return valor;
//	}

//	/**
//	 * Verifica as String sao iguais ignorando os acentos, caracteres especiais
//	 * e espacos em branco entre elas
//	 * 
//	 * @param valorUm
//	 *            String um
//	 * @param valorDois
//	 *            String dois
//	 * @return boolean true caso as String sejam iguais ou null
//	 */
//	public static boolean isStringsIguaisAbsolutamente(String valorUm,
//			String valorDois) {
//		return extrairNumeroLetrasString(valorUm).toLowerCase().equals(
//				extrairNumeroLetrasString(valorDois).toLowerCase());
//	}
	
	/**
	 * Stack Trace
	 * @param e Excecao
	 * @return String do StackTrace
	 */
	public static String stackTrace(Exception e) {
		StringWriter writer = new StringWriter();
		e.printStackTrace(new PrintWriter(writer));
		return writer.getBuffer().toString();
	}
	
	public static int indexOf(String str, String search, int fromIndex) {
        if (fromIndex < 0) {
            fromIndex = str.length() + fromIndex; // convert the negative index to a positive index, treating the negative index -1 as the index of the last character
            int index = str.lastIndexOf(search, fromIndex);
            if (index == -1) {
                index = Integer.MIN_VALUE; // String.indexOf normally returns -1 if the character is not found, but we need to define a new contract since -1 is a valid index for our new implementation
            }
            else {
                index = -(str.length() - index); // convert the result to a negative index--again, -1 is the index of the last character 
            }
            return index;
        }
        else {
            return str.indexOf(str, fromIndex);
        }
    }
	
	public String getPrimeiraPalavra(String valor){
		return valor.substring(0,valor.indexOf(" "));
	}
	
	public static boolean isNumerico(String string) {
		if (new UtilString().vazio(string)) {
			return false;
	    }
	    int sz = string.length();
	    for (int i = 0; i < sz; i++) {
	        if (Character.isDigit(string.charAt(i)) == false) {
	            return false;
	        }
	    }
	    return true;
	}
}
