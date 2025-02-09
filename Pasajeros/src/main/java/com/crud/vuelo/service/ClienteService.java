package com.crud.vuelo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.crud.vuelo.models.Cliente;


public interface ClienteService {

	
	public List<Cliente> findAllCliente();

	public ResponseEntity<Cliente> findCliente(int id);

	public Cliente saveCliente(Cliente clienteNuevo);

	public ResponseEntity<Object> deleteCliente(int id);

	public ResponseEntity<?> updateCliente(Cliente ClienteNew, int id);
	
	
	
}
