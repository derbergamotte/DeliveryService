package com.ak.ds.services.interfaces;

import java.util.List;

import com.ak.ds.api.dto.ProductDto;

public interface IProductService {
	
	public void addProduct(ProductDto productDto);
	public void addProduct(String name, List<Long> categories, List<String> attributes, String information);
	public ProductDto getProductById(Long id);
	public List<ProductDto> getAll();
	public void removeProduct(Long orderId);
	public void updateProduct(ProductDto productDto);
	public void addProductInStorage(Long storageId, Long productId);
	public List<ProductDto> getProductsByCategoryById(Long categoryId);
	public List<ProductDto> findByAttributes(List<String> listAttributes);
	public List<ProductDto> findByAttributes(String attribute);
}
