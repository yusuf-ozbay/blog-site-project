package org.example.blogsiteproject.domain.platform.category.impl;

import org.example.blogsiteproject.domain.platform.category.api.CategoryDto;

public class CategoryMapper {

    public CategoryMapper() {
    }

    public static Category toEntity(Category category, CategoryDto dto) {
        category.setName(dto.getName());
        return category;
    }

    public static CategoryDto toDto(Category category) {
        return CategoryDto.builder()
                .name(category.getName())
                .id(category.getId())
                .created(category.getCreated())
                .modified(category.getModified())
                .build();
    }
}
