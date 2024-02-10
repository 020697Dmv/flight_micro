package com.crud.vuelo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crud.vuelo.models.Dto.ProductosDto;
import com.crud.vuelo.service.ProductoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
public class ProductoController {
	
	
	@Autowired
	private ProductoService productoService;
	
	
	@ApiOperation(value = "getProductos", notes = "Servicio para obtener todod los productos")
	@ApiResponses({ @ApiResponse(code = 200, message = "Exitoso", response = ProductosDto.class),
		@ApiResponse(code = 204, message = "No hay información"),
		@ApiResponse(code = 500, message = "Error interno"),
		@ApiResponse(code = 400, message = "Error de request"),
		@ApiResponse(code = 401, message = "No autorizado")})
	@GetMapping(value = "/productos", produces = "application/json")
	public List<ProductosDto> getProductos() throws IOException {

		return this.productoService.obtenerProductos();
	}

}
