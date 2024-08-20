package org.example.blogsiteproject.domain.platform.follow.impl;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.example.blogsiteproject.library.rest.AbstractEntity;

@Getter
@Setter
@Entity
public class Follow extends AbstractEntity {
    private String followerId; //relation to user
    private String userId; //relation to user
}
