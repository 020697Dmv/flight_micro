package com.crud.vuelo.before.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Cliente", uniqueConstraints = { @UniqueConstraint(name = "uk_cliente_email", columnNames = { "email" }) })
public class Cliente {

	@Id
	private Long id;

	@Column(length = 50)
	private String nombre;

	@Column(length = 20)
	private String telefono;

	@Column(length = 255)
	private String email;

}
