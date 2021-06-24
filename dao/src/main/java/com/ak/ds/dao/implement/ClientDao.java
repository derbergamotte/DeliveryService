package com.ak.ds.dao.implement;

import com.ak.ds.dao.interfaces.IClientDao;
import com.ak.ds.entities.Client;

public class ClientDao extends AGenericDao<Client> implements IClientDao{

	public ClientDao() {
		super(Client.class);
	}
	

}
