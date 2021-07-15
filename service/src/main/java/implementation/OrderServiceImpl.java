package implementation;

import java.util.Collection;
import java.util.Optional;

import dto.OrderDto;
import entities.Client;
import entities.Order;
import entities.Storage;
import interfaces.ClientService;
import interfaces.OrderDao;
import interfaces.OrderService;
import interfaces.StorageService;
import mappers.OrderMapper;

public class OrderServiceImpl implements OrderService {

	private final OrderDao orderDao = OrderDaoImpl.getOrderDao();
	private final StorageService storageService = StorageServiceImpl.getStorageService();
	private final ClientService clientService = ClientServiceImpl.getClientService();

	private OrderServiceImpl() {
	}

	private static OrderServiceImpl orderService;

	public static OrderServiceImpl getOrderService() {
		if (orderService == null) {
			orderService = new OrderServiceImpl();
		}
		return orderService;
	}

	public void add(OrderDto orderDto) {
		orderDao.add(OrderMapper.dtoToEntity(orderDto));
	}

	public void add(Long clientId, Long storeId, Long productId, Integer quantity) {
		try {
			Storage storage = storageService.getEntityByStoreAndProduct(storeId, productId);
			Client client = clientService.getEntityById(clientId);
			orderDao.add(new Order(storage, client, quantity));
		} catch (NullPointerException e) {
			System.out.println("I don find this store or product. I'm sorry");
		}
	}

	public OrderDto getById(Long id) {
		return OrderMapper.entityToDto(getEntity(id));
	}

	private Order getEntity(Long id) {
		return Optional.ofNullable(Optional.ofNullable(this.orderDao.get(id)).orElse(new Order())).get();
	}

	public OrderDto getHeavyById(Long id) {
		OrderDto orderDto = getById(id);
		orderDto.setClient(clientService.getById(orderDto.getClientId()));
		orderDto.setStorage(storageService.getById(orderDto.getStorageId()));
		return orderDto;
	}

	public Collection<OrderDto> getAll() {
		return OrderMapper.convertList(orderDao.getAll());
	}
}