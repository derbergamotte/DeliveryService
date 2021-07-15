package interfaces;

import dto.ClientDto;
import entities.Client;

import java.util.Collection;

public interface ClientService {

    void add(ClientDto clientDto);

    void add(String name, String address, String phone);

    ClientDto getById(Long id);

    Client getEntityById(Long id);

    Collection<ClientDto> getAll();

    void remove(Long id);

    void update(ClientDto clientDto);
}
