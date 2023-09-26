package com.crud.vuelo.controller;

import java.util.List;
import java.util.Optional;

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
public class ClienteController {

	/**
	 * Objetos con los metodos de obtener, listar, eliminar y editar
	 */
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteService clienteService;

	/**
	 * Metodo que lista todos los Clientes
	 * 
	 * @return se retorna un json con todos los Clientes
	 */
	// http://localhost:8080/vuelo (GET)
	@ApiOperation(value = "getCliente", notes = "Servicio para obtener todod los clientes")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exitoso", response = Cliente.class) })
	@RequestMapping(value = "/clientes", method = RequestMethod.GET, produces = "application/json")
	public List<Cliente> getClientes() {

		return this.clienteService.findAllCliente();
	}

	/**
	 * Metodo que extrae unicamente el Json que se le envia por Id
	 * 
	 * @param id codigo con el que se extrae la informacion
	 * @return se retorna un json con el Cliente que corresponde a este id que se
	 *         dio por parametro
	 */
	// http://localhost:8080/cliente/1 (GET)
	@ApiOperation(value = "getClienteId", notes = "Servicio para leer los clientes por ID")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exitoso", response = Cliente.class) })
	@RequestMapping(value = "clienteId/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Cliente> getClienteId(@PathVariable("id") Integer id) {

		return this.clienteService.findCliente(id);

	}

	/**
	 * Metodo para adicionar un Cliente nuevo, en el cual se listan todos los
	 * Clientes y se valida que el Cliente que solicita este prestamo no este
	 * registrado en la B. Ddatos
	 * 
	 * @param Cliente para ser añadido en la Lista
	 * @return se retorna un json con un mensaje donde se valida si el Cliente fue
	 *         añadido o por el contrario no se pudo crear
	 */
	// http://localhost:8080/guardar (POST)
	@ApiOperation(value = "crearCliente", notes = "Servicio para crear un nuevo cliente")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exitoso", response = Cliente.class) })
	@PostMapping("/crearCliente" )
	public Cliente crearCliente(@RequestBody Cliente cliente) {

		return this.clienteService.saveCliente(cliente);

	}

	/**
	 * Metodo para editar a un Cliente ya creado, en el cual se listan todos los
	 * Clientes y se valida que el Cliente que solicita este prestamo ya este
	 * registrado en la B. Ddatos
	 * 
	 * @param Cliente para ser editado
	 * @return se retorna un json con un mensaje donde se valida si el Cliente fue
	 *         editado o por el contrario no se pudo editar
	 */
	@ApiOperation(value = "actualizarCliente", notes = "Servicio para actualizar un cliente")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exitoso", response = Cliente.class) })
	@PutMapping("actualizarCliente/{id}")
	public ResponseEntity<?> actualizarCliente(@RequestBody Cliente clientedetalle, @PathVariable(value = "id") Integer id) {

		return this.clienteService.updateCliente(clientedetalle, id);

	}

	/**
	 * Metodo para eliminar un Cliente por el id
	 * 
	 * @param id es el Cliente- registro que deseamos eliminar
	 */
	@ApiOperation(value = "eliminarCliente", notes = "Servicio para eliminar un cliente")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exitoso", response = Cliente.class) })
	@DeleteMapping("/eliminarCliente/{id}")
	public ResponseEntity<?> eliminarCliente(@PathVariable(value = "id") Integer id) {

		return this.clienteService.deleteCliente(id);

	}

}
