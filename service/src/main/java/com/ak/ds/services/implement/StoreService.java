package com.ak.ds.services.implement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import com.ak.ds.api.dto.StoreDto;
import com.ak.ds.api.mappers.StoreMapper;
import com.ak.ds.dao.factory.DaoFactory;
import com.ak.ds.dao.factory.IDaoFactory;
import com.ak.ds.dao.interfaces.IStoreDao;
import com.ak.ds.entities.Storage;
import com.ak.ds.entities.Store;
import com.ak.ds.services.interfaces.IStoreService;

public class StoreService implements IStoreService {
	
	private StoreService() {
	}
	
	private static StoreService storeService;
	
	public static StoreService getStoreService() {
		if (storeService == null) {
			storeService = new StoreService();
		}
		return storeService;
	}

	private IDaoFactory daoFactory = new DaoFactory();
	private IStoreDao storeDao = daoFactory.getStoreDao();

	public void addStore(StoreDto storeDto) {
		Store store = StoreMapper.dtoToEntity(storeDto);
		store.setStorages(new ArrayList<Storage>());
		storeDao.add(store);
	}

	public void addStore(String name, String adress, String phone) {
		storeDao.add(new Store(name, phone, adress, new HashSet<Storage>()));
	}

	public StoreDto getStoreById(Long id) {
		return StoreMapper.entityToDto(getStoreEntityById(id));
	}

	public Store getStoreEntityById(Long id) {
		return Optional.ofNullable(Optional.ofNullable(this.storeDao.get(id)).orElse(new Store())).get();
	}

	public Collection<StoreDto> getAll() {
		return StoreMapper.convertList(storeDao.getAll());
	}

	public void removeStore(Long orderId) {
		storeDao.remove(orderId);
	}

	public void updateStore(StoreDto storeDto) {
		if (!(storeDto.getId() == null)) {
			Store store = getStoreEntityById(storeDto.getId());
			if (StringUtils.isNotEmpty(storeDto.getName())) {
				store.setName(storeDto.getName());
			}
			if (StringUtils.isNotEmpty(storeDto.getAdress())) {
				store.setAdress(storeDto.getAdress());
			}
			if (StringUtils.isNotEmpty(storeDto.getPhone())) {
				store.setPhone(storeDto.getPhone());
			}
			storeDao.update(store);
		}
	}

//	public void addStorageInStore(Long storageId, Long storeId) {
//		try {
//			Store store = storeDao.get(storeId);
//			store.getStoragesId().add(storageId);
//			storeDao.update(store);
//		} catch (NullPointerException e) {
//			System.out.println("There isn't that store");
//		}
//	}
}
