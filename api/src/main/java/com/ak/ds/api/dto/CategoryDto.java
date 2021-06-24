package com.ak.ds.api.dto;

import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class CategoryDto extends ADto {
	
	private String name;
	private Set<Long> productsId;
	private Set<ProductDto> products;
}
