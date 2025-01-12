package br.com.geekpump.to;

import java.util.List;

import javax.servlet.http.Part;

import br.com.geekpump.entity.Exercicio;

public class ExercicioTO {

	private Exercicio exercicioAcao;
	
	private Exercicio exercicio;
	
	private List<Exercicio> exercicios;
	
	private Part thumbnail;
	
	private Part imagemExecucao;
	
	private Part imagemAtivacaoMuscular;
	
	
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
	public Part getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(Part thumbnail) {
		this.thumbnail = thumbnail;
	}
	public Part getImagemExecucao() {
		return imagemExecucao;
	}
	public void setImagemExecucao(Part imagemExecucao) {
		this.imagemExecucao = imagemExecucao;
	}
	public Part getImagemAtivacaoMuscular() {
		return imagemAtivacaoMuscular;
	}
	public void setImagemAtivacaoMuscular(Part imagemAtivacaoMuscular) {
		this.imagemAtivacaoMuscular = imagemAtivacaoMuscular;
	}
	
	
	
}
