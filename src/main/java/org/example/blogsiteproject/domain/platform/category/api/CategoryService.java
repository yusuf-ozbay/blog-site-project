package org.example.blogsiteproject.domain.platform.category.api;

import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {


    CategoryDto getById(String id);
    CategoryDto save(CategoryDto dto);

    void delete(String id);

    List<CategoryDto> getAll();

    CategoryDto update(String id, CategoryDto dto);

    List<CategoryDto> getByIds(List<String> categoryIds);
}
