package org.example.blogsiteproject.domain.platform.comment.api;

import org.example.blogsiteproject.domain.auth.user.api.UserDto;
import org.example.blogsiteproject.domain.platform.article.api.ArticleDto;
import org.example.blogsiteproject.domain.platform.comment.web.CommentRequest;
import org.example.blogsiteproject.domain.platform.comment.web.CommentResponse;
import org.example.blogsiteproject.library.utils.PageUtil;
import org.springframework.data.domain.Page;

public class CommentMapper {

    public CommentMapper() {
    }

    public static CommentResponse toResponse(CommentDto dto) {
        return CommentResponse.builder()
                .id(dto.getId())
                .article(dto.getArticle())
                .user(dto.getUser())
                .content(dto.getContent())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .build();
    }
    public static CommentDto toDto(CommentRequest request) {
        return CommentDto.builder()
                .article(ArticleDto.builder().id(request.getArticleId()).build())
                .user(UserDto.builder().id(request.getUserId()).build())
                .content(request.getContent())
                .build();
    }

    public static Page<CommentResponse> toPageResponse(Page<CommentDto> dtos) {
        return PageUtil.pageToDto(dtos, CommentMapper::toResponse);
    }

}
