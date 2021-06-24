package com.ak.ds.services.interfaces;

import java.util.List;

import com.ak.ds.api.dto.ClientDto;

public interface IClientService {
	
	public void addClient(ClientDto clientDto);
	public void addClient(String name, String adress, String phone);
	public ClientDto getClientById(Long id);
	public List<ClientDto> getAll();
	public void removeClient(Long id);
	public void updateClient(ClientDto clientDto);
}
