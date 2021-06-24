package com.ak.ds.api.dto;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
public class StoreDto extends ADto{
	
	private String name;
	private String phone;
	private String adress;
	private List<Long> storagesId;
	private List<StorageDto> storages;
}
