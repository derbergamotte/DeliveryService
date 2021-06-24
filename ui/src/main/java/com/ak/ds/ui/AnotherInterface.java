package com.ak.ds.ui;

import com.ak.ds.services.implement.CategoryService;
import com.ak.ds.services.interfaces.ICategoryService;

public class AnotherInterface implements IAnotherInterface{
	
	private ICategoryService categoryService = new CategoryService();
	
	public void addCategory(String categoryName) {
		categoryService.addCategory(categoryName);
	}
}
