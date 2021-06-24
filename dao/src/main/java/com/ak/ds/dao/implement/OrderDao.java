package com.ak.ds.dao.implement;

import com.ak.ds.dao.interfaces.IOrderDao;
import com.ak.ds.entities.Order;

public class OrderDao extends AGenericDao<Order> implements IOrderDao{
	
	public OrderDao() {
		super(Order.class);
	}

}
