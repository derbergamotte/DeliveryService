package com.ak.ds.services.interfaces;

import java.util.Collection;

import com.ak.ds.api.dto.ProductDto;
import com.ak.ds.entities.Product;

public interface IProductService {
	
	public void addProduct(ProductDto productDto);
	public void addProduct(String name, Collection<Long> categoriesId, Collection<String> attributes, String information);
	public ProductDto getProductById(Long id);
	public Product getProductEntityById(Long id);
	public Collection<ProductDto> getAll();
	public void removeProduct(Long orderId);
	public void updateProduct(ProductDto productDto);
	public Collection<ProductDto> getProductsByCategoryById(Long categoryId);
	public Collection<ProductDto> findByAttributes(Collection<Long> listAttributes);
	public Collection<ProductDto> findByAttributes(Long attribute);
}
