package com.ak.ds.services.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import com.ak.ds.api.dto.ProductDto;
import com.ak.ds.api.mappers.ProductMapper;
import com.ak.ds.dao.implement.ProductDao;
import com.ak.ds.dao.interfaces.IProductDao;
import com.ak.ds.entities.Product;
import com.ak.ds.services.interfaces.ICategoryService;
import com.ak.ds.services.interfaces.IProductService;

public class ProductService implements IProductService {
	
	private ProductService() {
	}
	
	private static ProductService productService;
	
	public static ProductService getProductService() {
		if (productService == null) {
			productService = new ProductService();
		}
		return productService;
	}

	private IProductDao productDao = ProductDao.getProductDao();

	private ICategoryService categoryService = CategoryService.getCategoryService();

	public void addProduct(ProductDto productDto) {
		Product product = ProductMapper.dtoToEntity(productDto);
		product.setStoragesId(new ArrayList<Long>());
		product = productDao.add(product);
		categoryService.addProductInCategory(product.getCategoriesId(), product.getId());
	}
	
	public void addProduct(String name, List<Long> categories, List<String> attributes, String information) {
		Product product = new Product(name, categories, new ArrayList<Long>(), attributes, information);
		product = productDao.add(product);
		categoryService.addProductInCategory(product.getCategoriesId(), product.getId());
	}

	public ProductDto getProductById(Long id) {
		return ProductMapper.entityToDto(getProductEntity(id));
	}

	private Product getProductEntity(Long id) {
		return Optional.ofNullable(Optional.ofNullable(this.productDao.get(id)).orElse(new Product())).get();
	}

	public List<ProductDto> getAll() {
		return ProductMapper.convertList(productDao.getAll());
	}

	public void removeProduct(Long orderId) {
		productDao.remove(orderId);
	}

	public void updateProduct(ProductDto productDto) {
		if (!(productDto.getId() == null)) {
			Product product = getProductEntity(productDto.getId());
			if (StringUtils.isNotEmpty(productDto.getName())) {
				product.setName(productDto.getName());
			}
			if (StringUtils.isNotEmpty(productDto.getInformation())) {
				product.setInformation(productDto.getInformation());
			}
			productDao.update(product);
		}
	}

	public void addProductInStorage(Long storageId, Long productId) {
		Product product = getProductEntity(productId);
		try {
			product.getStoragesId().add(storageId);
			productDao.update(product);
		} catch (NullPointerException e) {
			System.out.println("There isn't that product");
		}
	}

	public List<ProductDto> getProductsByCategoryById(Long categoryId) {
		List<ProductDto> listProduct = new ArrayList<>();
		for (Long productId : categoryService.getCategoryById(categoryId).getProductsId()) {
			listProduct.add(getProductById(productId));
		}
		return listProduct;
	}

	public List<ProductDto> findByAttributes(List<String> listAttributes) {
		return ProductMapper.convertList(productDao.findByAttributes(listAttributes));
	}

	public List<ProductDto> findByAttributes(String attribute) {
		return ProductMapper.convertList(productDao.findByAttributes(attribute));
	}
}
