package com.ak.ds.ui;

import java.util.List;

import com.ak.ds.api.dto.CategoryDto;
import com.ak.ds.api.dto.ClientDto;
import com.ak.ds.api.dto.OrderDto;
import com.ak.ds.api.dto.ProductDto;
import com.ak.ds.api.dto.StorageDto;
import com.ak.ds.api.dto.StoreDto;
import com.ak.ds.services.implement.CategoryService;
import com.ak.ds.services.implement.ClientService;
import com.ak.ds.services.implement.OrderService;
import com.ak.ds.services.implement.ProductService;
import com.ak.ds.services.implement.StorageService;
import com.ak.ds.services.implement.StoreService;
import com.ak.ds.services.interfaces.ICategoryService;
import com.ak.ds.services.interfaces.IClientService;
import com.ak.ds.services.interfaces.IOrderService;
import com.ak.ds.services.interfaces.IProductService;
import com.ak.ds.services.interfaces.IStorageService;
import com.ak.ds.services.interfaces.IStoreService;

public class UserInterface implements IUserInterface {
	
	private ICategoryService categoryService = new CategoryService();
	
	private IStoreService storeService = new StoreService();
	
	private IProductService productService = new ProductService();
	
	private IClientService clientService = new ClientService ();
	
	private IStorageService storageService = new StorageService();
	
	private IOrderService orderService = new OrderService();
	
	@Override
	public void addClient(String name, String adress, String phone) {
		clientService.addClient(name, adress, phone);
	}
	
	@Override
	public ClientDto getClient(Long id) {
		return clientService.getClientById(id);
	}
	
	@Override
	public List<ClientDto> getAllClients() {
		return clientService.getAll();
	}
	
	@Override
	public void updateClient(ClientDto clientDto) {
		clientService.updateClient(clientDto);
	}
	
	@Override
	public void removeClient(Long id) {
		clientService.removeClient(id);
	}
	
	@Override
	public void addStore(String name, String adress, String phone) {
		storeService.addStore(name, adress, phone);
	}
	
	@Override
	public StoreDto getStore(Long id) {
		return storeService.getStoreById(id);
	}
	
	@Override
	public List<StoreDto> getAllStores() {
		return storeService.getAll();
	}
	
	@Override
	public void updateStore(StoreDto storeDto) {
		storeService.updateStore(storeDto);
	}
	
	@Override
	public void removeStore(Long id) {
		storeService.removeStore(id);
	}
	
	@Override
	public void addProduct(String name, List<Long> categories, List<String> attributes, String information) {
		productService.addProduct(name, categories, attributes, information);
	}
	
	@Override
	public ProductDto getProduct(Long id) {
		return productService.getProductById(id);
	}
	
	@Override
	public List<ProductDto> getAllProductes() {
		return productService.getAll();
	}
	
	@Override
	public List<ProductDto> getAllProductesInCategory(Long id) {
		return productService.getProductsByCategoryById(id);
	}
	
	@Override
	public List<ProductDto> findProductesbyAttributes(List<String> listAttributes) {
		return productService.findByAttributes(listAttributes);
	}
	
	@Override
	public List<ProductDto> findProductesbyAttributes(String attribute) {
		return productService.findByAttributes(attribute);
	}
	
	@Override
	public void updateProduct(ProductDto productDto) {
		productService.updateProduct(productDto);
	}
	
	@Override
	public void removeProduct(Long id) {
		productService.removeProduct(id);
	}
	
	@Override
	public void putProductInStore (Long storeId, Long productId, Integer price, Integer quantity) {
		storageService.addStorage(storeId, productId, price, quantity);
	}
	
	@Override
	public StorageDto getStorage (Long id) {
		return storageService.getHeavyStorageById(id);
	}
	
	@Override
	public void updateStorage (StorageDto storageDto) {
		storageService.updateStorage(storageDto);
	}
	
	@Override
	public List<StorageDto> sortProductByPrice (Long id) {
		return storageService.sortProductByPriceInStores(id);
	}
	
	@Override
	public List<CategoryDto> getAllCategories() {
		return categoryService.getAll();
	}
	
	@Override
	public void createOrder(Long clientId, Long StoreId, Long productId, Integer quantity) {
		orderService.addOrder(clientId, StoreId, productId, quantity);
	}
	@Override
	public OrderDto getOrder(Long id) {
		return orderService.getHeavyOrderById(id);
	}
}
