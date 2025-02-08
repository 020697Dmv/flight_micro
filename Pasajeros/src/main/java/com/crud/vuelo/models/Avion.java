package com.crud.vuelo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Avion")
public class Avion {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAvion;

	
	private String modelo;
	
	
	private int capacidad;
	
	
	@ManyToOne
	@JoinColumn(name="EmpresaFK")
	private Empresa empresa;
	
	
}
