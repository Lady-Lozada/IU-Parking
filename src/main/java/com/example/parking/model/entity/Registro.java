package com.example.parking.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "celda")
public class Registro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRegistro")
	private int idR;
	
	@Column(name = "fechaInicio")
	private LocalDateTime fInicio;
	
	@ManyToOne
	@JoinColumn(name = "idPlaca")
	private Vehiculo idV;
	
	@ManyToOne
	@JoinColumn(name = "idCelda")
	private Celda idC;

	/**
	 * Setters - Getters
	 */
	public int getIdR() {
		return idR;
	}

	public void setIdR(int idR) {
		this.idR = idR;
	}

	public LocalDateTime getfInicio() {
		return fInicio;
	}

	public void setfInicio(LocalDateTime fInicio) {
		this.fInicio = fInicio;
	}

	public Vehiculo getIdV() {
		return idV;
	}

	public void setIdV(Vehiculo idV) {
		this.idV = idV;
	}

	public Celda getIdC() {
		return idC;
	}

	public void setIdC(Celda idC) {
		this.idC = idC;
	}	
}
