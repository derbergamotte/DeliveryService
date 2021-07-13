package com.ak.ds.dao.implement;

import javax.transaction.Transactional;

import com.ak.ds.dao.factory.DaoFactory;
import com.ak.ds.dao.factory.IDaoFactory;
import com.ak.ds.dao.interfaces.IClientDao;
import com.ak.ds.dao.interfaces.IOrderDao;
import com.ak.ds.dao.interfaces.IStorageDao;
import com.ak.ds.entities.Client;
import com.ak.ds.entities.Order;
import com.ak.ds.entities.Storage;

public class OrderDao extends AGenericDao<Order> implements IOrderDao{
	
	private OrderDao() {
		super(Order.class);
	}

	private static OrderDao orderDao;

	public static OrderDao getOrderDao() {
		if (orderDao == null) {
			orderDao = new OrderDao();
		}
		return orderDao;
	}
	
	IDaoFactory daoFactory = new DaoFactory();
	IClientDao clientDao = daoFactory.getClientDao();
	IStorageDao storageDao = daoFactory.getStorageDao();
	
	@Override
	@Transactional
	public Order add(Order order) {
		order.setClient(new Client(order.getClient()));
		order.setStorage(new Storage(order.getStorage()));
		super.add(order);
		try {
			Client client = clientDao.get(order.getClient().getId());
			client.getOrders().add(new Order(order));
			clientDao.update(client);
		} catch (NullPointerException e) {
			System.out.println("There isn't that client");
		}
		try {
			Storage storage = storageDao.get(order.getStorage().getId());
			storage.getOrders().add(new Order(order));
			storageDao.update(storage);
		} catch (NullPointerException e) {
			System.out.println("There isn't that storage");
		}
		return order;
	}
}
