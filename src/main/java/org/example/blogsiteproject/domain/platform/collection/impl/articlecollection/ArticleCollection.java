package org.example.blogsiteproject.domain.platform.collection.impl.articlecollection;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.example.blogsiteproject.library.rest.AbstractEntity;

@Entity
@Setter
@Getter
public class ArticleCollection extends AbstractEntity {

    private String collectionId;
    private String articleId;

}
