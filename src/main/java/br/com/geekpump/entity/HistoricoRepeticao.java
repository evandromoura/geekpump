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

@Entity
@Table(name = "historico_repeticao", schema = "public")
public class HistoricoRepeticao {

	@Id
	@SequenceGenerator(name = "HISTORICO_REPETICAO_ID_GENERATOR", sequenceName = "historico_repeticao_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HISTORICO_REPETICAO_ID_GENERATOR")
	private Integer id;

	@Column(name="qtd_repeticao")
	private Integer qtdRepeticao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_repeticao")
	private Date dataRepeticao;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "id_exercicio")
	private Exercicio exercicio;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQtdRepeticao() {
		return qtdRepeticao;
	}

	public void setQtdRepeticao(Integer qtdRepeticao) {
		this.qtdRepeticao = qtdRepeticao;
	}

	public Date getDataRepeticao() {
		return dataRepeticao;
	}

	public void setDataRepeticao(Date dataRepeticao) {
		this.dataRepeticao = dataRepeticao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Exercicio getExercicio() {
		return exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

}
