package org.example.blogsiteproject.domain.platform.collection.impl;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.example.blogsiteproject.library.rest.AbstractEntity;

@Setter
@Getter
@Entity
public class Collection extends AbstractEntity {

    private String name;
    private String userId;

}
