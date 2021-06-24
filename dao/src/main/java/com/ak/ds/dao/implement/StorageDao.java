package com.ak.ds.dao.implement;

import com.ak.ds.dao.interfaces.IStorageDao;
import com.ak.ds.entities.Storage;

public class StorageDao extends AGenericDao<Storage> implements IStorageDao{
	
	public StorageDao() {
		super(Storage.class);
	}
}
