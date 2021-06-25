package com.ak.ds.dao.implement;

import com.ak.ds.dao.interfaces.IClientDao;
import com.ak.ds.entities.Client;

public class ClientDao extends AGenericDao<Client> implements IClientDao{

	private ClientDao() {
		super(Client.class);
	}
	
	private static ClientDao clientDao;
	
	public static ClientDao getClientDao() {
		if (clientDao == null) {
			clientDao = new ClientDao();
		}
		return clientDao;
	}
}
