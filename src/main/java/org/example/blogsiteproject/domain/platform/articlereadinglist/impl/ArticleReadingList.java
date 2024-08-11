package org.example.blogsiteproject.domain.platform.articlereadinglist.impl;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.example.blogsiteproject.library.rest.AbstractEntity;

@Entity
@Setter
@Getter
public class ArticleReadingList extends AbstractEntity {
    private  Long readingListId;
    private Long articleId;
}
