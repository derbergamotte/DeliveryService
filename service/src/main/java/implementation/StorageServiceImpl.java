package implementation;

import dto.StorageDto;
import entities.Storage;
import interfaces.ProductService;
import interfaces.StorageDao;
import interfaces.StorageService;
import mappers.StorageMapper;

import java.util.*;
import java.util.stream.Collectors;

public class StorageServiceImpl implements StorageService {

    private final StorageDao storageDao = StorageDaoImpl.getStorageDao();
    private final ProductService productService = ProductServiceImpl.getProductService();
    private static StorageServiceImpl storageService;

    private StorageServiceImpl() {
    }

    public static StorageServiceImpl getStorageService() {
        if (storageService == null) {
            storageService = new StorageServiceImpl();
        }
        return storageService;
    }

    public StorageDto add(StorageDto storageDto) {
        return StorageMapper.INSTANCE.toDto(storageDao.add(StorageMapper.INSTANCE.toEntity(storageDto)));
    }

    public StorageDto getById(Long id) {
        return StorageMapper.INSTANCE.toDto(getEntityById(id));
    }

    public Storage getEntityByStoreAndProduct(Long storeId, Long productId) {
        StorageDto storage = new StorageDto();
        for (StorageDto itterator : getAll()) {
            if (itterator.getStore().equals(storeId) && itterator.getProduct().equals(productId)) {
                storage = itterator;
            }
        }
        return StorageMapper.INSTANCE.toEntity(storage);
    }

    //TODO: to check
    private Storage getEntityById(Long id) {
        return Optional.of(Optional.ofNullable(this.storageDao.get(id)).orElse(null)).get();
    }

    public Collection<StorageDto> getAll() {
        return StorageMapper.INSTANCE.toDto(storageDao.getAll());
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
        return productService.getById(productId).getStorages()
                .stream()
                .sorted(Comparator.comparing(StorageDto::getPrice))
                .collect(Collectors.toList());
    }
}
