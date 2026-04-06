package com.crud.vuelo.before.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Tiquetes", uniqueConstraints = {
		@UniqueConstraint(name = "uk_tiquetes_vuelo_silla", columnNames = { "vuelo_fk", "silla" })
})
public class Tiquetes {

	@Id
	@Column(name = "idTiquete")
	private Long idTiquete;

	@Column(precision = 10, scale = 2)
	private BigDecimal valor;

	@Column(length = 3)
	private String moneda;

	@Column(length = 5)
	private String silla;

	@Column(length = 20)
	private String clase;

	private int equipaje;

	@ManyToOne
	@JoinColumn(name = "vuelo_fk")
	private Vuelo vuelo;

	@ManyToOne
	@JoinColumn(name = "cliente_fk")
	private Cliente cliente;

}
