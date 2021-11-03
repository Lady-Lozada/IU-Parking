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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "celda")
@Data @AllArgsConstructor @NoArgsConstructor 
public class Pagos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPagos")
	private int idP;
	
	@Column(name = "fechaPago")
	private LocalDateTime fPago;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario idU; // Foreign key

	
	/**
	 * Setters - Getters
	 */
	public int getIdP() {
		return idP;
	}

	public void setIdP(int idP) {
		this.idP = idP;
	}

	public LocalDateTime getfPago() {
		return fPago;
	}

	public void setfPago(LocalDateTime fPago) {
		this.fPago = fPago;
	}

	public Usuario getIdU() {
		return idU;
	}

	public void setIdU(Usuario idU) {
		this.idU = idU;
	}	
}
