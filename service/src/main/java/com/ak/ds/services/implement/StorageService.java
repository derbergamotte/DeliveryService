package com.ak.ds.services.implement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ak.ds.api.dto.StorageDto;
import com.ak.ds.api.mappers.StorageMapper;
import com.ak.ds.dao.factory.DaoFactory;
import com.ak.ds.dao.factory.IDaoFactory;
import com.ak.ds.dao.interfaces.IStorageDao;
import com.ak.ds.entities.Order;
import com.ak.ds.entities.Product;
import com.ak.ds.entities.Storage;
import com.ak.ds.entities.Store;
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

	private IDaoFactory daoFactory = new DaoFactory();
	private IStorageDao storageDao = daoFactory.getStorageDao();
	private IServiceFactory serviceFactory = new ServiceFactory();
	private IStoreService storeService = serviceFactory.getStoreService();
	private IProductService productService = serviceFactory.getProductService();

	public void addStorage(StorageDto storageDto) {
		if (!(storeService.getStoreById(storageDto.getStoreId()) == null
				&& productService.getProductById(storageDto.getProductId()) == null)) {
			Storage storage = storageDao.add(StorageMapper.dtoToEntity(storageDto));
			storage = storageDao.add(storage);
		}
	}

	public void addStorage(Long storeId, Long productId, Integer price, Integer quantity) {
		if (!(storeService.getStoreById(storeId).getId() == null
				&& productService.getProductById(productId).getId() == null)) {
			Store store = storeService.getStoreEntityById(storeId);
			Product product = productService.getProductEntityById(productId);
			Storage storage = new Storage(store, product, quantity, price, new ArrayList<Order>());
			storage = storageDao.add(storage);
		}
	}

	public StorageDto getStorageById(Long id) {
		return StorageMapper.entityToDto(getStorageEntityById(id));
	}

	public Storage getStorageEntityByStoreAndProduct(Long storeId, Long productId) {
		StorageDto storage = new StorageDto();
		for(StorageDto itterator : getAll()) {
			if(itterator.getStoreId().equals(storeId) && itterator.getProductId().equals(productId)) {
				storage = itterator;
			}
		}
		return StorageMapper.dtoToEntity(storage);
	}
	
	public Storage getStorageEntityById(Long id) {
		return Optional.ofNullable(Optional.ofNullable(this.storageDao.get(id)).orElse(new Storage())).get();
	}

	public Collection<StorageDto> getAll() {
		return StorageMapper.convertList(storageDao.getAll());
	}

	public void removeStorage(Long id) {
		storageDao.remove(id);
	}

	public void updateStorage(StorageDto storageDto) {
		if (!(storageDto.getId() == null)) {
			Storage storage = getStorageEntityById(storageDto.getId());
			if (!(storageDto.getQuantity() == null)) {
				storage.setQuantity(storageDto.getQuantity());
			}
			if (!(storageDto.getPrice() == null)) {
				storage.setPrice(storageDto.getPrice());
			}
			storageDao.update(storage);
		}
	}

	public Collection<StorageDto> sortProductByPriceInStores(Long productId) {
		List<StorageDto> listStorages = new ArrayList<>();
		Collection<Long> storagesId = productService.getProductById(productId).getStoragesId();
		try {
			for (StorageDto storage : storagesId.stream().map(s-> getStorageById(s)).collect(Collectors.toSet())) {
				listStorages.add(getStorageById(storage.getId()));
			}
			listStorages.sort(Comparator.comparing(StorageDto::getPrice));
		} catch (NullPointerException e) {
			System.out.println("There isn't that storage");
		}
		return listStorages;
	}
}
