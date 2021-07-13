package com.ak.ds.services.interfaces;

import java.util.Collection;

import com.ak.ds.api.dto.StoreDto;
import com.ak.ds.entities.Store;

public interface IStoreService {

	public void addStore(StoreDto storeDto);
	public void addStore(String name, String adress, String phone);
	public StoreDto getStoreById(Long id);
	public Store getStoreEntityById(Long id);
	public Collection<StoreDto> getAll();
	public void removeStore(Long orderId);
	public void updateStore(StoreDto storeDto);
//	public void addStorageInStore(Long storageId, Long storeId);
}
