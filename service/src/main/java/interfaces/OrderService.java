package interfaces;

import dto.OrderDto;

import java.util.Collection;


public interface OrderService {

    void add(OrderDto orderDto);

    void add(Long clientId, Long storeId, Long productId, Integer quantity);

    OrderDto getById(Long id);

    OrderDto getHeavyById(Long id);

    Collection<OrderDto> getAll();
}
