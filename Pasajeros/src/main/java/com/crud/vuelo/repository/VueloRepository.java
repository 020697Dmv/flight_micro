package com.crud.vuelo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.vuelo.entity.Vuelo;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
/**
 * Con esta clase se llaman los servicios del respositorio
 * Objetos con los metodos de obtener, listar, eliminar y editar
 * @author Danny Macias Vanegas
 *
 */
public interface VueloRepository extends JpaRepository<Vuelo, Integer>{ 




	Optional<Vuelo> findByidVuelo(int idVuelo);
	
	
}
