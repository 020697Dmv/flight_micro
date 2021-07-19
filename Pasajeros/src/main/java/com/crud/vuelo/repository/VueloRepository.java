package com.crud.vuelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.vuelo.entity.Vuelo;

/**
 * Con esta clase se llaman los servicios del respositorio
 * Objetos con los metodos de obtener, listar, eliminar y editar
 * @author Danny Macias Vanegas
 *
 */
public interface VueloRepository extends JpaRepository<Vuelo, Integer>{ 

}
