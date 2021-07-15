package implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

import dto.ProductDto;
import entities.Attribute;
import entities.Category;
import entities.Product;
import interfaces.AttributeService;
import interfaces.CategoryService;
import interfaces.ProductDao;
import interfaces.ProductService;
import mappers.ProductMapper;
import org.apache.commons.lang3.StringUtils;

public class ProductServiceImpl implements ProductService {

	private final ProductDao productDao = ProductDaoImpl.getProductDao();
	private final AttributeService attributeService = AttributeServiceImpl.getAttributeService();
	private final CategoryService categoryService = CategoryServiceImpl.getCategoryService();
	
	private ProductServiceImpl() {
	}
	
	private static ProductServiceImpl productService;
	
	public static ProductServiceImpl getProductService() {
		if (productService == null) {
			productService = new ProductServiceImpl();
		}
		return productService;
	}

	public void add(ProductDto productDto) {
		Product product = ProductMapper.dtoToEntity(productDto);
		product.setStorages(new ArrayList<>());
		productDao.add(product);
	}
	
	public void add(String name, Collection<Long> categoriesId, Collection<String> attributeNames, String information) {
		Collection<Attribute> attributes = attributeNames.stream().map(attributeService::add).collect(Collectors.toSet());
		Collection<Category> categories = categoriesId.stream().map(categoryService::getEntityById).collect(Collectors.toSet());
		Product product = new Product(name, categories, new ArrayList<>(), attributes, information);
		productDao.add(product);
	}

	public ProductDto getById(Long id) {
		return ProductMapper.entityToDto(getEntityById(id));
	}

	public Product getEntityById(Long id) {
		return Optional.of(Optional.ofNullable(this.productDao.get(id)).orElse(new Product())).get();
	}

	public Collection<ProductDto> getAll() {
		return ProductMapper.convertList(productDao.getAll());
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
		Collection<Long> listProductId = categoryService.getById(categoryId).getProductsId();
		return listProductId.stream().map(this::getById).collect(Collectors.toSet());
	}

	public Collection<ProductDto> findByAttributes(Collection<Long> listAttributesId) {
		return ProductMapper.convertList(productDao.findByAttributes(listAttributesId));
	}

	public Collection<ProductDto> findByAttributes(Long attributeId) {
		Collection<Long> listAttributesId = new HashSet<>();
		listAttributesId.add(attributeId);
		return ProductMapper.convertList(productDao.findByAttributes(listAttributesId));
	}
}
