package interfaces;

import dto.StoreDto;
import entities.Store;

import java.util.Collection;

public interface StoreService {

    void add(StoreDto storeDto);

    void add(String name, String adress, String phone);

    StoreDto getById(Long id);

    Store getEntityById(Long id);

    Collection<StoreDto> getAll();

    void remove(Long orderId);

    void update(StoreDto storeDto);
}
