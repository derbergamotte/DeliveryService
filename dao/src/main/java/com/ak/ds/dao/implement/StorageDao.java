package com.ak.ds.dao.implement;

import com.ak.ds.dao.interfaces.IStorageDao;
import com.ak.ds.entities.Storage;

public class StorageDao extends AGenericDao<Storage> implements IStorageDao{
	
	private StorageDao() {
		super(Storage.class);
	}
	
	private static StorageDao storageDao;
	
	public static StorageDao getStorageDao() {
		if (storageDao == null) {
			storageDao = new StorageDao();
		}
		return storageDao;
	}
}
