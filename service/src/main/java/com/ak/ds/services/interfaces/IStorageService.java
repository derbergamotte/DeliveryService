package com.ak.ds.services.interfaces;

import java.util.List;

import com.ak.ds.api.dto.StorageDto;

public interface IStorageService {
	
	public void addStorage(StorageDto storageDto);
	public void addStorage(Long storeId, Long productId, Integer price, Integer quantity);
	public StorageDto getStorageById(Long id);
	public StorageDto getHeavyStorageById(Long id);
	public List<StorageDto> getAll();
	public void removeStorage(Long id);
	public void updateStorage(StorageDto storageDto);
	public List<StorageDto> sortProductByPriceInStores(Long productId);
}
