package mappers;

import dto.ClientDto;
import entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Collection;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(source = "id", target = "id")
    ClientDto toDto(Client entity);

    Collection<ClientDto> toDto(Collection<Client> clients);

    Client toEntity(ClientDto dto);
}
