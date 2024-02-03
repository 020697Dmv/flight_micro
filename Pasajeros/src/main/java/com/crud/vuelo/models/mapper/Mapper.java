package com.crud.vuelo.models.mapper;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.crud.vuelo.models.Dto.ProductosDto;
import com.fasterxml.jackson.databind.JsonNode;

public class Mapper {

	
	 public List<ProductosDto> mappingToProductosDto ( Iterator<JsonNode> datos){
		 
		 List<ProductosDto> productos=  new ArrayList<>() ;
		 
		 productos.add(new ProductosDto());
		 
		 datos.forEachRemaining(element -> productos.add(
				 
				 
				 new ProductosDto(element.get("id").asInt(),						 				 
						 element.get("title").asText(),
						 element.get("price").asDouble(),
						 element.get("description").asText(),
						 element.get("category").asText(),
						 element.get("image").asText(),
						 element.get("rating")						 
						 )));
		 
		 
		 
		 return productos;
		 
	 }
	
	
}
