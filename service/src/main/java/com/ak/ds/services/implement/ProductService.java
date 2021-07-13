package com.ak.ds.services.implement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.ak.ds.api.dto.ProductDto;
import com.ak.ds.api.mappers.ProductMapper;
import com.ak.ds.dao.factory.DaoFactory;
import com.ak.ds.dao.factory.IDaoFactory;
import com.ak.ds.dao.interfaces.IProductDao;
import com.ak.ds.entities.Attribute;
import com.ak.ds.entities.Category;
import com.ak.ds.entities.Product;
import com.ak.ds.entities.Storage;
import com.ak.ds.services.factories.IServiceFactory;
import com.ak.ds.services.factories.ServiceFactory;
import com.ak.ds.services.interfaces.IAttributeService;
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

	private IDaoFactory daoFactory = new DaoFactory();
	private IProductDao productDao = daoFactory.getProductDao();

	private IServiceFactory serviceFactory = new ServiceFactory();
	private IAttributeService attributeService = serviceFactory.getAttributeService();
	private ICategoryService categoryService = serviceFactory.getCategoryService();
	
	public void addProduct(ProductDto productDto) {
		Product product = ProductMapper.dtoToEntity(productDto);
		product.setStorages(new ArrayList<Storage>());
		product = productDao.add(product);
	}
	
	public void addProduct(String name, Collection<Long> categoriesId, Collection<String> attributeNames, String information) {
		Collection<Attribute> attributes = attributeNames.stream().map(a -> attributeService.addAttribute(a)).collect(Collectors.toSet());
		Collection<Category> categories = categoriesId.stream().map(c-> categoryService.getCategoryEntityById(c)).collect(Collectors.toSet());
		Product product = new Product(name, categories, new ArrayList<Storage>(), attributes, information);
		product = productDao.add(product);
	}

	public ProductDto getProductById(Long id) {
		return ProductMapper.entityToDto(getProductEntityById(id));
	}

	public Product getProductEntityById(Long id) {
		return Optional.ofNullable(Optional.ofNullable(this.productDao.get(id)).orElse(new Product())).get();
	}

	public Collection<ProductDto> getAll() {
		return ProductMapper.convertList(productDao.getAll());
	}

	public void removeProduct(Long orderId) {
		productDao.remove(orderId);
	}

	public void updateProduct(ProductDto productDto) {
		if (!(productDto.getId() == null)) {
			Product product = getProductEntityById(productDto.getId());
			if (StringUtils.isNotEmpty(productDto.getName())) {
				product.setName(productDto.getName());
			}
			if (StringUtils.isNotEmpty(productDto.getInformation())) {
				product.setInformation(productDto.getInformation());
			}
			productDao.update(product);
		}
	}

	public Collection<ProductDto> getProductsByCategoryById(Long categoryId) {
		Collection<Long> listProductId = categoryService.getCategoryById(categoryId).getProductsId();
		Collection<ProductDto> listProduct = listProductId.stream().map(c-> getProductById(c)).collect(Collectors.toSet());
		return listProduct;
	}

	public Collection<ProductDto> findByAttributes(Collection<Long> listAttributesId) {
		return ProductMapper.convertList(productDao.findByAttributes(listAttributesId));
	}

	public Collection<ProductDto> findByAttributes(Long attributeId) {
		Collection<Long> listAttributesId = new HashSet<>();
		listAttributesId.add(attributeId);
		return ProductMapper.convertList(productDao.findByAttributes(listAttributesId));
	}
}
