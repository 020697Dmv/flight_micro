package com.crud.vuelo.models.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductosDto {

	private long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
	
}
