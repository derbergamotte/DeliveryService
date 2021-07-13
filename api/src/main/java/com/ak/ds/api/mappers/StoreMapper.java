package com.ak.ds.api.mappers;

import java.util.ArrayList;
import java.util.Collection;

import com.ak.ds.api.dto.StoreDto;
import com.ak.ds.entities.Store;

public class StoreMapper {
	
	private StoreMapper() {}
	
	public static StoreDto entityToDto(Store entity) {
		StoreDto dto = new StoreDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setAdress(entity.getAdress());
		dto.setPhone(entity.getPhone());
//		dto.setStorages(StorageMapper.convertList(entity.getStorages()));
		return dto;
	}

	public static Store dtoToEntity(StoreDto dto) {
		Store entity = new Store();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setAdress(dto.getAdress());
		entity.setPhone(dto.getPhone());
//		entity.setStorages(StorageMapper.convertListDtoToEntity(dto.getStorages()));
		return entity;
	}
	
	public static Collection<StoreDto> convertList(Collection<Store> entities){
		Collection<StoreDto> listDto = new ArrayList<>();
		for(Store entity : entities) {
			StoreDto dto = entityToDto(entity);
			listDto.add(dto);
		}
		return listDto;
	}
}
