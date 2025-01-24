package com.crud.vuelo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.vuelo.models.Dto.ProductosDto;
import com.crud.vuelo.service.ProductoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/v1")
public class ProductoController {
	
	
	@Autowired
	private ProductoService productoService;
	
	
	@Operation(summary = "getProductos", description = "Servicio para obtener todod los productos")
	@ApiResponses({ @ApiResponse(responseCode = "200", description = "Exitoso"),
		@ApiResponse(responseCode = "204", description = "No hay información"),
		@ApiResponse(responseCode = "500", description = "Error interno"),
		@ApiResponse(responseCode = "400", description = "Error de request"),
		@ApiResponse(responseCode = "401", description = "No autorizado")})
	@GetMapping(value = "/productos", produces = "application/json")
	public List<ProductosDto> getProductos() throws IOException {

		return this.productoService.obtenerProductos();
	}

}
