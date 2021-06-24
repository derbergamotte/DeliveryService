package com.ak.ds.dao.implement;

import com.ak.ds.dao.interfaces.IStoreDao;
import com.ak.ds.entities.Store;

public class StoreDao extends AGenericDao<Store> implements IStoreDao{
	
	public StoreDao() {
		super(Store.class);
	}
}
