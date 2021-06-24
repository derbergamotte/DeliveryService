package com.ak.ds.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class Order extends AEntity{
	
	private Long storeId;
	private Long clientId;
	private Long productId;
	private Integer quantity;
}
