package implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

import dto.StoreDto;
import entities.Store;
import interfaces.StoreDao;
import interfaces.StoreService;
import mappers.StoreMapper;
import org.apache.commons.lang3.StringUtils;

public class StoreServiceImpl implements StoreService {

    private final StoreDao storeDao = StoreDaoImpl.getStoreDao();

    private StoreServiceImpl() {
    }

    private static StoreServiceImpl storeService;

    public static StoreServiceImpl getStoreService() {
        if (storeService == null) {
            storeService = new StoreServiceImpl();
        }
        return storeService;
    }

    public void add(StoreDto storeDto) {
        Store store = StoreMapper.dtoToEntity(storeDto);
        store.setStorages(new ArrayList<>());
        storeDao.add(store);
    }

    public void add(String name, String adress, String phone) {
        storeDao.add(new Store(name, phone, adress, new HashSet<>()));
    }

    public StoreDto getById(Long id) {
        return StoreMapper.entityToDto(getEntityById(id));
    }

    public Store getEntityById(Long id) {
        return Optional.of(Optional.ofNullable(this.storeDao.get(id)).orElse(new Store())).get();
    }

    public Collection<StoreDto> getAll() {
        return StoreMapper.convertList(storeDao.getAll());
    }

    public void remove(Long orderId) {
        storeDao.remove(orderId);
    }

    public void update(StoreDto storeDto) {
        if (!(storeDto.getId() == null)) {
            Store store = getEntityById(storeDto.getId());
            if (StringUtils.isNotEmpty(storeDto.getName())) {
                store.setName(storeDto.getName());
            }
            if (StringUtils.isNotEmpty(storeDto.getAddress())) {
                store.setAddress(storeDto.getAddress());
            }
            if (StringUtils.isNotEmpty(storeDto.getPhone())) {
                store.setPhone(storeDto.getPhone());
            }
            storeDao.update(store);
        }
    }
}
