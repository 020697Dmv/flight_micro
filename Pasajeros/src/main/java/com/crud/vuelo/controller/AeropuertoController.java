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

import com.crud.vuelo.models.Aeropuerto;
import com.crud.vuelo.service.AeropuertoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AeropuertoController {

	@Autowired
	private AeropuertoService aeropuertoService;

	@Operation(summary = "Obtener Aeropuertos", description = "Servicio para obtener todos los Aeropuertos")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
			@ApiResponse(responseCode = "204", description = "No hay información"),
			@ApiResponse(responseCode = "500", description = "Error interno"),
			@ApiResponse(responseCode = "400", description = "Error de request"),
			@ApiResponse(responseCode = "401", description = "No autorizado") })
	@GetMapping(value = "/aeropuertos", produces = "application/json")
	public List<Aeropuerto> getClientes() {

		return this.aeropuertoService.findAllAeropuerto();
	}

	@Operation(summary = "Obtener Aeropuerto por id", description = "Servicio para obtener los Aeropuertos por ID")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
			@ApiResponse(responseCode = "204", description = "No hay información"),
			@ApiResponse(responseCode = "500", description = "Error interno"),
			@ApiResponse(responseCode = "400", description = "Error de request"),
			@ApiResponse(responseCode = "401", description = "No autorizado") })
	@GetMapping(value = "aeropuertoId/{id}", produces = "application/json")
	public ResponseEntity<Aeropuerto> getAeropuertoId(@PathVariable("id") Integer id) {

		return this.aeropuertoService.findAeropuerto(id);

	}
	
	
	@Operation(summary = "Crear Aeropuerto", description = "Servicio para crear un nuevo Aeropuerto")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
			@ApiResponse(responseCode = "204", description = "No hay información"),
			@ApiResponse(responseCode = "500", description = "Error interno"),
			@ApiResponse(responseCode = "400", description = "Error de request"),
			@ApiResponse(responseCode = "401", description = "No autorizado") })
	@PostMapping("/crearAeropuerto")
	public ResponseEntity<?> crearCliente(@RequestBody Aeropuerto aeropuerto) {

		try {
			Aeropuerto aeropuertoNuevo = this.aeropuertoService.saveAeropuerto(aeropuerto);
			return ResponseEntity.ok(aeropuertoNuevo);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("error", "Ocurrió un error interno: " + e.getMessage()));
		}

	}
	
	
	@Operation(summary = "actualizarAeropuerto", description = "Servicio para actualizar un Aeropuerto")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
			@ApiResponse(responseCode = "204", description = "No hay información"),
			@ApiResponse(responseCode = "500", description = "Error interno"),
			@ApiResponse(responseCode = "400", description = "Error de request"),
			@ApiResponse(responseCode = "401", description = "No autorizado") })
	@PutMapping("actualizarAeropuerto/{id}")
	public ResponseEntity<?> actualizarAeropuerto(@RequestBody Aeropuerto aeropuerto,
			@PathVariable(value = "id") Integer id) {

		return this.aeropuertoService.updateAeropuerto(aeropuerto, id);

	}
	
	
	@Operation(summary = "eliminarAeropuerto", description = "Servicio para eliminar un Aeropuerto")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
			@ApiResponse(responseCode = "204", description = "No hay información"),
			@ApiResponse(responseCode = "500", description = "Error interno"),
			@ApiResponse(responseCode = "400", description = "Error de request"),
			@ApiResponse(responseCode = "401", description = "No autorizado") })
	@DeleteMapping("/eliminarAeropuerto/{id}")
	public ResponseEntity<?> eliminarAeropuerto(@PathVariable(value = "id") Integer id) {

		return this.aeropuertoService.deleteAeropuerto(id);

	}

}
