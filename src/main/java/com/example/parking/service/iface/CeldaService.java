package com.example.parking.service.iface;

import java.util.List;

import com.example.parking.model.entity.Celda;

public interface CeldaService {

	/**
	 * Listar todas las celdas
	 * @return
	 */
	public List<Celda> getAll();
	
	/**
	 * Crear una celda
	 * @param celda
	 */
	public void createCelda(Celda celda);
	
	/**
	 * Celda ocupada SI/NO
	 * @param celda
	 * @param idCelda
	 */
	public void editCelda(Celda celda, int idCelda);
}
