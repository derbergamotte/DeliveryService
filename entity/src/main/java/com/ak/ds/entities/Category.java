package com.ak.ds.entities;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class Category extends AEntity{
	
	private String name;
	private Collection<Product> products;
	
	public Category(Category category){
		this.id = category.id;
	}
}
