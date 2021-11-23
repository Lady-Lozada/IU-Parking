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
@Table(name = "registro")
public class Registro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_registro")
	private int idR;
	
	@Column(name = "fecha_inicio")
	private LocalDateTime fInicio;
	
	@Column(name = "fecha_fin")
	private LocalDateTime fFin;
	
	@ManyToOne
	@JoinColumn(name = "id_vehiculo")
	private Vehiculo idV;
	
	@ManyToOne
	@JoinColumn(name = "id_celda")
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

	public LocalDateTime getfFin() {
		return fFin;
	}

	public void setfFin(LocalDateTime fFin) {
		this.fFin = fFin;
	}	
}
