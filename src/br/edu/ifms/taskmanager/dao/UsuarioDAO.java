package br.edu.ifms.taskmanager.dao;

import br.edu.ifms.taskmanager.mockBD.Banco;
import br.edu.ifms.taskmanager.model.Usuario;

import java.util.ArrayList;

public class UsuarioDAO {
	Banco banco;

	public UsuarioDAO(Banco banco) {
		super();
		this.banco = banco;
	}

	public boolean adicionaUsuario(Usuario usuario) {
		ArrayList<Usuario> usuarios = banco.getUsuarios();

		return usuarios.add(usuario);
	}

	public Usuario buscaUsuarioPorId(Long id) {
		ArrayList<Usuario> usuarios = banco.getUsuarios();

		for (Usuario usuario : usuarios)
			if (usuario.getId().equals(id))
				return usuario;

		return null;
	}

	public boolean atualizaUsuario(Usuario usuario) {
		ArrayList<Usuario> usuarios = banco.getUsuarios();

		for (Usuario usuarioBD : usuarios) {
			if (usuarioBD.getId().equals(usuario.getId())) {
				usuarios.remove(usuarioBD);
				usuarios.add(usuario);

				return true;
			}
		}

		return false;
	}

	public boolean deletaUsuario(Usuario usuario) {
		ArrayList<Usuario> usuarios = banco.getUsuarios();

		return usuarios.remove(usuario);
	}

}