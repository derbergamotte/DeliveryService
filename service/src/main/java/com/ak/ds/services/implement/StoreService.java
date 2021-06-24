package com.ak.ds.services.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import com.ak.ds.api.dto.StoreDto;
import com.ak.ds.api.mappers.StoreMapper;
import com.ak.ds.dao.implement.StoreDao;
import com.ak.ds.dao.interfaces.IStoreDao;
import com.ak.ds.entities.Store;
import com.ak.ds.services.interfaces.IStoreService;

public class StoreService implements IStoreService {

	private IStoreDao storeDao = new StoreDao();

	public void addStore(StoreDto storeDto) {
		Store store = StoreMapper.dtoToEntity(storeDto);
		store.setStoragesId(new ArrayList<Long>());
		storeDao.add(store);
	}

	public void addStore(String name, String adress, String phone) {
		Store store = new Store();
		store.setName(name);
		store.setAdress(adress);
		store.setPhone(phone);
		store.setStoragesId(new ArrayList<Long>());
		storeDao.add(store);
	}

	public StoreDto getStoreById(Long id) {
		return StoreMapper.entityToDto(getStoreEntity(id));
	}

	private Store getStoreEntity(Long id) {
		return Optional.ofNullable(Optional.ofNullable(this.storeDao.get(id)).orElse(new Store())).get();
	}

	public List<StoreDto> getAll() {
		return StoreMapper.convertList(storeDao.getAll());
	}

	public void removeStore(Long orderId) {
		storeDao.remove(orderId);
	}

	public void updateStore(StoreDto storeDto) {
		if (!(storeDto.getId() == null)) {
			Store store = getStoreEntity(storeDto.getId());
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

	public void addStorageInStore(Long storageId, Long storeId) {
		Store store = storeDao.get(storeId);
		store.getStoragesId().add(storageId);
		storeDao.update(store);
	}
}
