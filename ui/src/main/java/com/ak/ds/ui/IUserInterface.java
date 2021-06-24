package com.ak.ds.ui;

import java.util.List;

import com.ak.ds.api.dto.CategoryDto;
import com.ak.ds.api.dto.ClientDto;
import com.ak.ds.api.dto.OrderDto;
import com.ak.ds.api.dto.ProductDto;
import com.ak.ds.api.dto.StorageDto;
import com.ak.ds.api.dto.StoreDto;

public interface IUserInterface {

	void addClient(String name, String adress, String phone);

	ClientDto getClient(Long id);

	List<ClientDto> getAllClients();

	void updateClient(ClientDto clientDto);

	void removeClient(Long id);

	void addStore(String name, String adress, String phone);

	StoreDto getStore(Long id);

	List<StoreDto> getAllStores();

	void updateStore(StoreDto storeDto);

	void removeStore(Long id);

	void addProduct(String name, List<Long> categories, List<String> attributes, String information);

	ProductDto getProduct(Long id);

	List<ProductDto> getAllProductes();

	List<ProductDto> getAllProductesInCategory(Long id);

	List<ProductDto> findProductesbyAttributes(List<String> listAttributes);

	List<ProductDto> findProductesbyAttributes(String attribute);

	void updateProduct(ProductDto productDto);

	void removeProduct(Long id);

	void putProductInStore(Long storeId, Long productId, Integer price, Integer quantity);

	StorageDto getStorage(Long id);

	void updateStorage(StorageDto storageDto);

	List<StorageDto> sortProductByPrice(Long id);

	List<CategoryDto> getAllCategories();

	void createOrder(Long clientId, Long StoreId, Long productId, Integer quantity);

	OrderDto getOrder(Long id);

}