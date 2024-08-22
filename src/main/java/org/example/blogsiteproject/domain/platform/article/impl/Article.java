package org.example.blogsiteproject.domain.platform.article.impl;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.example.blogsiteproject.library.rest.AbstractEntity;

@Getter
@Setter
@Entity
public class Article extends AbstractEntity {
    private String title;
    private String content;
    private int likeCount;
    private int status;

    private String userId;
    private String categoryId;

    //kategory id silinecek
}
