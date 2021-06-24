package com.ak.ds.api.mappers;

import java.util.ArrayList;
import java.util.List;

import com.ak.ds.api.dto.OrderDto;
import com.ak.ds.entities.Order;

public class OrderMapper {

	private OrderMapper() {
	}
	
	public static OrderDto entityToDto(Order entity) {
		OrderDto dto = new OrderDto();
		dto.setId(entity.getId());
		dto.setClientId(entity.getClientId());
		dto.setStoreId(entity.getStoreId());
		dto.setProductId(entity.getProductId());
		dto.setQuantity(entity.getQuantity());
		return dto;
	}
	
	public static Order dtoToEntity(OrderDto dto) {
		Order entity = new Order();
		entity.setId(dto.getId());
		entity.setClientId(dto.getClientId());
		entity.setStoreId(dto.getStoreId());
		entity.setProductId(dto.getProductId());
		entity.setQuantity(dto.getQuantity());
		return entity;
	}
	
	public static List<OrderDto> convertList(List<Order> entities){
		List<OrderDto> listDto = new ArrayList<>();
		for(Order entity : entities) {
			OrderDto dto = entityToDto(entity);
			listDto.add(dto);
		}
		return listDto;
	}
}
