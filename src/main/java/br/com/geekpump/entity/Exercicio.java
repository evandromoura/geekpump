package br.com.geekpump.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "exercicio", schema = "public")
public class Exercicio {

	@Id
	@SequenceGenerator(name="EXERCICIO_ID_GENERATOR", sequenceName="exercicio_id_seq", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXERCICIO_ID_GENERATOR")
	private Integer id;
	
	private String nome;
	
	private String imagem;
	
	private String uid;
	
	@ManyToOne
	@JoinColumn(name="id_grupamento_muscular")
	private GrupamentoMuscular grupamentoMuscular;
	
	@OneToMany(mappedBy = "exercicio",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ExercicioImagem> imagens;
	
	@OneToMany(mappedBy = "exercicio",orphanRemoval = true)
	private List<TreinoUsuarioDivisaoExercicio> treinoUsuarioDivisaoExercicios;

	@OneToMany(mappedBy = "exercicio",orphanRemoval = true)	
	private List<HistoricoCarga> historicoCargas;
	
	@OneToMany(mappedBy = "exercicio",orphanRemoval = true)
	private List<HistoricoRepeticao> historicoRepeticoes;
	
	@Transient
	private boolean selecionado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public GrupamentoMuscular getGrupamentoMuscular() {
		return grupamentoMuscular;
	}

	public void setGrupamentoMuscular(GrupamentoMuscular grupamentoMuscular) {
		this.grupamentoMuscular = grupamentoMuscular;
	}

	public boolean isSelecionado() {
		return selecionado;
	}

	public void setSelecionado(boolean selecionado) {
		this.selecionado = selecionado;
	}

	public List<ExercicioImagem> getImagens() {
		return imagens;
	}

	public void setImagens(List<ExercicioImagem> imagens) {
		this.imagens = imagens;
	}

	public List<TreinoUsuarioDivisaoExercicio> getTreinoUsuarioDivisaoExercicios() {
		return treinoUsuarioDivisaoExercicios;
	}

	public void setTreinoUsuarioDivisaoExercicios(List<TreinoUsuarioDivisaoExercicio> treinoUsuarioDivisaoExercicios) {
		this.treinoUsuarioDivisaoExercicios = treinoUsuarioDivisaoExercicios;
	}

	public List<HistoricoCarga> getHistoricoCargas() {
		return historicoCargas;
	}

	public void setHistoricoCargas(List<HistoricoCarga> historicoCargas) {
		this.historicoCargas = historicoCargas;
	}

	public List<HistoricoRepeticao> getHistoricoRepeticoes() {
		return historicoRepeticoes;
	}

	public void setHistoricoRepeticoes(List<HistoricoRepeticao> historicoRepeticoes) {
		this.historicoRepeticoes = historicoRepeticoes;
	}
	
	
	
}
