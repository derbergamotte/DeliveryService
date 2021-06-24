package com.ak.ds.entities;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class Product extends AEntity{
	
	private String name;
	private List<Long> categoriesId;
	private List<Long> storagesId;
	private List<String> attributes;
	private String information;
}
