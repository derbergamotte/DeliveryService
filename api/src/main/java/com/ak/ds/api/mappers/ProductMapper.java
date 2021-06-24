package com.ak.ds.api.mappers;

import java.util.ArrayList;
import java.util.List;

import com.ak.ds.api.dto.ProductDto;
import com.ak.ds.entities.Product;

public class ProductMapper {
	
	private ProductMapper() {}
	
	public static ProductDto entityToDto(Product entity) {
		ProductDto dto = new ProductDto();
		dto.setId(entity.getId());
		dto.setCategoriesId(entity.getCategoriesId());
		dto.setStoragesId(entity.getStoragesId());
		dto.setName(entity.getName());
		dto.setAttributes(entity.getAttributes());
		dto.setInformation(entity.getInformation());
		return dto;
	}
	
	public static Product dtoToEntity(ProductDto dto) {
		Product entity = new Product();
		entity.setId(dto.getId());
		entity.setCategoriesId(dto.getCategoriesId());
		entity.setCategoriesId(dto.getCategoriesId());
		entity.setName(dto.getName());
		entity.setAttributes(dto.getAttributes());
		entity.setInformation(dto.getInformation());
		return entity;
	}
	
	public static List<ProductDto> convertList(List<Product> entities){
		List<ProductDto> listDto = new ArrayList<>();
		for(Product entity : entities) {
			ProductDto dto = entityToDto(entity);
			listDto.add(dto);
		}
		return listDto;
	}
}
