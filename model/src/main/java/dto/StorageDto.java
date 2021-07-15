package dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class StorageDto extends BaseDto {

    private Long storeId;
    private Long productId;
    private Integer quantity;
    private Integer price;
}
