package com.example.parking.service.iface;

import java.util.List;

import com.example.parking.model.entity.Usuario;

public interface UsuarioService {
	/**
	 * Listar todos los Usuarios
	 * @return
	 */
	public List<Usuario> getAll();
	
	/**
	 * Crear un Usuario
	 * @param usuario
	 */
	public void createUsuario(Usuario usuario);
	
	/**
	 * Editar un usuario
	 * @param usuario
	 * @param usuarioId
	 */
	public void editRegistro(Usuario usuario, int usuarioId);
	
	/**
	 * Borrar un Usuario por su Id
	 * @param usuarioId
	 */
	public void deleteRegistro(int usuarioId);

}
