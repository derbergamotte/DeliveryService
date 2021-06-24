package com.ak.ds.dao.implement;

import com.ak.ds.dao.interfaces.ICategoryDao;
import com.ak.ds.entities.Category;

public class CategoryDao extends AGenericDao<Category> implements ICategoryDao{

	public CategoryDao() {
		super(Category.class);
	}
}
