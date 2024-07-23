package org.example.blogsiteproject.domain.platform.category.impl;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.blogsiteproject.domain.platform.category.api.CategoryDto;
import org.example.blogsiteproject.domain.platform.category.api.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    @Override
    public CategoryDto getById(String id) {
        return repository.findById(id).map(CategoryMapper::toDto).orElseThrow();
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        return CategoryMapper.toDto(repository.save(CategoryMapper.toEntity(new Category() , dto)));
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public List<CategoryDto> getAll() {
        return repository.findAll().stream().map(CategoryMapper::toDto).toList();
    }

    @Override
    public CategoryDto update(String id, CategoryDto dto) {
        return null;
    }

    @Override
    public List<CategoryDto> getByIds(List<String> categoryIds) {
        return null;
    }
}
