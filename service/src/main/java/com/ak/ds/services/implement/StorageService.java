package com.ak.ds.services.implement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.ak.ds.api.dto.StorageDto;
import com.ak.ds.api.mappers.StorageMapper;
import com.ak.ds.dao.implement.StorageDao;
import com.ak.ds.dao.interfaces.IStorageDao;
import com.ak.ds.entities.Storage;
import com.ak.ds.services.factories.IServiceFactory;
import com.ak.ds.services.factories.ServiceFactory;
import com.ak.ds.services.interfaces.IProductService;
import com.ak.ds.services.interfaces.IStorageService;
import com.ak.ds.services.interfaces.IStoreService;

public class StorageService implements IStorageService {
	
	private StorageService() {
	}
	
	private static StorageService storageService;
	
	public static StorageService getStorageService() {
		if (storageService == null) {
			storageService = new StorageService();
		}
		return storageService;
	}

	private IStorageDao storageDao = StorageDao.getStorageDao();

	private IServiceFactory serviceFactory = new ServiceFactory();

	private IStoreService storeService = serviceFactory.getStoreService();

	private IProductService productService = serviceFactory.getProductService();

	public void addStorage(StorageDto storageDto) {
		if (!(storeService.getStoreById(storageDto.getStoreId()).getId() == null
				&& productService.getProductById(storageDto.getProductId()).getId() == null)) {
			Storage storage = storageDao.add(StorageMapper.dtoToEntity(storageDto));
			productService.addProductInStorage(storage.getId(), storage.getProductId());
			storeService.addStorageInStore(storage.getId(), storage.getStoreId());
		}
	}

	public void addStorage(Long storeId, Long productId, Integer price, Integer quantity) {
		if (!(storeService.getStoreById(storeId).getId() == null
				&& productService.getProductById(productId).getId() == null)) {
			Storage storage = new Storage(storeId, productId, quantity, price);
			storage = storageDao.add(storage);
			productService.addProductInStorage(storage.getId(), storage.getProductId());
			storeService.addStorageInStore(storage.getId(), storage.getStoreId());
		}
	}

	public StorageDto getStorageById(Long id) {
		return StorageMapper.entityToDto(getStorageEntity(id));
	}

	private Storage getStorageEntity(Long id) {
		return Optional.ofNullable(Optional.ofNullable(this.storageDao.get(id)).orElse(new Storage())).get();
	}

	public StorageDto getHeavyStorageById(Long id) {
		StorageDto storageDto = getStorageById(id);
		storageDto.setStore(storeService.getStoreById(storageDto.getStoreId()));
		storageDto.setProduct(productService.getProductById(storageDto.getProductId()));
		return storageDto;
	}

	public List<StorageDto> getAll() {
		return StorageMapper.convertList(storageDao.getAll());
	}

	public void removeStorage(Long id) {
		storageDao.remove(id);
	}

	public void updateStorage(StorageDto storageDto) {
		if (!(storageDto.getId() == null)) {
			Storage storage = getStorageEntity(storageDto.getId());
			if (!(storageDto.getQuantity() == null)) {
				storage.setQuantity(storageDto.getQuantity());
			}
			if (!(storageDto.getPrice() == null)) {
				storage.setPrice(storageDto.getPrice());
			}
			storageDao.update(storage);
		}
	}

	public List<StorageDto> sortProductByPriceInStores(Long productId) {
		List<StorageDto> listStorages = new ArrayList<>();
		try {
			for (Long storageId : productService.getProductById(productId).getStoragesId()) {
				listStorages.add(getHeavyStorageById(storageId));
			}
			listStorages.sort(Comparator.comparing(StorageDto::getPrice));
		} catch (NullPointerException e) {
			System.out.println("There isn't that storage");
		}
		return listStorages;
	}
}
