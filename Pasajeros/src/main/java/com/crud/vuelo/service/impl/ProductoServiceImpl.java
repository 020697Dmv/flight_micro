package com.crud.vuelo.service.impl;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.crud.vuelo.models.Dto.ProductosDto;
import com.crud.vuelo.models.mapper.Mapper;
import com.crud.vuelo.service.ProductoService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProductoServiceImpl implements ProductoService{

	
	private RestTemplate restTemplate= new RestTemplate();
	
	private HttpHeaders httpHeaders = new HttpHeaders();
	
	@Autowired
	private Mapper mapper;
	
	private ObjectMapper objectMapper= new ObjectMapper();
	
	public ProductoServiceImpl() {this.httpHeaders.setContentType(MediaType.APPLICATION_JSON);}
	
	
	@Override
	public List<ProductosDto> obtenerProductos() throws IOException {
	    ResponseEntity<JsonNode> responseEntity =
	            restTemplate.getForEntity(
	                    "https://fakestoreapi.com/products",
	                    JsonNode.class);

	    if (responseEntity.getStatusCode() == HttpStatus.OK) {
	        JsonNode productosNode = responseEntity.getBody();
	        if (productosNode != null) {
	            return mapper.mappingToProductosDto(productosNode);
	        }
	    }

	    return Collections.emptyList();
	}

	
	
}
