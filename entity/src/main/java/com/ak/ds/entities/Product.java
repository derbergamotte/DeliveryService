package com.ak.ds.entities;

import java.util.List;

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
	private List<Long> categoriesId;
	private List<Long> storagesId;
	private List<String> attributes;
	private String information;
}
