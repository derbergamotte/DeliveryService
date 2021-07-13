package com.ak.ds.services.factories;

import com.ak.ds.services.interfaces.IAttributeService;
import com.ak.ds.services.interfaces.ICategoryService;
import com.ak.ds.services.interfaces.IClientService;
import com.ak.ds.services.interfaces.IOrderService;
import com.ak.ds.services.interfaces.IProductService;
import com.ak.ds.services.interfaces.IStorageService;
import com.ak.ds.services.interfaces.IStoreService;

public interface IServiceFactory {

	IAttributeService getAttributeService();
	ICategoryService getCategoryService();
	IClientService getClientService();
	IOrderService getOrderService();
	IProductService getProductService();
	IStorageService getStorageService();
	IStoreService getStoreService();
}