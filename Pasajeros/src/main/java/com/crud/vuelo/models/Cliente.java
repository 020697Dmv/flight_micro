package com.crud.vuelo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Cliente")
public class Cliente {
	
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	
	@Column(length = 50)
	private String nombre;

	
	private String telefono;

	
	private String email;
	
	
	

}
