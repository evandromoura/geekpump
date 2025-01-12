package br.com.geekpump.entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "usuario", schema = "public")

public class Usuario {

	@Id
	@SequenceGenerator(name="USUARIO_ID_GENERATOR", sequenceName="usuario_id_seq", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USUARIO_ID_GENERATOR")
	private Integer id;
	
	private String nome;
	private String email;
	private String imagem;
	private String login;
	private String senha;
	
	@Column(name="id_google")
	private String idGoogle;
	
	@OneToMany(mappedBy = "usuario",orphanRemoval = true)
	private List<TreinoUsuario> treinos;
	
	/*
	 * Enum sao constantes no JAVA, para reduzir erros de programacao e melhorar a manutencao
	 */
	@Enumerated(EnumType.STRING)
	private PerfilEnum perfil;
	
	private Double peso;
	private Double altura;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_nascimento")
	private Date dataNascimento;

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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public PerfilEnum getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}
	
	public List<TreinoUsuario> getTreinos() {
		return treinos;
	}
	public void setTreinos(List<TreinoUsuario> treinos) {
		this.treinos = treinos;
	}
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
	public String getIdGoogle() {
		return idGoogle;
	}
	public void setIdGoogle(String idGoogle) {
		this.idGoogle = idGoogle;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString());
	}

	
}
