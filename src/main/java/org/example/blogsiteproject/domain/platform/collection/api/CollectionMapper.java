package org.example.blogsiteproject.domain.platform.collection.api;

import org.example.blogsiteproject.domain.auth.user.api.UserDto;
import org.example.blogsiteproject.domain.platform.article.api.ArticleDto;
import org.example.blogsiteproject.domain.platform.collection.web.AddArticleToCollectionRequest;
import org.example.blogsiteproject.domain.platform.collection.web.CollectionRequest;
import org.example.blogsiteproject.domain.platform.collection.web.CollectionResponse;
import org.example.blogsiteproject.library.utils.PageUtil;
import org.springframework.data.domain.Page;

public class CollectionMapper {

    public static CollectionDto toDto(CollectionRequest request) {
        return CollectionDto.builder()
                .name(request.getName())
                .user(UserDto.builder().id(request.getUserId()).build())
                .build();
    }

    public static CollectionDto toDto(AddArticleToCollectionRequest request) {
        return CollectionDto.builder()
                .article(ArticleDto.builder().id(request.getArticleId()).build())
                .user(UserDto.builder().id(request.getUserId()).build())
                .id(request.getCollectionId())
                .build();
    }

    public static CollectionResponse toResponse(CollectionDto dto) {
        return CollectionResponse.builder()
                .id(dto.getId())
                .name(dto.getName())
                .user(dto.getUser())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .build();
    }

    public static Page<CollectionResponse> toPageResponse(Page<CollectionDto> dtos) {
        return PageUtil.pageToDto(dtos, CollectionMapper::toResponse);
    }
}
