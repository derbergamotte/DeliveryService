package com.ak.ds.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class Order extends AEntity{
	
	private Storage storage;
	private Client client;
	private Integer quantity;
	
	public Order(Order order) {
		this.id = order.id;
	}
}
