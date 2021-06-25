package com.ak.ds.ui;

public class UserInterfaceFactory implements IUserInterfaceFactory {
	
	public UserInterface createUserInterface() {
		return UserInterface.getUserInterface();
	}
}
