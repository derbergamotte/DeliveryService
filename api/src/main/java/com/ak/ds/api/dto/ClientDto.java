package com.ak.ds.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class ClientDto extends ADto{

	private String name;
	private String phone;
	private String adress;
}
