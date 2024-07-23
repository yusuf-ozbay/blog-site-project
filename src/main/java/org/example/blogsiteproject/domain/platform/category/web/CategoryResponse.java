package org.example.blogsiteproject.domain.platform.category.web;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class CategoryResponse {
    private final String id;
    private final String name;
}
