package org.example.blogsiteproject.domain.platform.comment.api;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.blogsiteproject.domain.auth.user.api.UserDto;
import org.example.blogsiteproject.domain.platform.article.api.ArticleDto;

import java.util.Date;

@RequiredArgsConstructor
@Builder
@Setter
@Getter
public class CommentDto {

    private final String id;
    private final Date modified;
    private final Date created;
    private final UserDto user;
    private final ArticleDto article;
    private final String content;

}
