package mappers;

import dto.StoreDto;
import entities.Store;

import java.util.ArrayList;
import java.util.Collection;

public class StoreMapper {

    private StoreMapper() {
    }

    public static StoreDto entityToDto(Store entity) {
        StoreDto dto = new StoreDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAddress(entity.getAddress());
        dto.setPhone(entity.getPhone());
//		dto.setStorages(StorageMapper.convertList(entity.getStorages()));
        return dto;
    }

    public static Store dtoToEntity(StoreDto dto) {
        Store entity = new Store();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setPhone(dto.getPhone());
//		entity.setStorages(StorageMapper.convertListDtoToEntity(dto.getStorages()));
        return entity;
    }

    public static Collection<StoreDto> convertList(Collection<Store> entities) {
        Collection<StoreDto> listDto = new ArrayList<>();
        for (Store entity : entities) {
            StoreDto dto = entityToDto(entity);
            listDto.add(dto);
        }
        return listDto;
    }
}
