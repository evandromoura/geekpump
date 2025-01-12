package br.com.geekpump.to;

import br.com.geekpump.entity.Usuario;

public class PerfilTO {
	
	private Usuario usuario;

	public Usuario getUsuario() {
		if (usuario == null) {
			usuario = new Usuario();
		}

		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
