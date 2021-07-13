package com.ak.ds.ui;

import java.util.Collection;

import com.ak.ds.api.dto.CategoryDto;
import com.ak.ds.api.dto.ClientDto;
import com.ak.ds.api.dto.OrderDto;
import com.ak.ds.api.dto.ProductDto;
import com.ak.ds.api.dto.StorageDto;
import com.ak.ds.api.dto.StoreDto;

public interface IUserInterface {

	void addClient(String name, String adress, String phone);

	ClientDto getClient(Long id);

	Collection<ClientDto> getAllClients();

	void updateClient(ClientDto clientDto);

	void removeClient(Long id);

	void addStore(String name, String adress, String phone);

	StoreDto getStore(Long id);

	Collection<StoreDto> getAllStores();

	void updateStore(StoreDto storeDto);

	void removeStore(Long id);

	public void addProduct(String name, Collection<Long> categoriesId, Collection<String> attributes, String information);

	ProductDto getProduct(Long id);

	Collection<ProductDto> getAllProductes();

	Collection<ProductDto> getAllProductesInCategory(Long id);

	Collection<ProductDto> findProductesbyAttributes(Collection<Long> listAttributes);

	Collection<ProductDto> findProductesbyAttributes(Long attribute);

	void updateProduct(ProductDto productDto);

	void removeProduct(Long id);

	void putProductInStore(Long storeId, Long productId, Integer price, Integer quantity);

	StorageDto getStorage(Long id);

	void updateStorage(StorageDto storageDto);

	Collection<StorageDto> sortProductByPrice(Long id);

	Collection<CategoryDto> getAllCategories();

	void createOrder(Long clientId, Long StoreId, Long productId, Integer quantity);

	OrderDto getOrder(Long id);
	
	public void addCategory(String categoryName);
}