package com.ak.ds.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class Store extends AEntity{

	private String name;
	private String phone;
	private String adress;
	private List<Long> storagesId;
}
