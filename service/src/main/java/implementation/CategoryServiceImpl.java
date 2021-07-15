package implementation;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

import dto.CategoryDto;
import entities.Category;
import interfaces.CategoryDao;
import interfaces.CategoryService;
import mappers.CategoryMapper;
import org.apache.commons.lang3.StringUtils;


public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao = CategoryDaoImpl.getCategoryDao();

    private CategoryServiceImpl() {
    }

    private static CategoryServiceImpl categoryService;

    public static CategoryServiceImpl getCategoryService() {
        if (categoryService == null) {
            categoryService = new CategoryServiceImpl();
        }
        return categoryService;
    }

    public void add(CategoryDto categoryDto) {
        Category category = CategoryMapper.dtoToEntity(categoryDto);
        category.setProducts(new HashSet<>());
        categoryDao.add(category);
    }

    public void add(String name) {
        categoryDao.add(new Category(name, new HashSet<>()));
    }

    public CategoryDto getById(Long id) {
        return CategoryMapper.entityToDto(getEntityById(id));
    }

    public Category getEntityById(Long id) {
        return Optional.ofNullable(Optional.ofNullable(this.categoryDao.get(id)).orElse(new Category())).get();
    }

    public Collection<CategoryDto> getAll() {
        return CategoryMapper.convertList(categoryDao.getAll());
    }

    public void remove(Long categoryId) {
        categoryDao.remove(categoryId);
    }

    public void update(CategoryDto categoryDto) {
        if (!(categoryDto.getId() == null)) {
            Category category = getEntityById(categoryDto.getId());
            if (StringUtils.isNotEmpty(categoryDto.getName())) {
                category.setName(categoryDto.getName());
            }
            categoryDao.update(category);
        }
    }
}
