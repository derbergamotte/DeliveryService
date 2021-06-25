package com.ak.ds.services.factories;

import com.ak.ds.services.implement.CategoryService;
import com.ak.ds.services.implement.ClientService;
import com.ak.ds.services.implement.OrderService;
import com.ak.ds.services.implement.ProductService;
import com.ak.ds.services.implement.StorageService;
import com.ak.ds.services.implement.StoreService;

public class ServiceFactory implements IServiceFactory {
	
	@Override
	public CategoryService getCategoryService() {
		return CategoryService.getCategoryService();
	}

	@Override
	public ClientService getClientService() {
		return ClientService.getClientService();
	}
	
	@Override
	public OrderService getOrderService() {
		return OrderService.getOrderService();
	}
	
	@Override
	public ProductService getProductService() {
		return ProductService.getProductService();
	}
	
	@Override
	public StorageService getStorageService() {
		return StorageService.getStorageService();
	}
	
	@Override
	public StoreService getStoreService() {
		return StoreService.getStoreService();
	}
}
