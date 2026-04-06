package com.crud.vuelo.before.service;


import java.io.IOException;
import java.util.List;

import com.crud.vuelo.before.models.dtos.ProductosDto;

public interface ProductoService {

	
	public List<ProductosDto> obtenerProductos() throws IOException;
	
}
