package com.ak.ds.dao.implement;

import javax.transaction.Transactional;

import com.ak.ds.dao.factory.DaoFactory;
import com.ak.ds.dao.factory.IDaoFactory;
import com.ak.ds.dao.interfaces.IProductDao;
import com.ak.ds.dao.interfaces.IStorageDao;
import com.ak.ds.dao.interfaces.IStoreDao;
import com.ak.ds.entities.Product;
import com.ak.ds.entities.Storage;
import com.ak.ds.entities.Store;

public class StorageDao extends AGenericDao<Storage> implements IStorageDao {

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

	IDaoFactory daoFactory = new DaoFactory();
	IStoreDao storeDao = daoFactory.getStoreDao();
	IProductDao productDao = daoFactory.getProductDao();

	@Override
	@Transactional
	public Storage add(Storage storage) {
		storage.setProduct(new Product(storage.getProduct()));
		storage.setStore(new Store(storage.getStore()));
		super.add(storage);
		try {
			Store store = storeDao.get(storage.getStore().getId());
			store.getStorages().add(new Storage(storage));
			storeDao.update(store);
		} catch (NullPointerException e) {
			System.out.println("You try to put product in non-existent store");
		}
		try {
			Product product = productDao.get(storage.getProduct().getId());
			product.getStorages().add(new Storage(storage));
			productDao.update(product);
		} catch (NullPointerException e) {
			System.out.println("You try to put non-existent product in store");
		}
		return storage;
	}
}
