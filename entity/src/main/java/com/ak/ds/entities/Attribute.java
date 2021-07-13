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
public class Attribute extends AEntity{

	private String name;
	private Collection<Product> products;
	
	public Attribute(Attribute attribute) {
		this.id = attribute.id;
	}
}
