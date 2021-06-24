package com.ak.ds.services.implement;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import com.ak.ds.api.dto.CategoryDto;
import com.ak.ds.api.mappers.CategoryMapper;
import com.ak.ds.dao.implement.CategoryDao;
import com.ak.ds.dao.interfaces.ICategoryDao;
import com.ak.ds.entities.Category;
import com.ak.ds.services.interfaces.ICategoryService;

public class CategoryService implements ICategoryService{

	private ICategoryDao categoryDao = new CategoryDao();
		
	public void addCategory(CategoryDto categoryDto) {
		Category category = CategoryMapper.dtoToEntity(categoryDto);
		category.setProductsId(new HashSet<Long>());
		categoryDao.add(category);
	}
	
	public void addCategory(String name) {
		Category category = new Category();
		category.setName(name);
		category.setProductsId(new HashSet<Long>());
		categoryDao.add(category);
	}
	
	public CategoryDto getCategoryById(Long id) {
		return CategoryMapper.entityToDto(getCategoryEntity(id));
	}
	
	private Category getCategoryEntity(Long id) {
		return Optional.ofNullable(Optional.ofNullable(this.categoryDao.get(id)).orElse(new Category())).get();
	}
		
	public List<CategoryDto> getAll(){
		return CategoryMapper.convertList(categoryDao.getAll());
	}
	
	public void removeCategory(Long categoryId) {
		categoryDao.remove(categoryId);
	}
	
	public void updateCategory(CategoryDto categoryDto) {
		if(!(categoryDto.getId() == null)) {
		Category category = getCategoryEntity(categoryDto.getId());
		if(StringUtils.isNotEmpty(categoryDto.getName())) {
			category.setName(categoryDto.getName());
		}
		categoryDao.update(category);
		}
	}
	
	public void addProductInCategory(List<Long> categoriesId, Long productId) {
		for(Long categoryId : categoriesId) {
			Category category = categoryDao.get(categoryId);
			category.getProductsId().add(productId);
			categoryDao.update(category);
		}
	}
}
