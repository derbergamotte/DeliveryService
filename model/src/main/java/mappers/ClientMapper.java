package mappers;

import dto.ClientDto;
import entities.Client;

import java.util.ArrayList;
import java.util.Collection;

public class ClientMapper {

    private ClientMapper() {
    }

    public static ClientDto entityToDto(Client entity) {
        ClientDto dto = new ClientDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPhone(entity.getPhone());
        dto.setAddress(entity.getAddress());
        return dto;
    }

    public static Client dtoToEntity(ClientDto dto) {
        Client entity = new Client();
        entity.setName(dto.getName());
        entity.setPhone(dto.getPhone());
        entity.setAddress(dto.getAddress());
        return entity;
    }

    public static Collection<ClientDto> convertList(Collection<Client> entities) {
        Collection<ClientDto> listDto = new ArrayList<>();
        for (Client entity : entities) {
            ClientDto dto = entityToDto(entity);
            listDto.add(dto);
        }
        return listDto;
    }
}
