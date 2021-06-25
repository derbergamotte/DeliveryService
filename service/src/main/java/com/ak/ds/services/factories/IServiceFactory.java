package com.ak.ds.services.factories;

import com.ak.ds.services.implement.CategoryService;
import com.ak.ds.services.implement.ClientService;
import com.ak.ds.services.implement.OrderService;
import com.ak.ds.services.implement.ProductService;
import com.ak.ds.services.implement.StorageService;
import com.ak.ds.services.implement.StoreService;

public interface IServiceFactory {

	CategoryService getCategoryService();

	ClientService getClientService();

	OrderService getOrderService();

	ProductService getProductService();

	StorageService getStorageService();

	StoreService getStoreService();

}