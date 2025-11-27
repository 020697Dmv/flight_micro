package com.crud.vuelo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "Vuelo")
public class Vuelo {

    @Id
    private int idVuelo;

    private String fecha;

    private int capacidad;

    private String hora;

    // FK hacia Empresa.idEmpresa
    @ManyToOne
    @JoinColumn(name = "EmpresaFK")  // esta columna será INT
    private Empresa empresa;

    // FK hacia Aeropuerto.idAeropuerto
    
    @ManyToOne
    @JoinColumn(name = "aeropuertoFK", referencedColumnName = "idAeropuerto")
    private Aeropuerto aeropuerto;

}
