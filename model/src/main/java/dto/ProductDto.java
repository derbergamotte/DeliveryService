package dto;

import java.util.Collection;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProductDto extends BaseDto {

    private String name;
    private Collection<Long> categoriesId;
    private Collection<Long> storagesId;
    private Collection<Long> attributesId;
    private String information;
}
