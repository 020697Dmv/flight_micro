package com.crud.vuelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.vuelo.entity.Cliente;

/**
 * Con esta clase se llaman los servicios del respositorio
 * Objetos con los metodos de obtener, listar, eliminar y editar
 * @author Danny Macias Vanegas
 *
 */
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	
}
