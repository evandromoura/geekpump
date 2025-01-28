package br.com.geekpump.to;

import br.com.geekpump.entity.GeneroEnum;

public class IMCTO {

	
	private Double peso;
	private Double altura;
	private Double imc;
	private GeneroEnum genero;
	
	private ResultadoIMCTO resultado;
	
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Double getAltura() {
		return altura;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	public Double getImc() {
		return imc;
	}
	public void setImc(Double imc) {
		this.imc = imc;
	}
	public GeneroEnum getGenero() {
		return genero;
	}
	public void setGenero(GeneroEnum genero) {
		this.genero = genero;
	}
	public ResultadoIMCTO getResultado() {
		if (resultado == null) {
			resultado = new ResultadoIMCTO();
		}
		return resultado;
	}
	public void setResultado(ResultadoIMCTO resultado) {
		this.resultado = resultado;
	}
}	