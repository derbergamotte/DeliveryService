package mappers;

import dto.CategoryDto;
import entities.Category;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;


public class CategoryMapper {

    private CategoryMapper() {
    }

    public static CategoryDto entityToDto(Category entity) {
        CategoryDto dto = new CategoryDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setProductsId(entity.getProducts().stream().map(p -> p.getId()).collect(Collectors.toSet()));
        return dto;
    }

    public static Category dtoToEntity(CategoryDto dto) {
        Category entity = new Category();
        entity.setName(dto.getName());
        return entity;
    }

    public static Collection<CategoryDto> convertList(Collection<Category> entities) {
        Collection<CategoryDto> listDto = new ArrayList<>();
        for (Category entity : entities) {
            CategoryDto dto = entityToDto(entity);
            listDto.add(dto);
        }
        return listDto;
    }
}
