package com.crud.vuelo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.vuelo.models.Vuelo;
import com.crud.vuelo.service.VueloService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/api/v1")
public class VueloController {

	@Autowired
	private VueloService vueloService;

	@Operation(summary = "getVuelos")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
		@ApiResponse(responseCode = "204", description = "No hay información"),
		@ApiResponse(responseCode = "500", description = "Error interno"),
		@ApiResponse(responseCode = "400", description = "Error de request"),
		@ApiResponse(responseCode = "401", description = "No autorizado")})
	@GetMapping(value = "/vuelos",  produces = "application/json")
	public List<Vuelo> getVuelos() {

		return this.vueloService.findAllVuelo();
	}

	@Operation(summary = "getVueloId", description = "Servicio para obtener un Vuelos")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
		@ApiResponse(responseCode = "204", description = "No hay información"),
		@ApiResponse(responseCode = "500", description = "Error interno"),
		@ApiResponse(responseCode = "400", description = "Error de request"),
		@ApiResponse(responseCode = "401", description = "No autorizado")})
	@GetMapping(value = "vueloId/{id}", produces = "application/json")
	public ResponseEntity<Vuelo> getVueloId(@PathVariable("id") Integer id) {

		return this.vueloService.findVuelo(id);

	}

	@Operation(summary = "actualizarVuelo", description = "Servicio para actualizar un vuelo")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
		@ApiResponse(responseCode = "204", description = "No hay información"),
		@ApiResponse(responseCode = "500", description = "Error interno"),
		@ApiResponse(responseCode = "400", description = "Error de request"),
		@ApiResponse(responseCode = "401", description = "No autorizado")})
	@PutMapping("actualizarVuelo/{id}")
	public ResponseEntity<?> actualizarVuelo(@RequestBody Vuelo vueloDetalle, @PathVariable(value = "id") Integer id) {

		return this.vueloService.updateVuelo(vueloDetalle, id);

	}

	@Operation(summary = "eliminarVuelo", description = "Servicio para eliminar un vuelo")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
		@ApiResponse(responseCode = "204", description = "No hay información"),
		@ApiResponse(responseCode = "500", description = "Error interno"),
		@ApiResponse(responseCode = "400", description = "Error de request"),
		@ApiResponse(responseCode = "401", description = "No autorizado")})
	@DeleteMapping("/eliminarVuelo/{id}")
	public ResponseEntity<?> eliminarVuelo(@PathVariable(value = "id") Integer id) {

		return this.vueloService.deleteVuelo(id);

	}

	@Operation(summary = "crearVuelo", description = "Servicio para crear un nuevo vuelo")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso") ,
		@ApiResponse(responseCode = "204", description = "No hay información"),
		@ApiResponse(responseCode = "500", description = "Error interno"),
		@ApiResponse(responseCode = "400", description = "Error de request"),
		@ApiResponse(responseCode = "401", description = "No autorizado")})
	@PostMapping("/crearVuelo")
	public ResponseEntity crearVuelo(@RequestBody Vuelo vuelo) {

		return this.vueloService.saveVuelo(vuelo);

	}
}
