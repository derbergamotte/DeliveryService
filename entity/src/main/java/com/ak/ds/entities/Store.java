package com.ak.ds.entities;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class Store extends AEntity{

	private String name;
	private String phone;
	private String adress;
	private List<Long> storagesId;
}
