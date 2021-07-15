package interfaces;

import dto.StorageDto;
import entities.Storage;

import java.util.Collection;

public interface StorageService {

    void add(StorageDto storageDto);

    void add(Long storeId, Long productId, Integer price, Integer quantity);

    StorageDto getById(Long id);

    Storage getEntityById(Long id);

    Storage getEntityByStoreAndProduct(Long storeId, Long productId);

    Collection<StorageDto> getAll();

    void remove(Long id);

    void update(StorageDto storageDto);

    Collection<StorageDto> sortProductByPriceInStores(Long productId);
}
