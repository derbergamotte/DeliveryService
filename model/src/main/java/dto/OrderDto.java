package dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrderDto extends BaseDto {
    //TODO: it will be changed
    private Long storageId;
    private StorageDto storage;
    private Long clientId;
    private ClientDto client;
    private Integer quantity;
}
