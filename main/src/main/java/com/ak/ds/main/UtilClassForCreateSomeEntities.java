package com.ak.ds.main;

import java.util.ArrayList;
import java.util.List;

import com.ak.ds.ui.IUserInterface;
import com.ak.ds.ui.IUserInterfaceFactory;
import com.ak.ds.ui.UserInterfaceFactory;

public class UtilClassForCreateSomeEntities {
	
	public static void create() {
		
		IUserInterfaceFactory userInterfaceFactory = new UserInterfaceFactory();
		
		IUserInterface userInterface = userInterfaceFactory.createUserInterface();
		
		userInterface.addCategory("Food");
		userInterface.addCategory("Tool");
		userInterface.addCategory("Car");
		
		userInterface.addClient("Vasia", "Lermantova, 15", "103");
		userInterface.addClient("Petia", "Pushkina, 22", "111-22-33");
		
		userInterface.addStore("Piatiorochka", "VDNH", "755-62-75");
		userInterface.addStore("Shestiorochka", "Lenina", "132-13-12");
		
		
		List<Long> categories = new ArrayList<>();
		List<String> attributes = new ArrayList<>();
		categories.add(2L);
		categories.add(3L);
		attributes.add("Yellow");
		attributes.add("Iron");
		userInterface.addProduct("Hammer", categories, attributes, "You can hammer in a nail");
		categories.clear();
		attributes.clear();
		categories.add(2L);
		attributes.add("Iron");
		userInterface.addProduct("Saw", categories, attributes, "You can't hammer in a nail");
		
		
	}
}
