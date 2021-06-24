package com.ak.ds.api.mappers;

import java.util.ArrayList;
import java.util.List;

import com.ak.ds.api.dto.StorageDto;
import com.ak.ds.entities.Storage;

public class StorageMapper {
	
	private StorageMapper() {}
	
	public static StorageDto entityToDto(Storage entity) {
		StorageDto dto = new StorageDto();
		dto.setId(entity.getId());
		dto.setStoreId(entity.getStoreId());
		dto.setProductId(entity.getProductId());
		dto.setPrice(entity.getPrice());
		dto.setQuantity(entity.getQuantity());
		return dto;
	}
	
	public static Storage dtoToEntity(StorageDto dto) {
		Storage entity = new Storage();
		entity.setId(dto.getId());
		entity.setStoreId(dto.getStoreId());
		entity.setProductId(dto.getProductId());
		entity.setPrice(dto.getPrice());
		entity.setQuantity(dto.getQuantity());
		return entity;
	}
	
	public static List<StorageDto> convertList(List<Storage> entities){
		List<StorageDto> listDto = new ArrayList<>();
		for(Storage entity : entities) {
			StorageDto dto = entityToDto(entity);
			listDto.add(dto);
		}
		return listDto;
	}
}
