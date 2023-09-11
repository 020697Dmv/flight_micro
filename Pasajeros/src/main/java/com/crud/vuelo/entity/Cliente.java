package com.crud.vuelo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase Cliente
 * 
 * @author Danny Macias Vanegas
 *
 */
@Entity
@Table(name = "Cliente")
public class Cliente {
	
	/**
	* Variable id la cual es el identificador de la tabla Cliente	 
	*/
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	/**
	* Variable nombre la cual es el nombre del Cliente	 
	*/
	@Column(length = 50)
	private String nombre;

	/**
	* Variable telefono la cual es el telefono del Cliente	 
	*/
	private String telefono;

	/**
	* Variable email la cual es el email del Cliente	 
	*/
	private String email;

	public Cliente() {
		
	}
	
	/**
	* Constructor de la clase	 
	*/
	public Cliente(int id, String nombre, String telefono, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}

	/**
	* Setters y getters
	*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
