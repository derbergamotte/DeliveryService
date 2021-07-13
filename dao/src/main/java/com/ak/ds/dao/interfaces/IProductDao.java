package com.ak.ds.dao.interfaces;

import java.util.Collection;

import com.ak.ds.entities.Product;

public interface IProductDao extends IAGenericDao<Product>{

	Collection<Product> findByAttributes(Collection<Long> listAttributesId);
}
