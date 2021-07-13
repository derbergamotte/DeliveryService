package com.ak.ds.api.mappers;

import java.util.ArrayList;
import java.util.Collection;

import com.ak.ds.api.dto.AttributeDto;
import com.ak.ds.entities.Attribute;

public class AttributeMapper {
	private AttributeMapper() {}
	
	public static AttributeDto entityToDto(Attribute entity) {
		AttributeDto dto = new AttributeDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		return dto;
	}
	
	public static Attribute dtoToEntity(AttributeDto dto) {
		Attribute entity = new Attribute();
		entity.setName(dto.getName());
		return entity;
	}
	
	public static Collection<AttributeDto> convertList(Collection<Attribute> entities){
		Collection<AttributeDto> listDto = new ArrayList<>();
		for(Attribute entity : entities) {
			AttributeDto dto = entityToDto(entity);
			listDto.add(dto);
		}
		return listDto;
	}
}
