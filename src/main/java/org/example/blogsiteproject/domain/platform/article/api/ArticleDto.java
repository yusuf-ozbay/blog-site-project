package org.example.blogsiteproject.domain.platform.article.api;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.blogsiteproject.domain.auth.user.api.UserDto;
import org.example.blogsiteproject.domain.platform.category.api.CategoryDto;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class ArticleDto {
    private final String id;
    private final String title;
    private final String content;
    private final Date created;
    private final Date modified;
    private final int likeCount;
    private final int status;

    private final UserDto user;
    private final CategoryDto category;
    private final List<String> categoryId;
}

//status silenecek
//categoryDto liste dönecek ve id silinecek
