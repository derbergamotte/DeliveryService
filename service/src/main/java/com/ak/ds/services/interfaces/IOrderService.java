package com.ak.ds.services.interfaces;

import java.util.Collection;

import com.ak.ds.api.dto.OrderDto;

public interface IOrderService {
	
	public void addOrder(OrderDto orderDto);
	public void addOrder(Long clientId, Long storeId, Long productId, Integer quantity);
	public OrderDto getOrderById(Long id);
	public OrderDto getHeavyOrderById(Long id);
	public Collection<OrderDto> getAll();
}
