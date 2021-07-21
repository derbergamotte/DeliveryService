package implementation;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import dto.ProductDto;
import entities.Product;
import interfaces.AttributeService;
import interfaces.CategoryService;
import interfaces.ProductDao;
import interfaces.ProductService;
import mappers.AttributeMapper;
import mappers.CategoryMapper;
import mappers.ProductMapper;
import org.apache.commons.lang3.StringUtils;

public class ProductServiceImpl implements ProductService {

    private final ProductDao productDao = ProductDaoImpl.getProductDao();
    private final AttributeService attributeService = AttributeServiceImpl.getAttributeService();
    private final CategoryService categoryService = CategoryServiceImpl.getCategoryService();

    private static ProductServiceImpl productService;

    private ProductServiceImpl() {
    }

    public static ProductServiceImpl getProductService() {
        if (productService == null) {
            productService = new ProductServiceImpl();
        }
        return productService;
    }

    public ProductDto add(ProductDto productDto) {
        productDto.setAttributes(productDto.getAttributes().stream().map(attributeService::getElseAdd).collect(Collectors.toSet()));
        return ProductMapper.INSTANCE.toDto(productDao.add(ProductMapper.INSTANCE.toEntity(productDto)));
    }

    public ProductDto getById(Long id) {
        return ProductMapper.INSTANCE.toDto(getEntityById(id));
    }

    public Product getEntityById(Long id) {
        return Optional.of(Optional.ofNullable(this.productDao.get(id)).orElse(new Product())).get();
    }

    public Collection<ProductDto> getAll() {
        return ProductMapper.INSTANCE.toDto(productDao.getAll());
    }

    public void remove(Long orderId) {
        productDao.remove(orderId);
    }

    public void update(ProductDto productDto) {
        if (!(productDto.getId() == null)) {
            Product product = getEntityById(productDto.getId());
            if (StringUtils.isNotEmpty(productDto.getName())) {
                product.setName(productDto.getName());
            }
            if (StringUtils.isNotEmpty(productDto.getInformation())) {
                product.setInformation(productDto.getInformation());
            }
            productDao.update(product);
        }
    }

    public Collection<ProductDto> getByCategoryById(Long categoryId) {
        return ProductMapper.INSTANCE.toDto(productDao.findByCategory(CategoryMapper.INSTANCE.toEntity(categoryService.getById(categoryId))));
    }

    public Collection<ProductDto> findByAttributes(Collection<Long> listAttributesId) {
        return ProductMapper.INSTANCE.toDto(productDao.findByAttributes(
                listAttributesId.stream()
                        .map(a -> AttributeMapper.INSTANCE.toEntity(attributeService.getById(a)))
                        .collect(Collectors.toSet())));
    }
}
