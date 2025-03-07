package br.com.geekpump.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "execucao_treino_exercicio", schema = "public")

public class ExecucaoTreinoExercicio {

	@Id
	@SequenceGenerator(name="EXECUCAO_TREINO_EXERCICIO_ID_GENERATOR", sequenceName="execucao_treino_exercicio_id_seq", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXECUCAO_TREINO_EXERCICIO_ID_GENERATOR")
	
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_treino_usuario_divisao_exercicio")
	private TreinoUsuarioDivisaoExercicio treinoUsuarioDivisaoExercicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name= "data_execucao")
	private Date dataExecucao;
	
	@Transient
	private Integer qtdExercicios;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TreinoUsuarioDivisaoExercicio getTreinoUsuarioDivisaoExercicio() {
		return treinoUsuarioDivisaoExercicio;
	}

	public void setTreinoUsuarioDivisaoExercicio(TreinoUsuarioDivisaoExercicio treinoUsuarioDivisaoExercicio) {
		this.treinoUsuarioDivisaoExercicio = treinoUsuarioDivisaoExercicio;
	}

	public Date getDataExecucao() {
		return dataExecucao;
	}

	public void setDataExecucao(Date dataExecucao) {
		this.dataExecucao = dataExecucao;
	}

	public Integer getQtdExercicios() {
		return qtdExercicios;
	}

	public void setQtdExercicios(Integer qtdExercicios) {
		this.qtdExercicios = qtdExercicios;
	}
}
