package com.crud.vuelo.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crud.vuelo.models.Cliente;
import com.crud.vuelo.repository.ClienteRepository;
import com.crud.vuelo.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClienteServiceImpl.class);

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> findAllCliente() {

		return clienteRepository.findAll();
	}

	@Override
	public ResponseEntity<Cliente> findCliente(int id) {

		int idCliente = id;

		Optional<Cliente> optionalCliente = clienteRepository.findById(idCliente);
		if (optionalCliente.isPresent()) {

			return new ResponseEntity<>(optionalCliente.get(), HttpStatus.OK);

		} else {
			LOGGER.info("NO HAY INFORMACION DE UN CLIENTE CON ESTE ID: " + id);
			return ResponseEntity.noContent().build();

		}
	}

	@Override
	public Cliente saveCliente(Cliente clienteNuevo) {
		List<Cliente> clientes = clienteRepository.findAll();

		boolean exists = clientes.stream()
		        .anyMatch(cliente -> cliente.getId() == clienteNuevo.getId());
		
		if (exists) {
	        throw new IllegalArgumentException("El Cliente con esa ID ya existe: " + clienteNuevo.getId());
	    }

	 return	clienteRepository.save(clienteNuevo);


	}

	@Override
	public ResponseEntity<Object> deleteCliente(int id) {
		if (!clienteRepository.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();

		}

		clienteRepository.deleteById(id);

		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<Cliente> updateCliente(Cliente clienteUpdate, int id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);

		if (!cliente.isPresent()) {
			return ResponseEntity.notFound().build();
		}

		cliente.get().setEmail(clienteUpdate.getEmail());
		cliente.get().setNombre(clienteUpdate.getNombre());
		cliente.get().setTelefono(clienteUpdate.getTelefono());

		clienteRepository.save(cliente.get());
		return ResponseEntity.status(HttpStatus.CREATED).body(cliente.get());

	}	
	
}
