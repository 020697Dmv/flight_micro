package com.crud.vuelo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;

/**
 * Clase Tiquetes
 * 
 * @author Danny Macias Vanegas
 *
 */
@Data
@Entity
@Table(name = "Tiquetes")
public class Tiquetes {
	
	/**
	* Variable idVuelo la cual es el identificador de la tabla Vuelo	 
	*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTiquete;
	
	/**
	* Variable con el valor del Tiquete	 
	*/
	private String valor;
	
	/**
	* Variable con la silla del Tiquete	 
	*/
	private String silla;
	
	/**
	* Variable con la clase del Tiquete	 
	*/
	private String clase;
	
	/**
	* Variable del equipaje del Tiquete	 
	*/
	private int equipaje;
	
	/**
	* Variable con la clave foranea de los Vuelos creados	 
	*/
	@ManyToOne
	@JoinColumn(name="vueloFK")
	private Vuelo vuelo;

	/**
	* Variable con la clave foranea de los Cliente creados	 
	*/
	@ManyToOne
	@JoinColumn(name="clienteFK")
	private Cliente cliente;

	
	
}
