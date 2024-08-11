package org.example.blogsiteproject.domain.platform.article.api;

import org.example.blogsiteproject.domain.auth.user.api.UserDto;
import org.example.blogsiteproject.domain.platform.article.web.ArticleRequest;
import org.example.blogsiteproject.domain.platform.article.web.ArticleResponse;
import org.example.blogsiteproject.domain.platform.category.api.CategoryDto;
import org.example.blogsiteproject.library.utils.PageUtil;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class ArticleMapper {
    private ArticleMapper() {
    }

    public static ArticleResponse toResponse(ArticleDto dto) {
        return ArticleResponse.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .modified(dto.getModified())
                .created(dto.getCreated())
                .id(dto.getId())
                .likeCount(dto.getLikeCount())
                .category(dto.getCategory())
                .user(dto.getUser())
                .build();
    }

    public static ArticleDto toDto(ArticleRequest request) {
        return ArticleDto.builder()

                .title(request.getTitle())
                .content(request.getContent())
                .category(CategoryDto.builder()
                        .id((request.getCategoryId())).build())
                .user(UserDto.builder()
                        .id(request.getUserId()).build())
                .build();
    }



    public static Page<ArticleResponse> toPageResponse(Page<ArticleDto> articleDtos) {
        return PageUtil.pageToDto(articleDtos, ArticleMapper::toResponse);
    }
}
