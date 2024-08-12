package org.example.blogsiteproject.domain.platform.comment.impl;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;
import org.example.blogsiteproject.library.rest.AbstractEntity;

@Entity
@Setter
@Getter
public class Comment extends AbstractEntity {

    @Lob // Uzun yorumların da yazılabilmesi için bu anotasyon kullanılır
    @Column(length = 1000) // Yorumun en fazla 1000 karakter uzunluğunda olması gerekiyor
    private String content;

    private String userId;
    private String articleId;
}
