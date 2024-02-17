package com.crud.vuelo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.vuelo.models.Empresa;
import com.crud.vuelo.repository.EmpresaRepository;
import com.crud.vuelo.service.EmpresaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
public class EmpresaController {
	
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@Autowired
	private EmpresaService empresaService;
	
	
	@ApiOperation(value = "getEmpresas", notes = "Servicio para obtener todas las empresas")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exitoso", response = Empresa.class), 
	@ApiResponse(code = 204, message = "No hay información"),
	@ApiResponse(code = 500, message = "Error interno"),
	@ApiResponse(code = 400, message = "Error de request"),
	@ApiResponse(code = 401, message = "No autorizado")})
	@GetMapping(value ="/empresas", produces = "application/json")
	public List<Empresa> getEmpresas() {

		return this.empresaService.findAllEmpresas();
	}
	
	

}
