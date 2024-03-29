package com.crud.vuelo.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.NotFound;
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
import com.crud.vuelo.models.Vuelo;
import com.crud.vuelo.repository.ClienteRepository;
import com.crud.vuelo.repository.VueloRepository;
import com.crud.vuelo.service.ClienteService;
import com.crud.vuelo.service.VueloService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/api/v1")
public class VueloController {

	@Autowired
	private VueloService vueloService;

	@ApiOperation(value = "getVuelos")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exitoso", response = Vuelo.class),
		@ApiResponse(code = 204, message = "No hay información"),
		@ApiResponse(code = 500, message = "Error interno"),
		@ApiResponse(code = 400, message = "Error de request"),
		@ApiResponse(code = 401, message = "No autorizado")})
	@GetMapping(value = "/vuelos",  produces = "application/json")
	public List<Vuelo> getVuelos() {

		return this.vueloService.findAllVuelo();
	}

	@ApiOperation(value = "getVueloId", notes = "Servicio para obtener un Vuelos")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exitoso", response = Vuelo.class),
		@ApiResponse(code = 204, message = "No hay información"),
		@ApiResponse(code = 500, message = "Error interno"),
		@ApiResponse(code = 400, message = "Error de request"),
		@ApiResponse(code = 401, message = "No autorizado")})
	@GetMapping(value = "vueloId/{id}", produces = "application/json")
	public ResponseEntity<Vuelo> getVueloId(@PathVariable("id") Integer id) {

		return this.vueloService.findVuelo(id);

	}

	@ApiOperation(value = "actualizarVuelo", notes = "Servicio para actualizar un vuelo")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exitoso", response = Vuelo.class),
		@ApiResponse(code = 204, message = "No hay información"),
		@ApiResponse(code = 500, message = "Error interno"),
		@ApiResponse(code = 400, message = "Error de request"),
		@ApiResponse(code = 401, message = "No autorizado")})
	@PutMapping("actualizarVuelo/{id}")
	public ResponseEntity<?> actualizarVuelo(@RequestBody Vuelo vueloDetalle, @PathVariable(value = "id") Integer id) {

		return this.vueloService.updateVuelo(vueloDetalle, id);

	}

	@ApiOperation(value = "eliminarVuelo", notes = "Servicio para eliminar un vuelo")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exitoso", response = Vuelo.class),
		@ApiResponse(code = 204, message = "No hay información"),
		@ApiResponse(code = 500, message = "Error interno"),
		@ApiResponse(code = 400, message = "Error de request"),
		@ApiResponse(code = 401, message = "No autorizado")})
	@DeleteMapping("/eliminarVuelo/{id}")
	public ResponseEntity<?> eliminarVuelo(@PathVariable(value = "id") Integer id) {

		return this.vueloService.deleteVuelo(id);

	}

	@ApiOperation(value = "crearVuelo", notes = "Servicio para crear un nuevo vuelo")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exitoso", response = Vuelo.class) ,
		@ApiResponse(code = 204, message = "No hay información"),
		@ApiResponse(code = 500, message = "Error interno"),
		@ApiResponse(code = 400, message = "Error de request"),
		@ApiResponse(code = 401, message = "No autorizado")})
	@PostMapping("/crearVuelo")
	public ResponseEntity crearVuelo(@RequestBody Vuelo vuelo) {

		return this.vueloService.saveVuelo(vuelo);

	}
}
