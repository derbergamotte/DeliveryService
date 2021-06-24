package com.ak.ds.services.interfaces;

import java.util.List;

import com.ak.ds.api.dto.CategoryDto;

public interface ICategoryService {
	
	public void addCategory(CategoryDto categoryDto);
	public void addCategory(String name);
	public CategoryDto getCategoryById(Long id);
	public List<CategoryDto> getAll();
	public void removeCategory(Long categoryId);
	public void updateCategory(CategoryDto categoryDto);
	public void addProductInCategory(List<Long> categoriesId, Long productId);
}
