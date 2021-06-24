package com.ak.ds.api.dto;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class ProductDto extends ADto{
	
	private String name;
	private List<Long> categoriesId;
	private List<Long> storagesId;
	private List<StorageDto> storages;
	private List<String> attributes;
	private String information;
}
