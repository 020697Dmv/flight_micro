package com.crud.vuelo.models.mapper;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.crud.vuelo.models.Dto.ProductosDto;
import com.fasterxml.jackson.databind.JsonNode;

@Component
public class Mapper {

	
	public List<ProductosDto> mappingToProductosDto(JsonNode datos) {
	    List<ProductosDto> productos = new ArrayList<>();

	    if (datos.isArray()) {
	        for (JsonNode element : datos) {
	            ProductosDto productoDto = new ProductosDto(
	                element.get("id").asLong(),
	                element.get("title").asText(),
	                element.get("price").asDouble(),
	                element.get("description").asText(),
	                element.get("category").asText(),
	                element.get("image").asText()
	            );
	            productos.add(productoDto);
	        }
	    }

	    return productos;
	}
	
	
}
