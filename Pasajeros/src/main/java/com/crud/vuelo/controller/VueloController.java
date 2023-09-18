package com.crud.vuelo.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crud.vuelo.entity.Cliente;
import com.crud.vuelo.entity.Vuelo;
import com.crud.vuelo.repository.ClienteRepository;
import com.crud.vuelo.repository.VueloRepository;
import com.crud.vuelo.service.ClienteService;
import com.crud.vuelo.service.VueloService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase Controlador
 * 
 * @author Danny Macias Vanegas
 *
 */
@RestController
@RequestMapping("/api/v1")
public class VueloController {
	
	/**
	 * Objetos con los metodos de obtener, listar, eliminar y editar
	*/
	

	@Autowired
	private VueloService vueloService;
	
	
	/**
	 * Metodo que lista todos los Vuelos 
	 * @return se retorna un json con todos los Vuelos
	 */
	// http://localhost:8080/vuelo (GET)
	@ApiOperation(value="getVuelos")
	@ApiResponses({
		@ApiResponse(code=200, message="Exitoso", response = Vuelo.class)
	})
	@RequestMapping(value = "/vuelo", method = RequestMethod.GET, produces = "application/json")
	public List<Vuelo> getVuelos() {

		return this.vueloService.findAllVuelo();
	}
	
	@ApiOperation(value = "getVueloId", notes = "Servicio para obtener un Vuelos")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exitoso", response = Vuelo.class) })
	@RequestMapping(value = "vueloId/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Vuelo> getVueloId(@PathVariable("id") Integer id) {

		return this.vueloService.findVuelo(id);

	}
	
	@ApiOperation(value = "actualizarVuelo", notes = "Servicio para actualizar un vuelo")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exitoso", response = Vuelo.class) })
	@PutMapping("actualizarVuelo/{id}")
	public ResponseEntity<?> actualizarVuelo(@RequestBody Vuelo vueloDetalle, @PathVariable(value = "id") Integer id) {

		return this.vueloService.updateVuelo(vueloDetalle, id);

	}
}
