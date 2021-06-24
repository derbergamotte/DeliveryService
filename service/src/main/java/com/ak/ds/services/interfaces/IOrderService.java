package com.ak.ds.services.interfaces;

import java.util.List;

import com.ak.ds.api.dto.OrderDto;

public interface IOrderService {
	
	public void addOrder(OrderDto orderDto);
	public void addOrder(Long clientId, Long StoreId, Long productId, Integer quantity);
	public OrderDto getOrderById(Long id);
	public OrderDto getHeavyOrderById(Long id);
	public List<OrderDto> getAll();
}
