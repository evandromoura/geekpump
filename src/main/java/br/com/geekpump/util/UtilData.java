package br.com.geekpump.util;

import java.util.Calendar;
import java.util.Date;

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
				data = calendar.getTime();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}
