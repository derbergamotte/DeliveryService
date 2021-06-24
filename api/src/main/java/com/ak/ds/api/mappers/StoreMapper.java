package com.ak.ds.api.mappers;

import java.util.ArrayList;
import java.util.List;

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
		dto.setStoragesId(entity.getStoragesId());
		return dto;
	}

	public static Store dtoToEntity(StoreDto dto) {
		Store entity = new Store();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setAdress(dto.getAdress());
		entity.setPhone(dto.getPhone());
		entity.setStoragesId(dto.getStoragesId());
		return entity;
	}
	
	public static List<StoreDto> convertList(List<Store> entities){
		List<StoreDto> listDto = new ArrayList<>();
		for(Store entity : entities) {
			StoreDto dto = entityToDto(entity);
			listDto.add(dto);
		}
		return listDto;
	}
}
