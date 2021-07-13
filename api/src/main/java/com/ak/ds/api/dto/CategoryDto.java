package com.ak.ds.api.dto;

import java.util.Collection;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class CategoryDto extends ADto {
	
	private String name;
	private Collection<Long> productsId;
}
