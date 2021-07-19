package com.crud.vuelo.service;

import java.util.List;
import java.util.Optional;

import com.crud.vuelo.entity.Cliente;

/**
 * En esta clase estan declarados los servicios que pueden ser utilizados
 * 
 * @author Danny Macias Vanegas
 *
 */
public interface ClienteService {

	
	public List<Cliente> findAllCliente();

	public Optional<Cliente> findCliente(int id);

	public boolean saveCliente(Cliente clienteNuevo);

	public boolean deleteCliente(int id);

	public boolean updateCliente(Cliente ClienteNew);
	
	
	
}
