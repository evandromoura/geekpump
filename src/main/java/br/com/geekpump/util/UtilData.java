package br.com.geekpump.util;

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
}
