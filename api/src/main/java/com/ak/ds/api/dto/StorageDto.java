package com.ak.ds.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class StorageDto extends ADto{
		
	private Long storeId;
	private Long productId;
	private Integer quantity;
	private Integer price;
}
