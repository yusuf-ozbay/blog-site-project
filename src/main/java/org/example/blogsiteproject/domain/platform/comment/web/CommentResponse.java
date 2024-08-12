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

    private String id;
    private String content;
    private Date created;
    private Date modified;
    private UserDto user;
    private ArticleDto article;

}
