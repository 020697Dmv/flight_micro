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
import com.crud.vuelo.models.Tiquetes;
import com.crud.vuelo.service.TiquetesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
@RequiredArgsConstructor
public class TiquetesController {
	
	
	@Autowired
	private TiquetesService tiquetesService;
	
	
	@Operation(summary = "Obtener Tiquetes", description = "Servicio para obtener todos los Tiquetes")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
			@ApiResponse(responseCode = "204", description = "No hay información"),
			@ApiResponse(responseCode = "500", description = "Error interno"),
			@ApiResponse(responseCode = "400", description = "Error de request"),
			@ApiResponse(responseCode = "401", description = "No autorizado") })
	@GetMapping(value = "/tiquetes", produces = "application/json")
	public List<Tiquetes> getTiquetes() {

		return this.tiquetesService.findAllTiquete();

	}

	@Operation(summary = "Obtener Tiquetes por id", description = "Servicio para leer los Tiquetes por ID")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
			@ApiResponse(responseCode = "204", description = "No hay información"),
			@ApiResponse(responseCode = "500", description = "Error interno"),
			@ApiResponse(responseCode = "400", description = "Error de request"),
			@ApiResponse(responseCode = "401", description = "No autorizado") })
	@GetMapping(value = "tiquetesId/{id}", produces = "application/json")
	public ResponseEntity<Tiquetes> getTiqueteId(@PathVariable("id") Integer id) {

		return this.tiquetesService.findTiquete(id);

	}

	@Operation(summary = "Crear Tiquete", description = "Servicio para crear un nuevo Tiquete")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
			@ApiResponse(responseCode = "204", description = "No hay información"),
			@ApiResponse(responseCode = "500", description = "Error interno"),
			@ApiResponse(responseCode = "400", description = "Error de request"),
			@ApiResponse(responseCode = "401", description = "No autorizado") })
	@PostMapping("/crearTiquete")
	public ResponseEntity<?> crearTiquete(@RequestBody Tiquetes tiquetes) {

		try {
			Tiquetes tiquetesNuevo = this.tiquetesService.saveTiquete(tiquetes);
			return ResponseEntity.ok(tiquetesNuevo);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("error", "Ocurrió un error interno: " + e.getMessage()));
		}

	}

	@Operation(summary = "actualizarTiquete", description = "Servicio para actualizar un Tiquete")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
			@ApiResponse(responseCode = "204", description = "No hay información"),
			@ApiResponse(responseCode = "500", description = "Error interno"),
			@ApiResponse(responseCode = "400", description = "Error de request"),
			@ApiResponse(responseCode = "401", description = "No autorizado") })
	@PutMapping("actualizarTiquete/{id}")
	public ResponseEntity<?> actualizarTiquete(@RequestBody Tiquetes tiqueteDetalle,
			@PathVariable(value = "id") Integer id) {

		return this.tiquetesService.updateTiquete(tiqueteDetalle, id);

	}

	@Operation(summary = "eliminarTiquete", description = "Servicio para eliminar un Tiquete")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
			@ApiResponse(responseCode = "204", description = "No hay información"),
			@ApiResponse(responseCode = "500", description = "Error interno"),
			@ApiResponse(responseCode = "400", description = "Error de request"),
			@ApiResponse(responseCode = "401", description = "No autorizado") })
	@DeleteMapping("/eliminarTiquete/{id}")
	public ResponseEntity<?> eliminarTiquetes(@PathVariable(value = "id") Integer id) {

		return this.tiquetesService.deleteTiquetes(id);

	}
	

}
