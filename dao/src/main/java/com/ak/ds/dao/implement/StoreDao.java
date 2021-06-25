package com.ak.ds.dao.implement;

import com.ak.ds.dao.interfaces.IStoreDao;
import com.ak.ds.entities.Store;

public class StoreDao extends AGenericDao<Store> implements IStoreDao{
	
	private StoreDao() {
		super(Store.class);
	}
	
	private static StoreDao storeDao;
	
	public static StoreDao getStoreDao() {
		if (storeDao == null) {
			storeDao = new StoreDao();
		}
		return storeDao;
	}
}
