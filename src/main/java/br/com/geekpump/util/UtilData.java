package br.com.geekpump.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class UtilData {

	
	public static String formatarHora(Integer hora) {
		Integer ss = hora % 60;  
		hora /= 60;  
		Integer min =  hora % 60;  
		hora /= 60;  
		Integer hh =  hora % 24;  
		return strzero(hh) + ":" + strzero(min) + ":" + strzero(ss);  
	} 
	public static String formatarMinuto(Integer hora) {
		Integer ss = hora % 60;  
		hora /= 60;  
		Integer min =  hora % 60;  
		hora /= 60;  
		Integer hh =  hora % 24;  
		return  strzero(min) + ":" + strzero(ss);  
	} 
	
	private static String strzero(int n){  
		if(n < 10)  
			return "0" + String.valueOf(n);  
		return String.valueOf(n);  
	} 
	
	public static Date ajustaData(Date data, int horas, int minutos,
			int segundos) {
		Calendar calendar = null;
		try {
			if (data != null) {
				calendar = Calendar.getInstance();
				calendar.setTime(data);
				calendar.set(Calendar.HOUR_OF_DAY, horas);
				calendar.set(Calendar.MINUTE, minutos);
				calendar.set(Calendar.SECOND, segundos);
				calendar.set(Calendar.MILLISECOND, 0);
				data = calendar.getTime();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	/**
	 * M�todo que adiciona Anos
	 * 
	 * @param data Date
	 * @param quantidadeAnos int
	 * @return Date
	 */

	public static Date adicionarAnos(Date data, int quantidadeAnos) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.YEAR, quantidadeAnos);
		return cal.getTime();
	}
	/**
	 * M�todo que adiciona Anos
	 * 
	 * @param data Date
	 * @param quantidadeAnos int
	 * @return Date
	 */

	public static Date adicionarHoras(Date data, int quantidadeHoras) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.HOUR, quantidadeHoras);
		return cal.getTime();
	}
	
	public static Date adicionarMinuto(Date data, int quantidadeMinutos) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MINUTE, quantidadeMinutos);
		return cal.getTime();
	}

	/**
	 * M�todo que subtrai meses
	 * 
	 * @param data Date
	 * @param quantidadeMeses int
	 * @return Date
	 */
	
	public static Date subtrairMeses(Date data, int quantidadeMeses) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MONTH, quantidadeMeses * -1);
		return cal.getTime();
	}
	/**
	 * M�todo que subtrai dias
	 * 
	 * @param data Date
	 * @param quantidadeDias int
	 * @return Date
	 */

	public static Date subtrairDias(Date data, int quantidadeDias) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.DAY_OF_MONTH, quantidadeDias * -1);
		return cal.getTime();
	}

	/**
	 * M�todo que subtrai meses
	 * 
	 * @param data Date
	 * @param quantidadeMeses int
	 * @return Date
	 */

	public static Date subtrairHoras(Date data, int quantidadeHoras) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.HOUR_OF_DAY, quantidadeHoras * -1);
		return cal.getTime();
	}


	/**
	 * M�todo que subtrai meses
	 * 
	 * @param data Date
	 * @param quantidadeMeses int
	 * @return Date
	 */

	public static Date subtrairMinutos(Date data, int quantidadeMinuto) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MINUTE, quantidadeMinuto * -1);
		return cal.getTime();
	}
	
	public static Date subtrairMilisegundos(Date data, int quantidadeMilisegundos) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MILLISECOND, quantidadeMilisegundos * -1);
		return cal.getTime();
	}
	
	/**
	 * Retorna se a data 1 � maior ou igual a data 2
	 * 
	 * @param dt1 Date
	 * @param d2 Date
	 * @return boolean
	 */
	public static boolean data1MaiorIgualData2(Date dt1, Date d2) {
		return ((dt1.compareTo(d2) > 0) || (dt1.compareTo(d2) == 0));
	}

	/**
	 * Retorna se a data 1 � menor ou igual a data 2
	 * 
	 * @param dt1 Date
	 * @param d2 Date
	 * @return boolean
	 */
	public static boolean data1MenorIgualData2(Date dt1, Date d2) {
		return ((dt1.compareTo(d2) < 0) || (dt1.compareTo(d2) == 0));
	}
	
	
	/**
	 * M�todo que formata date
	 * 
	 * @param date Date
	 * @param pattern String
	 * @return String
	 */
	public static String formatDate(java.util.Date date, String pattern) {
		String retorno;
		if (date == null) {
			retorno = "";
		} else {
			SimpleDateFormat formatter = new SimpleDateFormat(pattern,
					new Locale("pt", "BR"));
			//			formatter.setTimeZone(TimeZone.getTimeZone("GMT-3"));
			retorno = formatter.format(date);
		}
		return retorno;
	}
	
	public static Date getDataPorStringAAAMMDD(String valor)throws Exception{
		Date retorno = null;
		if(!UtilString.vazio(valor)&&(valor.replaceAll(" ","").length() ==8)){
			retorno = new Date((valor.substring(4,6))+"/"+valor.substring(6,8)+"/"+(valor.substring(0,4)));
		}else if(!UtilString.vazio(valor)&&(valor.replaceAll(" ","").length() ==21)){
			DateFormat dataFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
			retorno = dataFormat.parse(valor.substring(8,10)+"/"+(valor.substring(5,7))+"/"+(valor.substring(0,4))+" "+(valor.substring(10,18)));
		}
		return retorno;
	}
	
	public static String getDiaSemana(Date data) {
		String dataFormatada = null;
		if (data != null) {
			SimpleDateFormat f = new SimpleDateFormat("EEE");
			dataFormatada = f.format(data);
		}
		return dataFormatada;
	}
}
