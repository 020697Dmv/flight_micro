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
public class Controller {
	
	/**
	 * Objetos con los metodos de obtener, listar, eliminar y editar
	*/
	@Autowired
	private ClienteRepository clienteRepository;
	

	@Autowired
	private VueloService vueloService;
	
	@Autowired
	private VueloRepository vueloRepository;

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
	
		/**
		 * Metodo que lista todos los Clientes 
		 * @return se retorna un json con todos los Clientes
		 */
		// http://localhost:8080/vuelo (GET)
	@RequestMapping(value="/cliente",method=RequestMethod.GET, produces= "application/json")
	public List<Cliente> getClientes(){
		
		
		return clienteRepository.findAll();
	}
	
	/**
	 * Metodo que extrae unicamente el Json que se le envia por Id
	 * 
	 * @param id codigo con el que se extrae la informacion
	 * @return se retorna un json con el Cliente que corresponde a este id que se dio por parametro
	 */
	// http://localhost:8080/cliente/1 (GET)
	@RequestMapping(value="cliente/{id}", method=RequestMethod.GET, produces= "application/json")
	public ResponseEntity<Cliente> getClienteId(@PathVariable("id") Integer id){

		int dd = id;
		
		Optional <Cliente> optionalCliente= clienteRepository.findById(dd);
		if(optionalCliente.isPresent()) {
			
			return ResponseEntity.ok(optionalCliente.get());

		}else {
			
			return ResponseEntity.noContent().build();

		}
		
	}
	
	/**
	 * Metodo para adicionar un Cliente nuevo, en el cual se listan todos los Clientes
	 * y se valida que el Cliente que solicita este prestamo no este registrado en la B. Ddatos
	 * @param Cliente para ser añadido en la Lista
	 * @return se retorna un json con un mensaje donde se valida si  el Cliente fue añadido o por el contrario no se pudo crear
	 */
	// http://localhost:8080/guardar (POST)
	@PostMapping("/guardar")
	public ResponseEntity guardar (@RequestBody Cliente cliente) {
		


		List<Cliente> clientes=clienteRepository.findAll();
		
		
		

		for (Cliente cliente2 : clientes) {
			
			if(cliente2.getId()==cliente.getId()) {
				
				return new ResponseEntity<>("\"mensaje\" : \"El Cliente con identificaciï¿½n  "+ cliente.getId()
				+ " ya tiene una id igual a la ingresada\"", HttpStatus.BAD_REQUEST);
				
			}

			}
		
		clienteRepository.save(cliente);

		return new ResponseEntity<>("Cliente creado", HttpStatus.CREATED);

		
		
		
			
		
	}
	
	/**
	 * Metodo para editar a un Cliente ya creado, en el cual se listan todos los Clientes
	 * y se valida que el Cliente que solicita este prestamo ya este registrado en la B. Ddatos
	 * @param Cliente para ser editado 
	 * @return se retorna un json con un mensaje donde se valida si  el Cliente fue editado o por el contrario no se pudo editar
	 */
	// http://localhost:8080/1 (PUT)
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Cliente clientedetalle, @PathVariable(value="id") Integer id){
		
		Optional<Cliente> cliente= clienteRepository.findById(id);
		
		
		if(!cliente.isPresent()) {
			System.out.println("editar");
			return ResponseEntity.notFound().build();
		}
		
		cliente.get().setEmail(clientedetalle.getEmail());
		cliente.get().setNombre(clientedetalle.getNombre());
		cliente.get().setTelefono(clientedetalle.getTelefono());
		
		clienteRepository.save(cliente.get());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteRepository.save(cliente.get()));		
	}
	
	/**
	 * Metodo para eliminar un Cliente por el id
	 * 
	 * @param id es el Cliente- registro que deseamos eliminar
	 */
	// http://localhost:8080/employees/eliminar/1 (DELETE)		
	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {

		
		if(!clienteRepository.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
			
		}
		
		clienteRepository.deleteById(id);
		
		return ResponseEntity.ok().build();

		
	}
	
}
