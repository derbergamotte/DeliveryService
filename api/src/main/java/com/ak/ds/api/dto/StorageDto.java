package com.ak.ds.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class StorageDto extends ADto{
	
	private Long storeId;
	private StoreDto store;
	private Long productId;
	private ProductDto product;
	private Integer quantity;
	private Integer price;
}
