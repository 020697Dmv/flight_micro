package com.crud.vuelo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/api/v1")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ProductoService productoService;

	@ApiOperation(value = "getCliente", notes = "Servicio para obtener todod los clientes")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exitoso", response = Cliente.class), 
	@ApiResponse(code = 204, message = "No hay información"),
	@ApiResponse(code = 500, message = "Error interno"),
	@ApiResponse(code = 400, message = "Error de request"),
	@ApiResponse(code = 401, message = "No autorizado")})
	@GetMapping(value ="/clientes", produces = "application/json")
	public List<Cliente> getClientes() {

		return this.clienteService.findAllCliente();
	}

	@ApiOperation(value = "getClienteId", notes = "Servicio para leer los clientes por ID")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exitoso", response = Cliente.class),
		@ApiResponse(code = 204, message = "No hay información"),
		@ApiResponse(code = 500, message = "Error interno"),
		@ApiResponse(code = 400, message = "Error de request"),
		@ApiResponse(code = 401, message = "No autorizado")})
	@GetMapping(value = "clienteId/{id}",  produces = "application/json")
	public ResponseEntity<Cliente> getClienteId(@PathVariable("id") Integer id) {

		return this.clienteService.findCliente(id);

	}

	@ApiOperation(value = "crearCliente", notes = "Servicio para crear un nuevo cliente")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exitoso", response = Cliente.class),
		@ApiResponse(code = 204, message = "No hay información"),
		@ApiResponse(code = 500, message = "Error interno"),
		@ApiResponse(code = 400, message = "Error de request"),
		@ApiResponse(code = 401, message = "No autorizado")})
	@PostMapping("/crearCliente")
	public Cliente crearCliente(@RequestBody Cliente cliente) {

		return this.clienteService.saveCliente(cliente);

	}

	@ApiOperation(value = "actualizarCliente", notes = "Servicio para actualizar un cliente")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exitoso", response = Cliente.class),
		@ApiResponse(code = 204, message = "No hay información"),
		@ApiResponse(code = 500, message = "Error interno"),
		@ApiResponse(code = 400, message = "Error de request"),
		@ApiResponse(code = 401, message = "No autorizado")})
	@PutMapping("actualizarCliente/{id}")
	public ResponseEntity<?> actualizarCliente(@RequestBody Cliente clientedetalle,
			@PathVariable(value = "id") Integer id) {

		return this.clienteService.updateCliente(clientedetalle, id);

	}

	@ApiOperation(value = "eliminarCliente", notes = "Servicio para eliminar un cliente")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exitoso", response = Cliente.class),
		@ApiResponse(code = 204, message = "No hay información"),
		@ApiResponse(code = 500, message = "Error interno"),
		@ApiResponse(code = 400, message = "Error de request"),
		@ApiResponse(code = 401, message = "No autorizado")})
	@DeleteMapping("/eliminarCliente/{id}")
	public ResponseEntity<?> eliminarCliente(@PathVariable(value = "id") Integer id) {

		return this.clienteService.deleteCliente(id);

	}
	
	
	
	
	

}
