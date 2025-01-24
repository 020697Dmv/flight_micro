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

import com.crud.vuelo.models.Cliente;
import com.crud.vuelo.models.Empresa;
import com.crud.vuelo.repository.EmpresaRepository;
import com.crud.vuelo.service.EmpresaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1")
public class EmpresaController {
	
	
	
    //@Value("${spring.datasource.username}")
	public String data;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EmpresaService empresaService;
	
	
	@Operation(summary = "getEmpresas", description = "Servicio para obtener todas las empresas")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"), 
	@ApiResponse(responseCode = "204", description = "No hay información"),
	@ApiResponse(responseCode = "500", description = "Error interno"),
	@ApiResponse(responseCode = "400", description = "Error de request"),
	@ApiResponse(responseCode = "401", description = "No autorizado")})
	@GetMapping(value ="/empresas", produces = "application/json")
	public List<Empresa> getEmpresas() {

		return this.empresaService.findAllEmpresas();
	}
	
	
	@Operation(summary = "Obtener una empresa por id", description = "Servicio para leer las empresas por ID")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
		@ApiResponse(responseCode = "204", description = "No hay información"),
		@ApiResponse(responseCode = "500", description = "Error interno"),
		@ApiResponse(responseCode = "400", description = "Error de request"),
		@ApiResponse(responseCode = "401", description = "No autorizado")})
	@GetMapping(value = "empresaId/{id}",  produces = "application/json")
	public ResponseEntity<Empresa> getEmpresaId(@PathVariable("id") Integer id) {

		return this.empresaService.findEmpresa(id);

	}
	
	@Operation(summary = "Crear Empresa", description = "Servicio para crear una nueva Empresa")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
		@ApiResponse(responseCode = "204", description = "No hay información"),
		@ApiResponse(responseCode = "500", description = "Error interno"),
		@ApiResponse(responseCode = "400", description = "Error de request"),
		@ApiResponse(responseCode = "401", description = "No autorizado")})
	@PostMapping("/crearEmpresa")
	public Empresa crearEmpresa(@RequestBody Empresa empresa) {

		return this.empresaService.saveEmpresa(empresa);

	}
	
	@Operation(summary = "actualizarEmpresa", description = "Servicio para actualizar una Empresa")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
		@ApiResponse(responseCode = "204", description = "No hay información"),
		@ApiResponse(responseCode = "500", description = "Error interno"),
		@ApiResponse(responseCode = "400", description = "Error de request"),
		@ApiResponse(responseCode = "401", description = "No autorizado")})
	@PutMapping("actualizarEmpresa/{id}")
	public ResponseEntity<?> actualizarEmpresa(@RequestBody Empresa empresadetalle,
			@PathVariable(value = "id") Integer id) {

		return this.empresaService.updateEmpresa(empresadetalle, id);

	}
	
	
	@Operation(summary = "eliminarEmpresa", description = "Servicio para eliminar una Empresa")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
		@ApiResponse(responseCode = "204", description = "No hay información"),
		@ApiResponse(responseCode = "500", description = "Error interno"),
		@ApiResponse(responseCode = "400", description = "Error de request"),
		@ApiResponse(responseCode = "401", description = "No autorizado")})
	@DeleteMapping("/eliminarEmpresa/{id}")
	public ResponseEntity<?> eliminarEmpresa(@PathVariable(value = "id") Integer id) {

		return this.empresaService.deleteEmpresa(id);

	}
}
