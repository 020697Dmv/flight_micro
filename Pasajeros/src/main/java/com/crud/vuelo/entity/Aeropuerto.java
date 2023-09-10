package com.crud.vuelo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase Aeropuerto
 * 
 * @author Danny Macias Vanegas
 *
 */
@Entity
@Table(name = "Aeropuerto")
public class Aeropuerto {
	
	/**
	* Variable idAeropuerto la cual es el identificador de la tabla Aeropuerto	 
	*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAeropuerto;
	
	/**
	* Variable nombre la cual es el nombre del Aeropuerto	 
	*/
	@Column(length = 50)
	private String nombre;

	/**
	* Variable ciudad la cual es la ciudad donde esta el Aeropuerto	 
	*/
	private String ciudad;

	/**
	* Variable direccion la cual es la direccion donde esta el Aeropuerto	 
	*/
	private String direccion;

	/**
	* Setters y getters
	*/
	public int getIdAeropuerto() {
		return idAeropuerto;
	}

	public void setIdAeropuerto(int idAeropuerto) {
		this.idAeropuerto = idAeropuerto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Aeropuerto [idAeropuerto=" + idAeropuerto + ", nombre=" + nombre + ", ciudad=" + ciudad + ", direccion="
				+ direccion + "]";
	}

	
	
}
