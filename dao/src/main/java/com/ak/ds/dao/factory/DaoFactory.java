package com.ak.ds.dao.factory;

import com.ak.ds.dao.implement.AttributeDao;
import com.ak.ds.dao.implement.CategoryDao;
import com.ak.ds.dao.implement.ClientDao;
import com.ak.ds.dao.implement.OrderDao;
import com.ak.ds.dao.implement.ProductDao;
import com.ak.ds.dao.implement.StorageDao;
import com.ak.ds.dao.implement.StoreDao;
import com.ak.ds.dao.interfaces.IAttributeDao;
import com.ak.ds.dao.interfaces.ICategoryDao;
import com.ak.ds.dao.interfaces.IClientDao;
import com.ak.ds.dao.interfaces.IOrderDao;
import com.ak.ds.dao.interfaces.IProductDao;
import com.ak.ds.dao.interfaces.IStorageDao;
import com.ak.ds.dao.interfaces.IStoreDao;

public class DaoFactory implements IDaoFactory{

	public IAttributeDao getAttributeDao() {
		return AttributeDao.getAttributeDao();
	}
	
	public ICategoryDao getCategoryDao() {
		return CategoryDao.getCategoryDao();
	}
	
	public IClientDao getClientDao() {
		return ClientDao.getClientDao();
	}
	
	public IOrderDao getOrderDao() {
		return OrderDao.getOrderDao();
	}
	
	public IProductDao getProductDao() {
		return ProductDao.getProductDao();
	}
	
	public IStorageDao getStorageDao() {
		return StorageDao.getStorageDao();
	}
	
	public IStoreDao getStoreDao() {
		return StoreDao.getStoreDao();
	}
}
