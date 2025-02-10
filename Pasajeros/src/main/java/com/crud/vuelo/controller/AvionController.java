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

import com.crud.vuelo.models.Avion;
import com.crud.vuelo.models.Cliente;
import com.crud.vuelo.service.AvionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
@RequiredArgsConstructor
public class AvionController {
	
	@Autowired
	private AvionService avionService;
	
	
	@Operation(summary = "Obtener Aviones", description = "Servicio para obtener todos los Aviones")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
			@ApiResponse(responseCode = "204", description = "No hay información"),
			@ApiResponse(responseCode = "500", description = "Error interno"),
			@ApiResponse(responseCode = "400", description = "Error de request"),
			@ApiResponse(responseCode = "401", description = "No autorizado") })
	@GetMapping(value = "/aviones", produces = "application/json")
	public List<Avion> getAviones() {

		return this.avionService.findAllAvion();

	}
	
	@Operation(summary = "Obtener Aviones por id", description = "Servicio para leer los Aviones por ID")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
			@ApiResponse(responseCode = "204", description = "No hay información"),
			@ApiResponse(responseCode = "500", description = "Error interno"),
			@ApiResponse(responseCode = "400", description = "Error de request"),
			@ApiResponse(responseCode = "401", description = "No autorizado") })
	@GetMapping(value = "avionId/{id}", produces = "application/json")
	public ResponseEntity<Avion> getAvionId(@PathVariable("id") Integer id) {

		return this.avionService.findAvion(id);

	}
	
	@Operation(summary = "Crear Avion", description = "Servicio para crear un nuevo Avion")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
			@ApiResponse(responseCode = "204", description = "No hay información"),
			@ApiResponse(responseCode = "500", description = "Error interno"),
			@ApiResponse(responseCode = "400", description = "Error de request"),
			@ApiResponse(responseCode = "401", description = "No autorizado") })
	@PostMapping("/crearAvion")
	public ResponseEntity<?> crearAvion(@RequestBody Avion avion) {

		try {
			Avion avionNuevo = this.avionService.saveAvion(avion);
			return ResponseEntity.ok(avionNuevo);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error", e.getMessage()));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("error", "Ocurrió un error interno: " + e.getMessage()));
		}

	}
	
	
	@Operation(summary = "actualizarAvion", description = "Servicio para actualizar un Avion")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
			@ApiResponse(responseCode = "204", description = "No hay información"),
			@ApiResponse(responseCode = "500", description = "Error interno"),
			@ApiResponse(responseCode = "400", description = "Error de request"),
			@ApiResponse(responseCode = "401", description = "No autorizado") })
	@PutMapping("actualizarAvion/{id}")
	public ResponseEntity<?> actualizarAvion(@RequestBody Avion avionDetalle,
			@PathVariable(value = "id") Integer id) {

		return this.avionService.updateAvion(avionDetalle, id);

	}
	
	
	@Operation(summary = "eliminarAvion", description = "Servicio para eliminar un Avion")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
			@ApiResponse(responseCode = "204", description = "No hay información"),
			@ApiResponse(responseCode = "500", description = "Error interno"),
			@ApiResponse(responseCode = "400", description = "Error de request"),
			@ApiResponse(responseCode = "401", description = "No autorizado") })
	@DeleteMapping("/eliminarAvion/{id}")
	public ResponseEntity<?> eliminarAvion(@PathVariable(value = "id") Integer id) {

		return this.avionService.deleteAvion(id);

	}


}
