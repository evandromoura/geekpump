package br.com.geekpump.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.geekpump.util.UtilData;

@Entity
@Table(name = "treino_usuario_divisao_exercicio", schema = "public")
public class TreinoUsuarioDivisaoExercicio {
	
	@Id
	@SequenceGenerator(name="TREINO_USUARIO_DIVISAO_EXERCICIO_ID_GENERATOR", sequenceName="treino_usuario_exercicio_id_seq", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TREINO_USUARIO_DIVISAO_EXERCICIO_ID_GENERATOR")
	private Integer id;

	@ManyToOne
	@JoinColumn(name="id_treino_usuario_divisao")
	private TreinoUsuarioDivisao treinoUsuarioDivisao;
	
	@JoinColumn(name="id_exercicio")
	private Exercicio exercicio;
	
	private Double carga;
	
	@Column(name="qtd_serie")
	private Integer qtdSerie;
	
	@Column(name="qtd_repeticao")
	private Integer qtdRepeticao;
	
	@Column(name="qtd_segundo_descanso")
	private Integer qtdSegundoDescanso;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TreinoUsuarioDivisao getTreinoUsuarioDivisao() {
		return treinoUsuarioDivisao;
	}

	public void setTreinoUsuarioDivisao(TreinoUsuarioDivisao treinoUsuarioDivisao) {
		this.treinoUsuarioDivisao = treinoUsuarioDivisao;
	}

	public Exercicio getExercicio() {
		return exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

	public Double getCarga() {
		return carga;
	}

	public void setCarga(Double carga) {
		this.carga = carga;
	}

	public Integer getQtdSerie() {
		return qtdSerie;
	}

	public void setQtdSerie(Integer qtdSerie) {
		this.qtdSerie = qtdSerie;
	}

	public Integer getQtdRepeticao() {
		return qtdRepeticao;
	}

	public void setQtdRepeticao(Integer qtdRepeticao) {
		this.qtdRepeticao = qtdRepeticao;
	}

	public Integer getQtdSegundoDescanso() {
		return qtdSegundoDescanso;
	}
	
	@Transient
	public String getQtdSegundoDescansoFormat() {
		if(getQtdSegundoDescanso() != null) {
			return UtilData.formatarMinuto(getQtdSegundoDescanso());
		}
		return "";
	}

	public void setQtdSegundoDescanso(Integer qtdSegundoDescanso) {
		this.qtdSegundoDescanso = qtdSegundoDescanso;
	} 
	
	
	
}
