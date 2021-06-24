package com.ak.ds.api.mappers;

import java.util.ArrayList;
import java.util.List;

import com.ak.ds.api.dto.CategoryDto;
import com.ak.ds.entities.Category;

public class CategoryMapper {
	
	private CategoryMapper() {}
	
	public static CategoryDto entityToDto(Category entity) {
		CategoryDto dto = new CategoryDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setProductsId(entity.getProductsId());
		return dto;
	}
	
	public static Category dtoToEntity(CategoryDto dto) {
		Category entity = new Category();
		entity.setName(dto.getName());
		entity.setProductsId(dto.getProductsId());
		return entity;
	}
	
	public static List<CategoryDto> convertList(List<Category> entities){
		List<CategoryDto> listDto = new ArrayList<>();
		for(Category entity : entities) {
			CategoryDto dto = entityToDto(entity);
			listDto.add(dto);
		}
		return listDto;
	}
}
