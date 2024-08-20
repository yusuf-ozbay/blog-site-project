package org.example.blogsiteproject.domain.platform.comment.web;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.blogsiteproject.domain.auth.user.api.UserDto;
import org.example.blogsiteproject.domain.platform.article.api.ArticleDto;

import java.util.Date;

@Builder
@Setter
@Getter
@RequiredArgsConstructor
public class CommentResponse {

    private final String id;
    private final String content;
    private final Date created;
    private final Date modified;
    private final UserDto user;
    private final ArticleDto article;

}
