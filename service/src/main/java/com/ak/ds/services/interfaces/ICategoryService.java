package com.ak.ds.services.interfaces;

import java.util.Collection;

import com.ak.ds.api.dto.CategoryDto;
import com.ak.ds.entities.Category;

public interface ICategoryService {
	
	public void addCategory(CategoryDto categoryDto);
	public void addCategory(String name);
	public CategoryDto getCategoryById(Long id);
	public Category getCategoryEntityById(Long id);
	public Collection<CategoryDto> getAll();
	public void removeCategory(Long categoryId);
	public void updateCategory(CategoryDto categoryDto);
}
