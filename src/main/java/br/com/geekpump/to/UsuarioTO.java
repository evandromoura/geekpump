package br.com.geekpump.to;

import java.util.List;

import br.com.geekpump.entity.Usuario;

public class UsuarioTO {

	private Usuario usuarioAcao;
	private Usuario usuario;
	private List<Usuario> usuarios;

	public Usuario getUsuarioAcao() {
		return usuarioAcao;
	}
	public void setUsuarioAcao(Usuario usuarioAcao) {
		this.usuarioAcao = usuarioAcao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}
