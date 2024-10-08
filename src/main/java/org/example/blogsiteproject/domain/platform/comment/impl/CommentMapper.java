package org.example.blogsiteproject.domain.platform.comment.impl;

import org.example.blogsiteproject.domain.auth.user.api.UserDto;
import org.example.blogsiteproject.domain.platform.article.api.ArticleDto;
import org.example.blogsiteproject.domain.platform.comment.api.CommentDto;

public class CommentMapper {

    public static CommentDto toDto(Comment comment, UserDto userDto, ArticleDto articleDto) {
        return CommentDto.builder()
                .id(comment.getUserId())
                .created(comment.getCreated())
                .modified(comment.getModified())
                .content(comment.getContent())
                .user(userDto)
                .article(articleDto)
                .build();
    }

    public static Comment toEntity(Comment comment, CommentDto dto) {
        comment.setArticleId(dto.getArticle().getId());
        comment.setUserId(dto.getUser().getId());
        comment.setContent(dto.getContent());
        return comment;
    }

}
