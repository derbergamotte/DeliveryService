package com.ak.ds.api.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class OrderDto extends ADto{
	
	private Long storageId;
	private StorageDto storage;
	private Long clientId;
	private ClientDto client;
	private Integer quantity;
}
