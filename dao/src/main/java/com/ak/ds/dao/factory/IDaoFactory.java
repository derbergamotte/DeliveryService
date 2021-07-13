package com.ak.ds.dao.factory;

import com.ak.ds.dao.interfaces.IAttributeDao;
import com.ak.ds.dao.interfaces.ICategoryDao;
import com.ak.ds.dao.interfaces.IClientDao;
import com.ak.ds.dao.interfaces.IOrderDao;
import com.ak.ds.dao.interfaces.IProductDao;
import com.ak.ds.dao.interfaces.IStorageDao;
import com.ak.ds.dao.interfaces.IStoreDao;

public interface IDaoFactory {

	IAttributeDao getAttributeDao();
	ICategoryDao getCategoryDao();
	IClientDao getClientDao();
	IOrderDao getOrderDao();
	IProductDao getProductDao();
	IStorageDao getStorageDao();
	IStoreDao getStoreDao();
}
