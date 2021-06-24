package com.ak.ds.dao.implement;

import java.util.ArrayList;
import java.util.List;

import com.ak.ds.dao.interfaces.IProductDao;
import com.ak.ds.entities.Product;

public class ProductDao extends AGenericDao<Product> implements IProductDao{
	
	public ProductDao() {
		super(Product.class);
	}
	
	public List<Product> findByAttributes(List<String> listAttributes) {
		List<Product> listProducts = new ArrayList<>();
		for (Product product : getAll()) {
			if (product.getAttributes().containsAll(listAttributes)) {
				listProducts.add(product);
			}
		}
		return listProducts;
	}
	
	public List<Product> findByAttributes(String Attribute) {
		List<Product> listProducts = new ArrayList<>();
		for (Product product : getAll()) {
			if (product.getAttributes().contains(Attribute)) {
				listProducts.add(product);
			}
		}
		return listProducts;
	}
}
