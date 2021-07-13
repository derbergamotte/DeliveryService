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
public class Product extends AEntity{
	
	private String name;
	private Collection<Category> categories;
	private Collection<Storage> storages;
	private Collection<Attribute> attributes;
	private String information;
	
	public Product(Product product) {
		this.id = product.id;
	}
}
