package com.crud.vuelo.service;


import java.io.IOException;
import java.util.List;

import com.crud.vuelo.models.Dto.ProductosDto;

public interface ProductoService {

	
	public List<ProductosDto> obtenerProductos() throws IOException;
	
}
