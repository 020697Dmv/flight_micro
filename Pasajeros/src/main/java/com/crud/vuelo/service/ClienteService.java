package com.crud.vuelo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.crud.vuelo.entity.Cliente;

/**
 * En esta clase estan declarados los servicios que pueden ser utilizados
 * 
 * @author Danny Macias Vanegas
 *
 */
public interface ClienteService {

	
	public List<Cliente> findAllCliente();

	public ResponseEntity<Cliente> findCliente(int id);

	public ResponseEntity saveCliente(Cliente clienteNuevo);

	public ResponseEntity<Object> deleteCliente(int id);

	public ResponseEntity<?> updateCliente(Cliente ClienteNew, int id);
	
	
	
}
