package com.crud.vuelo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Clase Vuelo
 * 
 * @author Danny Macias Vanegas
 *
 */
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

	/**
	* Setters y getters
	*/
	public int getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Aeropuerto getAeropuerto() {
		return aeropuerto;
	}

	public void setAeropuerto(Aeropuerto aeropuerto) {
		this.aeropuerto = aeropuerto;
	}


}
