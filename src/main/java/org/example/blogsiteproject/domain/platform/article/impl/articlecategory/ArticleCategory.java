package org.example.blogsiteproject.domain.platform.article.impl.articlecategory;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.example.blogsiteproject.library.rest.AbstractEntity;

@Entity
@Setter
@Getter
public class ArticleCategory extends AbstractEntity {

    private String articleId;
    private String categoryId;


}
