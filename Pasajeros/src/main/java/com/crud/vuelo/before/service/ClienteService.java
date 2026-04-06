package com.crud.vuelo.before.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.crud.vuelo.before.models.Cliente;


public interface ClienteService {

	
	public List<Cliente> findAllCliente();

	public ResponseEntity<Cliente> findCliente(Long id);

	public Cliente saveCliente(Cliente clienteNuevo);

	public ResponseEntity<Object> deleteCliente(Long id);

	public ResponseEntity<Cliente> updateCliente(Cliente nuevoCliente, Long id);
	
	
	
}
