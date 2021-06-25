package com.ak.ds.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class Storage extends AEntity{
	
	private Long storeId;
	private Long productId;
	private Integer quantity;
	private Integer price;
}
