package com.ak.ds.services.implement;

import java.util.Collection;
import java.util.Optional;

import com.ak.ds.api.dto.OrderDto;
import com.ak.ds.api.mappers.OrderMapper;
import com.ak.ds.dao.factory.DaoFactory;
import com.ak.ds.dao.factory.IDaoFactory;
import com.ak.ds.dao.interfaces.IOrderDao;
import com.ak.ds.entities.Client;
import com.ak.ds.entities.Order;
import com.ak.ds.entities.Storage;
import com.ak.ds.services.factories.IServiceFactory;
import com.ak.ds.services.factories.ServiceFactory;
import com.ak.ds.services.interfaces.IClientService;
import com.ak.ds.services.interfaces.IOrderService;
import com.ak.ds.services.interfaces.IStorageService;

public class OrderService implements IOrderService {

	private OrderService() {
	}

	private static OrderService orderService;

	public static OrderService getOrderService() {
		if (orderService == null) {
			orderService = new OrderService();
		}
		return orderService;
	}

	private IDaoFactory daoFactory = new DaoFactory();
	private IOrderDao orderDao = daoFactory.getOrderDao();
	private IServiceFactory serviceFactory = new ServiceFactory();
	private IStorageService storageService = serviceFactory.getStorageService();
	private IClientService clientService = serviceFactory.getClientService();

	public void addOrder(OrderDto orderDto) {
		orderDao.add(OrderMapper.dtoToEntity(orderDto));
	}

	public void addOrder(Long clientId, Long storeId, Long productId, Integer quantity) {
		try {
			Storage storage = storageService.getStorageEntityByStoreAndProduct(storeId, productId);
			Client client = clientService.getClientEntityById(clientId);
			orderDao.add(new Order(storage, client, quantity));
		} catch (NullPointerException e) {
			System.out.println("I don find this store or product. I'm sorry");
		}
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
		orderDto.setStorage(storageService.getStorageById(orderDto.getStorageId()));
		return orderDto;
	}

	public Collection<OrderDto> getAll() {
		return OrderMapper.convertList(orderDao.getAll());
	}
}