package br.com.geekpump.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "treino_usuario_divisao", schema = "public")
public class TreinoUsuarioDivisao {
	
	@Id
	@SequenceGenerator(name="TREINO_USUARIO_DIVISAO_ID_GENERATOR", sequenceName="treino_usuario_divisao_id_seq", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TREINO_USUARIO_DIVISAO_ID_GENERATOR")
	private Integer id;
	
	private String nome;
	
	private String cor;
	
	private String uid;
	
	@ManyToOne
	@JoinColumn(name="id_treino_usuario")
	private TreinoUsuario treinoUsuario;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

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

	public TreinoUsuario getTreinoUsuario() {
		return treinoUsuario;
	}

	public void setTreinoUsuario(TreinoUsuario treinoUsuario) {
		this.treinoUsuario = treinoUsuario;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

}
