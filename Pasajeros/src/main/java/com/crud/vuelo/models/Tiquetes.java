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
@Table(name = "Tiquetes")
public class Tiquetes {

    @Id
    private int idTiquete;

    private String valor;
    private String silla;
    private String clase;
    private int equipaje;

    @ManyToOne
    @JoinColumn(name = "vuelo_fk")  // <-- debe coincidir con SQL
    private Vuelo vuelo;

    @ManyToOne
    @JoinColumn(name = "cliente_fk") // <-- debe coincidir con SQL
    private Cliente cliente;
}