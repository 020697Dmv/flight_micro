package com.crud.vuelo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.vuelo.models.Empresa;
import com.crud.vuelo.repository.EmpresaRepository;
import com.crud.vuelo.service.EmpresaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;

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
	
	

}
