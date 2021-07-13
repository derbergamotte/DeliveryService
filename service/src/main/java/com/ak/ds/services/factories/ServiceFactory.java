package com.ak.ds.services.factories;

import com.ak.ds.services.implement.AttributeService;
import com.ak.ds.services.implement.CategoryService;
import com.ak.ds.services.implement.ClientService;
import com.ak.ds.services.implement.OrderService;
import com.ak.ds.services.implement.ProductService;
import com.ak.ds.services.implement.StorageService;
import com.ak.ds.services.implement.StoreService;
import com.ak.ds.services.interfaces.IAttributeService;
import com.ak.ds.services.interfaces.ICategoryService;
import com.ak.ds.services.interfaces.IClientService;
import com.ak.ds.services.interfaces.IOrderService;
import com.ak.ds.services.interfaces.IProductService;
import com.ak.ds.services.interfaces.IStorageService;
import com.ak.ds.services.interfaces.IStoreService;

public class ServiceFactory implements IServiceFactory {
	
	@Override
	public IAttributeService getAttributeService() {
		return AttributeService.getAttributeService();
	}
	
	@Override
	public ICategoryService getCategoryService() {
		return CategoryService.getCategoryService();
	}

	@Override
	public IClientService getClientService() {
		return ClientService.getClientService();
	}
	
	@Override
	public IOrderService getOrderService() {
		return OrderService.getOrderService();
	}
	
	@Override
	public IProductService getProductService() {
		return ProductService.getProductService();
	}
	
	@Override
	public IStorageService getStorageService() {
		return StorageService.getStorageService();
	}
	
	@Override
	public IStoreService getStoreService() {
		return StoreService.getStoreService();
	}
}
