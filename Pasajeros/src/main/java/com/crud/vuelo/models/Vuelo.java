package com.crud.vuelo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.Data;

/**
 * Clase Vuelo
 * 
 * @author Danny Macias Vanegas
 *
 */
@Data
@Entity
@Table(name = "Vuelo")
public class Vuelo {
	
	
	/**
	* Variable idVuelo la cual es el identificador de la tabla Vuelo	 
	*/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVuelo;
	
	/**
	* Variable fecha la cual es la fecha del Vuelo	 
	*/
	private String fecha;
	
	/**
	* Variable capacidad la cual es la capacidad del Vuelo	 
	*/
	private int capacidad;
	
	/**
	* Variable hora la cual es la hora del Vuelo	 
	*/
	private String hora;
	
	/**
	* Variable con la clave foranea de las empresas creadas	 
	*/
	@OneToOne
	@JoinColumn(name="EmpresaFK")
	private Empresa empresa;
	
	/**
	* Variable con la clave foranea de los Aeropuertos creados	 
	*/
	@ManyToOne
	@JoinColumn(name="AeropuertoFK")
	private Aeropuerto aeropuerto;	

}
