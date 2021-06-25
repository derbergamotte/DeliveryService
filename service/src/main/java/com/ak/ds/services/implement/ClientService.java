package com.ak.ds.services.implement;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

import com.ak.ds.api.dto.ClientDto;
import com.ak.ds.api.mappers.ClientMapper;
import com.ak.ds.dao.implement.ClientDao;
import com.ak.ds.dao.interfaces.IClientDao;
import com.ak.ds.entities.Client;
import com.ak.ds.services.interfaces.IClientService;

public class ClientService implements IClientService {
	
	private ClientService() {
	}
	
	private static ClientService clientService;
	
	public static ClientService getClientService() {
		if (clientService == null) {
			clientService = new ClientService();
		}
		return clientService;
	}

	private IClientDao clientDao = ClientDao.getClientDao();

	public void addClient(ClientDto clientDto) {
		clientDao.add(ClientMapper.dtoToEntity(clientDto));
	}

	public void addClient(String name, String adress, String phone) {
		clientDao.add(new Client(name, phone, adress));
	}

	public ClientDto getClientById(Long id) {
		return ClientMapper.entityToDto(getClientEntity(id));
	}

	private Client getClientEntity(Long id) {
		return Optional.ofNullable(Optional.ofNullable(this.clientDao.get(id)).orElse(new Client())).get();
	}

	public List<ClientDto> getAll() {
		return ClientMapper.convertList(clientDao.getAll());
	}

	public void removeClient(Long id) {
		clientDao.remove(id);
	}

	public void updateClient(ClientDto clientDto) {
		if (!(clientDto.getId() == null)) {
			Client client = getClientEntity(clientDto.getId());
			if (StringUtils.isNotEmpty(clientDto.getName())) {
				client.setName(clientDto.getName());
			}
			if (StringUtils.isNotEmpty(clientDto.getPhone())) {
				client.setPhone(clientDto.getPhone());
			}
			if (StringUtils.isNotEmpty(clientDto.getAdress())) {
				client.setAdress(clientDto.getAdress());
			}
			clientDao.update(client);
		}
	}
}
