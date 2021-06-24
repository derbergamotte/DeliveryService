package com.ak.ds.entities;

import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class Category extends AEntity{
	
	private String name;
	private Set<Long> productsId;
}
