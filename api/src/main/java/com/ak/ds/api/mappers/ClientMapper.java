package com.ak.ds.api.mappers;

import java.util.ArrayList;
import java.util.List;

import com.ak.ds.api.dto.ClientDto;
import com.ak.ds.entities.Client;

public class ClientMapper {

	private ClientMapper() {
	}

	public static ClientDto entityToDto(Client entity) {
		ClientDto dto = new ClientDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setPhone(entity.getPhone());
		dto.setAdress(entity.getAdress());
		return dto;
	}

	public static Client dtoToEntity(ClientDto dto) {
		Client entity = new Client();
		entity.setName(dto.getName());
		entity.setPhone(dto.getPhone());
		entity.setAdress(dto.getAdress());
		return entity;
	}

	public static List<ClientDto> convertList(List<Client> entities){
		List<ClientDto> listDto = new ArrayList<>();
		for(Client entity : entities) {
			ClientDto dto = entityToDto(entity);
			listDto.add(dto);
		}
		return listDto;
	}
}
