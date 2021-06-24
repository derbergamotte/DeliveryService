package com.ak.ds.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class Client extends AEntity{
	
	private String name;
	private String phone;
	private String adress;
}
