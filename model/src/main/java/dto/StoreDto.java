package dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class StoreDto extends BaseDto {

    private String name;
    private String phone;
    private String address;
}
