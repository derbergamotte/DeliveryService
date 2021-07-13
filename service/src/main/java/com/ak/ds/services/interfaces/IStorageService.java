package com.ak.ds.services.interfaces;

import java.util.Collection;

import com.ak.ds.api.dto.StorageDto;
import com.ak.ds.entities.Storage;

public interface IStorageService {
	
	public void addStorage(StorageDto storageDto);
	public void addStorage(Long storeId, Long productId, Integer price, Integer quantity);
	public StorageDto getStorageById(Long id);
	public Storage getStorageEntityById(Long id);
	public Storage getStorageEntityByStoreAndProduct(Long storeId, Long productId); 
//	public StorageDto getHeavyStorageById(Long id);
	public Collection<StorageDto> getAll();
	public void removeStorage(Long id);
	public void updateStorage(StorageDto storageDto);
	public Collection<StorageDto> sortProductByPriceInStores(Long productId);
}
