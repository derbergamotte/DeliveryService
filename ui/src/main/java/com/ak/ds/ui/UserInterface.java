package com.ak.ds.ui;

import java.util.List;

import com.ak.ds.api.dto.CategoryDto;
import com.ak.ds.api.dto.ClientDto;
import com.ak.ds.api.dto.OrderDto;
import com.ak.ds.api.dto.ProductDto;
import com.ak.ds.api.dto.StorageDto;
import com.ak.ds.api.dto.StoreDto;
import com.ak.ds.services.factories.IServiceFactory;
import com.ak.ds.services.factories.ServiceFactory;
import com.ak.ds.services.interfaces.ICategoryService;
import com.ak.ds.services.interfaces.IClientService;
import com.ak.ds.services.interfaces.IOrderService;
import com.ak.ds.services.interfaces.IProductService;
import com.ak.ds.services.interfaces.IStorageService;
import com.ak.ds.services.interfaces.IStoreService;

public class UserInterface implements IUserInterface {
	
	private UserInterface() {
	}
	
	private static UserInterface userInterface;
	
	public static UserInterface getUserInterface() {
		if (userInterface == null) {
			userInterface = new UserInterface();
		}
		return userInterface;
	}
	
	private IServiceFactory serviceFactory  = new ServiceFactory ();
	
	private ICategoryService categoryService = serviceFactory.getCategoryService();
	
	private IStoreService storeService = serviceFactory.getStoreService();
	
	private IProductService productService = serviceFactory.getProductService();
	
	private IClientService clientService = serviceFactory.getClientService();
	
	private IStorageService storageService = serviceFactory.getStorageService();
	
	private IOrderService orderService = serviceFactory.getOrderService();
	
	public void addClient(String name, String adress, String phone) {
		clientService.addClient(name, adress, phone);
	}
	
	public ClientDto getClient(Long id) {
		return clientService.getClientById(id);
	}
	
	public List<ClientDto> getAllClients() {
		return clientService.getAll();
	}
	
	public void updateClient(ClientDto clientDto) {
		clientService.updateClient(clientDto);
	}
	
	public void removeClient(Long id) {
		clientService.removeClient(id);
	}
	
	public void addStore(String name, String adress, String phone) {
		storeService.addStore(name, adress, phone);
	}
	
	public StoreDto getStore(Long id) {
		return storeService.getStoreById(id);
	}
	
	public List<StoreDto> getAllStores() {
		return storeService.getAll();
	}
	
	public void updateStore(StoreDto storeDto) {
		storeService.updateStore(storeDto);
	}
	
	public void removeStore(Long id) {
		storeService.removeStore(id);
	}
	
	public void addProduct(String name, List<Long> categories, List<String> attributes, String information) {
		productService.addProduct(name, categories, attributes, information);
	}
	
	public ProductDto getProduct(Long id) {
		return productService.getProductById(id);
	}
	
	public List<ProductDto> getAllProductes() {
		return productService.getAll();
	}
	
	public List<ProductDto> getAllProductesInCategory(Long id) {
		return productService.getProductsByCategoryById(id);
	}
	
	public List<ProductDto> findProductesbyAttributes(List<String> listAttributes) {
		return productService.findByAttributes(listAttributes);
	}
	
	public List<ProductDto> findProductesbyAttributes(String attribute) {
		return productService.findByAttributes(attribute);
	}
	
	public void updateProduct(ProductDto productDto) {
		productService.updateProduct(productDto);
	}
	
	public void removeProduct(Long id) {
		productService.removeProduct(id);
	}
	
	public void putProductInStore (Long storeId, Long productId, Integer price, Integer quantity) {
		storageService.addStorage(storeId, productId, price, quantity);
	}
	
	public StorageDto getStorage (Long id) {
		return storageService.getHeavyStorageById(id);
	}
	
	public void updateStorage (StorageDto storageDto) {
		storageService.updateStorage(storageDto);
	}
	
	public List<StorageDto> sortProductByPrice (Long id) {
		return storageService.sortProductByPriceInStores(id);
	}
	
	public List<CategoryDto> getAllCategories() {
		return categoryService.getAll();
	}
	
	public void createOrder(Long clientId, Long StoreId, Long productId, Integer quantity) {
		orderService.addOrder(clientId, StoreId, productId, quantity);
	}
	
	public OrderDto getOrder(Long id) {
		return orderService.getHeavyOrderById(id);
	}
	
	public void addCategory(String categoryName) {
		categoryService.addCategory(categoryName);
	}
}
