package com.ak.ds.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.ak.ds.api.dto.ClientDto;
import com.ak.ds.api.dto.ProductDto;
import com.ak.ds.api.dto.StorageDto;
import com.ak.ds.api.dto.StoreDto;
import com.ak.ds.ui.IUserInterface;
import com.ak.ds.ui.IUserInterfaceFactory;
import com.ak.ds.ui.UserInterfaceFactory;

/**
 * @author Aleh Kuruta
 * Directory is "e://json". It can be changed in "dao/util/DirectoryControl"
 * Entities get ID automatically that's why I delete another objects.
 * Because next time then you start "something will have gone wrong". Old objects was deleted and new will get new ID.
 */
public class Main {
	
	public static void main(String[] args) {
		
		//Create some objects
		UtilClassForCreateSomeEntities.create();
		
		IUserInterfaceFactory userInterfaceFactory = new UserInterfaceFactory();
		
		IUserInterface userInterface = userInterfaceFactory.createUserInterface();
		
		System.out.println("Create client");
		userInterface.addClient("Gosha", "Zavadskogo", "777-33-12");
		System.out.println(userInterface.getClient(3L));
		
		System.out.println("Change him");
		ClientDto clientDto = userInterface.getClient(3L);
		clientDto.setName("Not Gosha");
		userInterface.updateClient(clientDto);
		System.out.println(userInterface.getClient(3L));
		
		System.out.println("Create store");
		userInterface.addStore("The Best store in the world", "Serpukhova", "714-21-99");
		System.out.println(userInterface.getStore(3L));
		
		System.out.println("Now update");
		StoreDto storeDto = userInterface.getStore(3L);
		storeDto.setName("The worst store in the world");
		userInterface.updateStore(storeDto);
		System.out.println(userInterface.getStore(3L));
		
		System.out.println("Create product");
		List<Long> categories = new ArrayList<>();
		categories.add(1L);
		Collection<String> attributes = new ArrayList<>();
		attributes.add("Halloween");
		attributes.add("Yellow");
		userInterface.addProduct("Pumpkin", categories, attributes, "Just pumpkin");
		System.out.println(userInterface.getProduct(3L));
		
		System.out.println("Update");
		ProductDto productDto = userInterface.getProduct(3L);
		productDto.setInformation("Yellow pumpkin");
		userInterface.updateProduct(productDto);
		System.out.println(userInterface.getProduct(3L));
		System.out.println("Let's peek that in the second category");
		System.out.println(userInterface.getAllProductesInCategory(2L));
		System.out.println("And find something by attributes");
		
		Collection<Long> attributesId = new ArrayList<>();
		attributesId.add(1L);
		attributesId.add(2L);
		System.out.println(userInterface.findProductesbyAttributes(attributesId));
		System.out.println("or attribute");
		System.out.println(userInterface.findProductesbyAttributes(3L));
		
		System.out.println("Let's put pumpkin in some stores");
		userInterface.putProductInStore(1L, 3L, 120, 1200);
		System.out.println("check");
		System.out.println(userInterface.getStorage(1L));
		userInterface.putProductInStore(2L, 3L, 80, 1030);
		System.out.println(userInterface.getStorage(2L));
		userInterface.putProductInStore(3L, 3L, 100, 1300);
		System.out.println(userInterface.getStorage(3L));
		System.out.println("We have made a mistake");
		StorageDto storageDto =userInterface.getStorage(3L);
		storageDto.setQuantity(1003);
		storageDto.setPrice(105);
		userInterface.updateStorage(storageDto);
		System.out.println(userInterface.getStorage(3L));
		System.out.println("And sort");
		System.out.println(userInterface.sortProductByPrice(3L));
		
		System.out.println("New order");
		userInterface.createOrder(3L, 3L, 3L, 1);
		System.out.println(userInterface.getOrder(1L));
		
		System.out.println(userInterface.getClient(3L));
		System.out.println("Delete client");
		userInterface.removeClient(3L);
		System.out.println(userInterface.getClient(3L));
		System.out.println(userInterface.getProduct(3L));
		System.out.println("Delete product");
		userInterface.removeProduct(3L);
		System.out.println(userInterface.getProduct(3L));
		System.out.println(userInterface.getStore(3L));
		System.out.println("Delete store");
		userInterface.removeStore(3L);
		System.out.println(userInterface.getStore(3L));
	}
}
