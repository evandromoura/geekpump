package br.com.geekpump.to;

public class ResultadoIMCTO {

	
	private double resultado;
	private String mensagem;
	private String cor;
	
	public ResultadoIMCTO() {
		
	}
	
	public ResultadoIMCTO(double resultado, String mensagem, String cor) {
		setResultado(resultado);
		setMensagem(mensagem);
		setCor(cor);
	}
	
	public double getResultado() {
		return resultado;
	}
	public void setResultado(double resultado) {
		this.resultado = resultado;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	
	
}
