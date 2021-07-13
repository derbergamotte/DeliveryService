package com.ak.ds.dao.implement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.ak.ds.dao.factory.DaoFactory;
import com.ak.ds.dao.factory.IDaoFactory;
import com.ak.ds.dao.interfaces.IAttributeDao;
import com.ak.ds.dao.interfaces.ICategoryDao;
import com.ak.ds.dao.interfaces.IProductDao;
import com.ak.ds.entities.Attribute;
import com.ak.ds.entities.Category;
import com.ak.ds.entities.Product;

public class ProductDao extends AGenericDao<Product> implements IProductDao {

	private ProductDao() {
		super(Product.class);
	}

	private static ProductDao productDao;

	public static ProductDao getProductDao() {
		if (productDao == null) {
			productDao = new ProductDao();
		}
		return productDao;
	}

	IDaoFactory daoFactory = new DaoFactory();
	ICategoryDao categoryDao = daoFactory.getCategoryDao();
	IAttributeDao attributeDao = daoFactory.getAttributeDao();

	@Override
	@Transactional
	public Product add(Product product) {
		product.setCategories(product.getCategories().stream().map(c -> new Category(c)).collect(Collectors.toSet()));
		product.setAttributes(product.getAttributes().stream().map(a -> new Attribute(a)).collect(Collectors.toSet()));
		product = super.add(product);
		for (Category category : product.getCategories()) {
			Category categoryInDao = categoryDao.get(category.getId());
			categoryInDao.getProducts().add(new Product(product));
			categoryDao.update(categoryInDao);
		}
		for (Attribute attribute : product.getAttributes()) {
			Attribute attributeInDao = attributeDao.get(attribute.getId());
			attributeInDao.getProducts().add(new Product(product));
			attributeDao.update(attributeInDao);
		}
		return product;
	}
	
	public Collection<Product> findByAttributes(Collection<Long> listAttributesId) {
		Collection<Product> listProducts = new ArrayList<>();
		for (Product product : getAll()) {
			if (product.getAttributes().stream().map(a-> a.getId()).collect(Collectors.toList()).containsAll(listAttributesId)) {
				listProducts.add(product);
			}
		}
		return listProducts;
	}
}
