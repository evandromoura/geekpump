package br.com.geekpump.service.imc;

import javax.ejb.Stateless;

/*
 * REGRAS DE NEGOCIO
 */

@Stateless
public class IMCService {

	
	public String calcularIMC(double altura, double peso) {
		double imc = peso / (altura * altura);
		String retorno = "";
		if(imc < 18.5) {
			retorno = "Abaixo do peso";
		}else if(imc >= 18.5 && imc <=24.9) {
			retorno = "Normal";
		}else if(imc >= 25 && imc <= 29.9) {
			retorno = "Sobrepeso";
		}else if(imc >= 30 && imc <= 34.9) {
			retorno = "Obesidade Grau 1";
		}else if(imc >= 35 && imc <= 39.9) {
			retorno = "Obesidade Grau 2";
		}else if (imc >= 40) {
			retorno = "Obesidade grau III ou mórbida";
		}
		return retorno;
		
	}
}
