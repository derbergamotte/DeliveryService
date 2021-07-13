package com.ak.ds.services.interfaces;

import java.util.Collection;

import com.ak.ds.api.dto.ClientDto;
import com.ak.ds.entities.Client;

public interface IClientService {
	
	public void addClient(ClientDto clientDto);
	public void addClient(String name, String adress, String phone);
	public ClientDto getClientById(Long id);
	public Client getClientEntityById(Long id);
	public Collection<ClientDto> getAll();
	public void removeClient(Long id);
	public void updateClient(ClientDto clientDto);
}
