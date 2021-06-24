package com.ak.ds.dao.interfaces;

import java.util.List;

import com.ak.ds.entities.Product;

public interface IProductDao extends IAGenericDao<Product>{

	public List<Product> findByAttributes(List<String> listAttributes);
	public List<Product> findByAttributes(String attribute);
}
