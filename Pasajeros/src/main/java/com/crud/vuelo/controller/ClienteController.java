package com.crud.vuelo.controller;

import java.util.List;
import java.util.Map;

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

import com.crud.vuelo.models.Cliente;
import com.crud.vuelo.models.Empresa;
import com.crud.vuelo.repository.ClienteRepository;
import com.crud.vuelo.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@Operation(summary = "Obtener clientes", description = "Servicio para obtener todos los clientes")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
			@ApiResponse(responseCode = "204", description = "No hay información"),
			@ApiResponse(responseCode = "500", description = "Error interno"),
			@ApiResponse(responseCode = "400", description = "Error de request"),
			@ApiResponse(responseCode = "401", description = "No autorizado") })
	@GetMapping(value = "/clientes", produces = "application/json")
	public List<Cliente> getClientes() {

		return this.clienteService.findAllCliente();

	}

	@Operation(summary = "Obtener clientes por id", description = "Servicio para leer los clientes por ID")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
			@ApiResponse(responseCode = "204", description = "No hay información"),
			@ApiResponse(responseCode = "500", description = "Error interno"),
			@ApiResponse(responseCode = "400", description = "Error de request"),
			@ApiResponse(responseCode = "401", description = "No autorizado") })
	@GetMapping(value = "clienteId/{id}", produces = "application/json")
	public ResponseEntity<Cliente> getClienteId(@PathVariable("id") Integer id) {

		return this.clienteService.findCliente(id);

	}

	@Operation(summary = "Crear cliente", description = "Servicio para crear un nuevo cliente")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
			@ApiResponse(responseCode = "204", description = "No hay información"),
			@ApiResponse(responseCode = "500", description = "Error interno"),
			@ApiResponse(responseCode = "400", description = "Error de request"),
			@ApiResponse(responseCode = "401", description = "No autorizado") })
	@PostMapping("/crearCliente")
	public ResponseEntity<?> crearCliente(@RequestBody Cliente cliente) {

		try {
			Cliente clienteNuevo = this.clienteService.saveCliente(cliente);
			return ResponseEntity.ok(clienteNuevo);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("error", "Ocurrió un error interno: " + e.getMessage()));
		}

	}

	@Operation(summary = "actualizarCliente", description = "Servicio para actualizar un cliente")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
			@ApiResponse(responseCode = "204", description = "No hay información"),
			@ApiResponse(responseCode = "500", description = "Error interno"),
			@ApiResponse(responseCode = "400", description = "Error de request"),
			@ApiResponse(responseCode = "401", description = "No autorizado") })
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
			@ApiResponse(responseCode = "401", description = "No autorizado") })
	@DeleteMapping("/eliminarCliente/{id}")
	public ResponseEntity<?> eliminarCliente(@PathVariable(value = "id") Integer id) {

		return this.clienteService.deleteCliente(id);

	}

}
