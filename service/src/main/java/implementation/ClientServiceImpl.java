package implementation;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

import dto.ClientDto;
import entities.Client;
import interfaces.ClientDao;
import interfaces.ClientService;
import mappers.ClientMapper;
import org.apache.commons.lang3.StringUtils;


public class ClientServiceImpl implements ClientService {

    private final ClientDao clientDao = ClientDaoImpl.getClientDao();

    private ClientServiceImpl() {
    }

    private static ClientServiceImpl clientService;

    public static ClientServiceImpl getClientService() {
        if (clientService == null) {
            clientService = new ClientServiceImpl();
        }
        return clientService;
    }

    public void add(ClientDto clientDto) {
        clientDao.add(ClientMapper.dtoToEntity(clientDto));
    }

    public void add(String name, String address, String phone) {
        clientDao.add(new Client(name, phone, address, new HashSet<>()));
    }

    public ClientDto getById(Long id) {
        return ClientMapper.entityToDto(getEntityById(id));
    }

    //TODO: Generate error
    public Client getEntityById(Long id) {
        return Optional.ofNullable(Optional.ofNullable(this.clientDao.get(id)).orElse(new Client())).get();
    }

    public Collection<ClientDto> getAll() {
        return ClientMapper.convertList(clientDao.getAll());
    }

    public void remove(Long id) {
        clientDao.remove(id);
    }

    public void update(ClientDto clientDto) {
        if (!(clientDto.getId() == null)) {
            Client client = getEntityById(clientDto.getId());
            if (StringUtils.isNotEmpty(clientDto.getName())) {
                client.setName(clientDto.getName());
            }
            if (StringUtils.isNotEmpty(clientDto.getPhone())) {
                client.setPhone(clientDto.getPhone());
            }
            if (StringUtils.isNotEmpty(clientDto.getAddress())) {
                client.setAddress(clientDto.getAddress());
            }
            clientDao.update(client);
        }
    }
}
