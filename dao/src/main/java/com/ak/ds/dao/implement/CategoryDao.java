package com.ak.ds.dao.implement;

import com.ak.ds.dao.interfaces.ICategoryDao;
import com.ak.ds.entities.Category;

public class CategoryDao extends AGenericDao<Category> implements ICategoryDao{

	private CategoryDao() {
		super(Category.class);
	}
	
	private static CategoryDao categoryDao;
	
	public static ICategoryDao getCategoryDao() {
		if (categoryDao == null) {
			categoryDao = new CategoryDao();
		}
		return categoryDao;
	}
}
