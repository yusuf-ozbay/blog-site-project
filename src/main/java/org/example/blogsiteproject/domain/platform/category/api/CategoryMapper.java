package org.example.blogsiteproject.domain.platform.category.api;


import org.example.blogsiteproject.domain.platform.category.web.CategoryRequest;
import org.example.blogsiteproject.domain.platform.category.web.CategoryResponse;
import org.example.blogsiteproject.library.utils.PageUtil;
import org.springframework.data.domain.Page;

public class CategoryMapper {

    public CategoryMapper() {
    }

    public static CategoryResponse toResponse(CategoryDto dto) {
        return CategoryResponse.builder()
                .id(dto.getId())
                .name(dto.getName())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .build();
    }

    public static CategoryDto toDto(CategoryRequest request) {
        return CategoryDto.builder()
                .name(request.getName())
                .build();
    }

    public static Page<CategoryResponse> toPageResponse(Page<CategoryDto> dtos) {
        return PageUtil.pageToDto(dtos, CategoryMapper::toResponse);
    }

}
