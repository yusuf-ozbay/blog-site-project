package org.example.blogsiteproject.domain.platform.category.impl;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.example.blogsiteproject.library.rest.AbstractEntity;

@Entity
@Setter
@Getter
public class Category extends AbstractEntity {
    private String name;
}
