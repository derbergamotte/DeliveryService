package com.ak.ds.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class Storage extends AEntity{
	
	private Long storeId;
	private Long productId;
	private Integer quantity;
	private Integer price;
}
