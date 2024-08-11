package org.example.blogsiteproject.domain.platform.collection.api;

import lombok.*;
import org.example.blogsiteproject.domain.auth.user.api.UserDto;
import org.example.blogsiteproject.domain.platform.article.api.ArticleDto;

import java.util.Date;

@RequiredArgsConstructor
@Setter
@Getter
@Builder
public class CollectionDto {

    private final String id;
    private final String name;
    private final Date created;
    private final Date modified;
    private final UserDto user;
    private final ArticleDto article;

}
