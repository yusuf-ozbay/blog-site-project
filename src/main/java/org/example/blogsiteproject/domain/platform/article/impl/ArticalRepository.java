package org.example.blogsiteproject.domain.platform.article.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticalRepository extends JpaRepository<Article,String> {

    Optional<Article> findByUserIdAndCategoryId(String id, String id1);

}
