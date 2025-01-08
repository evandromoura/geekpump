package br.com.geekpump.to;

import java.util.List;

import br.com.geekpump.entity.Exercicio;

public class ExercicioTO {

	private Exercicio exercicioAcao;
	
	private Exercicio exercicio;
	
	private List<Exercicio> exercicios;
	
	public Exercicio getExercicio() {
		if (exercicio == null) {
			exercicio = new Exercicio();
		}
		return exercicio;
	}
	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}
	public List<Exercicio> getExercicios() {
		return exercicios;
	}
	public void setExercicios(List<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}
	
	public Exercicio getExercicioAcao() {
		if (exercicioAcao == null) {
			exercicioAcao = new Exercicio();
		}
		return exercicioAcao;
	}
	public void setExercicioAcao(Exercicio exercicioAcao) {
		this.exercicioAcao = exercicioAcao;
	}
	
	
	
}
