package com.example.parking.service.iface;

import java.util.List;

import com.example.parking.model.entity.Vehiculo;

public interface VehiculoService {

	/**
	 * Listar todos los Vehiculos
	 * @return
	 */
	public List<Vehiculo> getAll();
	
	/**
	 * Ingresar un vehiculo
	 * @param vehiculo
	 */
	public void createVehiculo(Vehiculo vehiculo);
	
	/**
	 * Editar un vehiculo
	 * @param vehiculo
	 * @param idVehiculo
	 */
	public void editVehiculo(Vehiculo vehiculo, int idVehiculo);

}
