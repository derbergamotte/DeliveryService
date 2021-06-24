package com.ak.ds.services.implement;

import java.util.List;
import java.util.Optional;

import com.ak.ds.api.dto.OrderDto;
import com.ak.ds.api.mappers.OrderMapper;
import com.ak.ds.dao.implement.OrderDao;
import com.ak.ds.dao.interfaces.IOrderDao;
import com.ak.ds.entities.Order;
import com.ak.ds.services.interfaces.IClientService;
import com.ak.ds.services.interfaces.IOrderService;
import com.ak.ds.services.interfaces.IProductService;
import com.ak.ds.services.interfaces.IStoreService;

public class OrderService implements IOrderService{

	private IOrderDao orderDao = new OrderDao();
	
	private IStoreService storeService = new StoreService();
	
	private IClientService clientService = new ClientService();
	
	private IProductService productService = new ProductService();
	
	public void addOrder(OrderDto orderDto) {
		orderDao.add(OrderMapper.dtoToEntity(orderDto));
	}
	
	public void addOrder(Long clientId, Long StoreId, Long productId, Integer quantity) {
		Order order = new Order();
		order.setClientId(clientId);
		order.setStoreId(StoreId);
		order.setProductId(productId);
		order.setQuantity(quantity);
		orderDao.add(order);
	}
	
	public OrderDto getOrderById(Long id) {
		return OrderMapper.entityToDto(getOrderEntity(id));
	}
	
	private Order getOrderEntity(Long id) {
		return Optional.ofNullable(Optional.ofNullable(this.orderDao.get(id)).orElse(new Order())).get();
	}
	
	public OrderDto getHeavyOrderById(Long id) {
		OrderDto orderDto = getOrderById(id);
		orderDto.setClient(clientService.getClientById(orderDto.getClientId()));
		orderDto.setProduct(productService.getProductById(orderDto.getProductId()));
		orderDto.setStore(storeService.getStoreById(orderDto.getStoreId()));
		return orderDto;
	}
	
	public List<OrderDto> getAll(){
		return OrderMapper.convertList(orderDao.getAll());
	}
}