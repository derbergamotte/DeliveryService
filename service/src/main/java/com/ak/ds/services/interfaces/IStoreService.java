package com.ak.ds.services.interfaces;

import java.util.List;

import com.ak.ds.api.dto.StoreDto;

public interface IStoreService {

	public void addStore(StoreDto storeDto);
	public void addStore(String name, String adress, String phone);
	public StoreDto getStoreById(Long id);
	public List<StoreDto> getAll();
	public void removeStore(Long orderId);
	public void updateStore(StoreDto storeDto);
	public void addStorageInStore(Long storageId, Long storeId);
}
