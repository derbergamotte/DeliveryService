package implementation;

import dto.StorageDto;
import entities.Product;
import entities.Storage;
import entities.Store;
import interfaces.ProductService;
import interfaces.StorageDao;
import interfaces.StorageService;
import interfaces.StoreService;
import mappers.StorageMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StorageServiceImpl implements StorageService {

    private final StorageDao storageDao = StorageDaoImpl.getStorageDao();
    private final StoreService storeService = StoreServiceImpl.getStoreService();
    private final ProductService productService = ProductServiceImpl.getProductService();

    private StorageServiceImpl() {
    }

    private static StorageServiceImpl storageService;

    public static StorageServiceImpl getStorageService() {
        if (storageService == null) {
            storageService = new StorageServiceImpl();
        }
        return storageService;
    }

    public void add(StorageDto storageDto) {
        if (!(storeService.getById(storageDto.getStoreId()) == null
                && productService.getById(storageDto.getProductId()) == null)) {
            Storage storage = storageDao.add(StorageMapper.dtoToEntity(storageDto));
            storageDao.add(storage);
        }
    }

    public void add(Long storeId, Long productId, Integer price, Integer quantity) {
        if (!(storeService.getById(storeId).getId() == null
                && productService.getById(productId).getId() == null)) {
            Store store = storeService.getEntityById(storeId);
            Product product = productService.getEntityById(productId);
            Storage storage = new Storage(store, product, quantity, price, new ArrayList<>());
            storageDao.add(storage);
        }
    }

    public StorageDto getById(Long id) {
        return StorageMapper.entityToDto(getEntityById(id));
    }

    public Storage getEntityByStoreAndProduct(Long storeId, Long productId) {
        StorageDto storage = new StorageDto();
        for (StorageDto itterator : getAll()) {
            if (itterator.getStoreId().equals(storeId) && itterator.getProductId().equals(productId)) {
                storage = itterator;
            }
        }
        return StorageMapper.dtoToEntity(storage);
    }

    public Storage getEntityById(Long id) {
        return Optional.of(Optional.ofNullable(this.storageDao.get(id)).orElse(new Storage())).get();
    }

    public Collection<StorageDto> getAll() {
        return StorageMapper.convertList(storageDao.getAll());
    }

    public void remove(Long id) {
        storageDao.remove(id);
    }

    public void update(StorageDto storageDto) {
        if (!(storageDto.getId() == null)) {
            Storage storage = getEntityById(storageDto.getId());
            if (!(storageDto.getQuantity() == null)) {
                storage.setQuantity(storageDto.getQuantity());
            }
            if (!(storageDto.getPrice() == null)) {
                storage.setPrice(storageDto.getPrice());
            }
            storageDao.update(storage);
        }
    }

    public Collection<StorageDto> sortProductByPriceInStores(Long productId) {
        List<StorageDto> listStorages = new ArrayList<>();
        Collection<Long> storagesId = productService.getById(productId).getStoragesId();
        try {
            for (StorageDto storage : storagesId.stream().map(this::getById).collect(Collectors.toSet())) {
                listStorages.add(getById(storage.getId()));
            }
            listStorages.sort(Comparator.comparing(StorageDto::getPrice));
        } catch (NullPointerException e) {
            System.out.println("There isn't that storage");
        }
        return listStorages;
    }
}
