package interfaces;

import dto.CategoryDto;
import entities.Category;

import java.util.Collection;

public interface CategoryService {

    void add(CategoryDto categoryDto);

    void add(String name);

    CategoryDto getById(Long id);

    Category getEntityById(Long id);

    Collection<CategoryDto> getAll();

    void remove(Long categoryId);

    void update(CategoryDto categoryDto);
}
