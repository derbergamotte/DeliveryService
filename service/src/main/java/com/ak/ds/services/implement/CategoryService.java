package com.ak.ds.services.implement;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import com.ak.ds.api.dto.CategoryDto;
import com.ak.ds.api.mappers.CategoryMapper;
import com.ak.ds.dao.factory.DaoFactory;
import com.ak.ds.dao.factory.IDaoFactory;
import com.ak.ds.dao.interfaces.IAGenericDao;
import com.ak.ds.entities.Category;
import com.ak.ds.entities.Product;
import com.ak.ds.services.interfaces.ICategoryService;

public class CategoryService implements ICategoryService{
	
	private CategoryService() {
	}
	
	private static CategoryService categoryService;
	
	public static CategoryService getCategoryService() {
		if (categoryService == null) {
			categoryService = new CategoryService();
		}
		return categoryService;
	}

	private IDaoFactory daoFactory = new DaoFactory();
	private IAGenericDao<Category> categoryDao = daoFactory.getCategoryDao();
		
	public void addCategory(CategoryDto categoryDto) {
		Category category = CategoryMapper.dtoToEntity(categoryDto);
		category.setProducts(new HashSet<Product>());
		categoryDao.add(category);
	}
	
	public void addCategory(String name) {
		categoryDao.add(new Category(name, new HashSet<Product>()));
	}
	
	public CategoryDto getCategoryById(Long id) {
		return CategoryMapper.entityToDto(getCategoryEntityById(id));
	}
	
	public Category getCategoryEntityById(Long id) {
		return Optional.ofNullable(Optional.ofNullable(this.categoryDao.get(id)).orElse(new Category())).get();
	}
		
	public Collection<CategoryDto> getAll(){
		return CategoryMapper.convertList(categoryDao.getAll());
	}
	
	public void removeCategory(Long categoryId) {
		categoryDao.remove(categoryId);
	}
	
	public void updateCategory(CategoryDto categoryDto) {
		if(!(categoryDto.getId() == null)) {
		Category category = getCategoryEntityById(categoryDto.getId());
		if(StringUtils.isNotEmpty(categoryDto.getName())) {
			category.setName(categoryDto.getName());
		}
		categoryDao.update(category);
		}
	}
}
