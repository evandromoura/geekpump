package br.com.geekpump.security;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.geekpump.entity.Usuario;

@Named
@SessionScoped
public class CustomIdentity implements Serializable{

	private static final long serialVersionUID = 661122989182643392L;
	
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
