package com.example.parking.service.iface;

import java.util.List;

import com.example.parking.model.entity.Registro;

public interface RegistroService {
	/**
	 * Listar todos los Registros
	 * @return
	 */
	public List<Registro> getAll();
	
	/**
	 * Crear un Registro
	 * @param registro
	 */
	public void createRegistro(Registro registro);
	
	/**
	 * Editar un registro
	 * @param registro
	 * @param registroId
	 */
	public void editRegistro(Registro registro, int registroId);
	
	/**
	 * Borrar un registro por su Id
	 * @param registroId
	 */
	public void deleteRegistro(int registroId);

	void editSalidaRegistro(int registroId);

}
