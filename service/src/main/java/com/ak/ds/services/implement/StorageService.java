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
import com.ak.ds.services.interfaces.IProductService;
import com.ak.ds.services.interfaces.IStorageService;
import com.ak.ds.services.interfaces.IStoreService;

public class StorageService implements IStorageService {

	private IStorageDao storageDao = new StorageDao();

	private IStoreService storeService = new StoreService();

	private IProductService productService = new ProductService();

	public void addStorage(StorageDto storageDto) {
		Storage storage = storageDao.add(StorageMapper.dtoToEntity(storageDto));
		productService.addProductInStorage(storage.getId(), storage.getProductId());
		storeService.addStorageInStore(storage.getId(), storage.getStoreId());
	}

	public void addStorage(Long storeId, Long productId, Integer price, Integer quantity) {
		Storage storage = new Storage();
		if (!(storeService.getStoreById(storeId).getId() == null && productService.getProductById(productId).getId() == null)) {
			storage.setStoreId(storeId);
			storage.setProductId(productId);
			storage.setPrice(price);
			storage.setQuantity(quantity);
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
