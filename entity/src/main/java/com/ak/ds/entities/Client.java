package com.ak.ds.entities;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class Client extends AEntity{
	
	private String name;
	private String phone;
	private String adress;
	private Collection<Order> orders;
	
	public Client(Client client) {
		this.id = client.id;
	}
}
