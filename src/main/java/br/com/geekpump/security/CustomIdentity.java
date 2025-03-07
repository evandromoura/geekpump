package br.com.geekpump.security;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.geekpump.entity.GeneroEnum;
import br.com.geekpump.entity.Usuario;
import br.com.geekpump.enums.TipoAutenticacaoEnum;

@Named
@SessionScoped
public class CustomIdentity implements Serializable{

	private static final long serialVersionUID = 661122989182643392L;
	
	private Usuario usuario;
	private TipoAutenticacaoEnum tipoAutenticacao;
	private GeneroEnum generoEnum;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoAutenticacaoEnum getTipoAutenticacao() {
		return tipoAutenticacao;
	}

	public void setTipoAutenticacao(TipoAutenticacaoEnum tipoAutenticacao) {
		this.tipoAutenticacao = tipoAutenticacao;
	}

	public GeneroEnum getGeneroEnum() {
		return generoEnum;
	}

	public void setGeneroEnum(GeneroEnum generoEnum) {
		this.generoEnum = generoEnum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
