package mappers;

import dto.OrderDto;
import entities.Order;

import java.util.ArrayList;
import java.util.Collection;

public class OrderMapper {

    private OrderMapper() {
    }

    public static OrderDto entityToDto(Order entity) {
        OrderDto dto = new OrderDto();
        dto.setId(entity.getId());
        dto.setClientId(entity.getClient().getId());
        dto.setStorageId(entity.getStorage().getId());
        dto.setQuantity(entity.getQuantity());
        return dto;
    }

    public static Order dtoToEntity(OrderDto dto) {
        Order entity = new Order();
        entity.setId(dto.getId());
        entity.setQuantity(dto.getQuantity());
        return entity;
    }

    public static Collection<OrderDto> convertList(Collection<Order> entities) {
        Collection<OrderDto> listDto = new ArrayList<>();
        for (Order entity : entities) {
            OrderDto dto = entityToDto(entity);
            listDto.add(dto);
        }
        return listDto;
    }
}