package interfaces;

import dto.ProductDto;
import entities.Product;

import java.util.Collection;

public interface ProductService {

    void add(ProductDto productDto);

    void add(String name, Collection<Long> categoriesId, Collection<String> attributes, String information);

    ProductDto getById(Long id);

    Product getEntityById(Long id);

    Collection<ProductDto> getAll();

    void remove(Long orderId);

    void update(ProductDto productDto);

    Collection<ProductDto> getByCategoryById(Long categoryId);

    Collection<ProductDto> findByAttributes(Collection<Long> listAttributes);

    Collection<ProductDto> findByAttributes(Long attribute);
}
