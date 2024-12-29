package com.crud.vuelo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crud.vuelo.models.Cliente;
import com.crud.vuelo.models.Dto.ProductosDto;
import com.crud.vuelo.repository.ClienteRepository;
import com.crud.vuelo.service.ClienteService;
import com.crud.vuelo.service.ProductoService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteService clienteService;
	
	

	@Operation(summary = "Obtener clientes", description = "Servicio para obtener todos los clientes")
	@ApiResponses({
	    @ApiResponse(responseCode = "200", description = "Exitoso"),
	    @ApiResponse(responseCode = "204", description = "No hay información"),
	    @ApiResponse(responseCode = "500", description = "Error interno"),
	    @ApiResponse(responseCode = "400", description = "Error de request"),
	    @ApiResponse(responseCode = "401", description = "No autorizado")
	})
	@GetMapping(value = "/clientes", produces = "application/json")
	public List<Cliente> getClientes() {

		return this.clienteService.findAllCliente();
	}

	@Operation(summary = "Obtener clientes por id", description = "Servicio para leer los clientes por ID")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
		@ApiResponse(responseCode = "204", description = "No hay información"),
		@ApiResponse(responseCode = "500", description = "Error interno"),
		@ApiResponse(responseCode = "400", description = "Error de request"),
		@ApiResponse(responseCode = "401", description = "No autorizado")})
	@GetMapping(value = "clienteId/{id}",  produces = "application/json")
	public ResponseEntity<Cliente> getClienteId(@PathVariable("id") Integer id) {

		return this.clienteService.findCliente(id);

	}

	@Operation(summary = "Crear cliente", description = "Servicio para crear un nuevo cliente")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
		@ApiResponse(responseCode = "204", description = "No hay información"),
		@ApiResponse(responseCode = "500", description = "Error interno"),
		@ApiResponse(responseCode = "400", description = "Error de request"),
		@ApiResponse(responseCode = "401", description = "No autorizado")})
	@PostMapping("/crearCliente")
	public Cliente crearCliente(@RequestBody Cliente cliente) {

		return this.clienteService.saveCliente(cliente);

	}

	@Operation(summary = "actualizarCliente", description = "Servicio para actualizar un cliente")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
		@ApiResponse(responseCode = "204", description = "No hay información"),
		@ApiResponse(responseCode = "500", description = "Error interno"),
		@ApiResponse(responseCode = "400", description = "Error de request"),
		@ApiResponse(responseCode = "401", description = "No autorizado")})
	@PutMapping("actualizarCliente/{id}")
	public ResponseEntity<?> actualizarCliente(@RequestBody Cliente clientedetalle,
			@PathVariable(value = "id") Integer id) {

		return this.clienteService.updateCliente(clientedetalle, id);

	}

	@Operation(summary = "eliminarCliente", description = "Servicio para eliminar un cliente")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
		@ApiResponse(responseCode = "204", description = "No hay información"),
		@ApiResponse(responseCode = "500", description = "Error interno"),
		@ApiResponse(responseCode = "400", description = "Error de request"),
		@ApiResponse(responseCode = "401", description = "No autorizado")})
	@DeleteMapping("/eliminarCliente/{id}")
	public ResponseEntity<?> eliminarCliente(@PathVariable(value = "id") Integer id) {

		return this.clienteService.deleteCliente(id);

	}
	
	
	
	
	

}
