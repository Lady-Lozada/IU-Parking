package com.example.parking.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehiculo")
public class Vehiculo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idVehiculo")
	private int idV;
	
	private String placa;	
	private String marca;	
	private String modelo;	
	private String tipo;	
	private String color;	
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario idU;
	
	@ManyToOne
	@JoinColumn(name = "idCelda")
	private Celda idC;

	/**
	 * Setters - Getters
	 */
	public int getIdV() {
		return idV;
	}

	public void setIdV(int idV) {
		this.idV = idV;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Usuario getIdU() {
		return idU;
	}

	public void setIdU(Usuario idU) {
		this.idU = idU;
	}

	public Celda getIdC() {
		return idC;
	}

	public void setIdC(Celda idC) {
		this.idC = idC;
	} 
}
