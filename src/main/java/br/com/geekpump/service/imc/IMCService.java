package br.com.geekpump.service.imc;

import javax.ejb.Stateless;

import br.com.geekpump.entity.GeneroEnum;
import br.com.geekpump.to.ResultadoIMCTO;

/*
 * REGRAS DE NEGOCIO
 */

@Stateless
public class IMCService {


	public ResultadoIMCTO calcularIMC(GeneroEnum genero,double altura, double peso) {
		if(genero.equals(GeneroEnum.MASCULINO)) {
			return calcularIMCMasculino(altura, peso);
		}else {
			return calcularIMCFeminino(altura, peso);
		}
	}
	
	
	private ResultadoIMCTO calcularIMCMasculino(double altura,double peso) {
		double resultado = peso / (altura * altura);
		String mensagem = "";
		String cor = ""; 
		if(resultado < 18.5) {
			mensagem = "Abaixo do peso";
			cor = "primary"; 
		}else if(resultado >= 18.5 && resultado <=24.9) {
			mensagem = "Normal";
			cor = "success";
		}else if(resultado >= 25 && resultado <= 29.9) {
			mensagem = "Sobrepeso";
			cor = "secondary";
		}else if(resultado >= 30 && resultado <= 34.9) {
			mensagem = "Obesidade Grau 1";
			cor = "warning";
		}else if(resultado >= 35 && resultado <= 39.9) {
			mensagem = "Obesidade Grau 2";
			cor = "danger";
		}else if (resultado >= 40) {
			mensagem = "Obesidade grau III ou mórbida";
			cor = "danger";
		}
		return new ResultadoIMCTO(resultado, mensagem, cor);
	}
	
	private ResultadoIMCTO calcularIMCFeminino(double altura,double peso) {
		double resultado = peso / (altura * altura);
		String mensagem = "";
		String cor = ""; 
		if(resultado < 18.5) {
			mensagem = "Abaixo do peso";
			cor = "primary"; 
		}else if(resultado >= 18.5 && resultado <=24.9) {
			mensagem = "Normal";
			cor = "success";
		}else if(resultado >= 25 && resultado <= 29.9) {
			mensagem = "Sobrepeso";
			cor = "secondary";
		}else if(resultado >= 30 && resultado <= 34.9) {
			mensagem = "Obesidade Grau 1";
			cor = "warning";
		}else if(resultado >= 35 && resultado <= 39.9) {
			mensagem = "Obesidade Grau 2";
			cor = "danger";
		}else if (resultado >= 40) {
			mensagem = "Obesidade grau III ou mórbida";
			cor = "danger";
		}
		return new ResultadoIMCTO(resultado, mensagem, cor);
	}
}
