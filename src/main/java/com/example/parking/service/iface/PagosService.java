package com.example.parking.service.iface;

import java.util.List;

import com.example.parking.model.entity.Pagos;

public interface PagosService {

	/**
	 * Listar todas los Pagos
	 * @return
	 */
	public List<Pagos> getAll();
	
	/**
	 * Crear un Pago
	 * @param pago
	 */
	public void createPago(Pagos pago);
	
	/**
	 * Editar un Pago
	 * @param pago
	 * @param pagoId
	 */
	public void editPago(Pagos pago, int pagoId);
	
	/**
	 * Borrar Pagos
	 * @param pagoId
	 */
	public void deletePagos(int pagoId);

}
