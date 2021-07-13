package com.ak.ds.api.mappers;

import java.util.ArrayList;
import java.util.Collection;

import com.ak.ds.api.dto.StorageDto;
import com.ak.ds.entities.Storage;

public class StorageMapper {

	private StorageMapper() {
	}

	public static StorageDto entityToDto(Storage entity) {
		StorageDto dto = new StorageDto();
		dto.setId(entity.getId());
		dto.setStoreId(entity.getStore().getId());
		dto.setProductId(entity.getProduct().getId());
		dto.setPrice(entity.getPrice());
		dto.setQuantity(entity.getQuantity());
		return dto;
	}

	public static Storage dtoToEntity(StorageDto dto) {
		Storage entity = new Storage();
		entity.setId(dto.getId());
//		entity.setStore(StoreMapper.dtoToEntity(dto.getStore()));
//		entity.setProduct(ProductMapper.dtoToEntity(dto.getProduct()));
		entity.setPrice(dto.getPrice());
		entity.setQuantity(dto.getQuantity());
		return entity;
	}

	public static Collection<StorageDto> convertList(Collection<Storage> entities) {
		Collection<StorageDto> listDto = new ArrayList<>();
		for (Storage entity : entities) {
			StorageDto dto = entityToDto(entity);
			listDto.add(dto);
		}
		return listDto;
	}
	
	public static Collection<Storage> convertListDtoToEntity(Collection<StorageDto> listDto) {
		Collection<Storage> listEntity = new ArrayList<>();
		for (StorageDto dto : listDto) {
			Storage entity = dtoToEntity(dto);
			listEntity.add(entity);
		}
		return listEntity;
	}
}
