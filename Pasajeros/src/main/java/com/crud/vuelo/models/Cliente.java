package com.crud.vuelo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

/**
 * Clase Cliente
 * 
 * @author Danny Macias Vanegas
 *
 */
@Builder
@Data
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

	
	public Cliente(int id, String nombre, String telefono, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}

	public Cliente() {
	}
	
	
	

}
