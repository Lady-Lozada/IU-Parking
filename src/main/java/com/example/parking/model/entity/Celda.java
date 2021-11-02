package com.example.parking.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "celda")
@Getter
@Setter
public class Celda implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
