package com.ak.ds.dao.implement;

import com.ak.ds.dao.interfaces.IOrderDao;
import com.ak.ds.entities.Order;

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
}
