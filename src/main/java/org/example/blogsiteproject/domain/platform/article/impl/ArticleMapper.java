package org.example.blogsiteproject.domain.platform.article.impl;

import org.example.blogsiteproject.domain.auth.user.api.UserDto;
import org.example.blogsiteproject.domain.platform.article.api.ArticleDto;
import org.example.blogsiteproject.domain.platform.category.api.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.List;

public class ArticleMapper {
    public ArticleMapper() {
    }

    public static ArticleDto toDto(Article article, UserDto userDto, CategoryDto categoryDto) {
        return ArticleDto.builder()
                .title(article.getTitle())
                .content(article.getContent())
                .id(article.getId())
                .modified(article.getModified())
                .created(article.getCreated())
                .user(userDto)
                .category(categoryDto)
                .likeCount(article.getLikeCount())
                .build();
    }

    public static Article toEntity(Article article, ArticleDto dto) {
        article.setCategoryId(dto.getCategory().getId());
        article.setUserId(dto.getUser().getId());
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
        article.setLikeCount(dto.getLikeCount());
        return article;
    }


    public static ArticleDto toDto(Article article, List<UserDto> userDtoList, List<CategoryDto> categoryDtoList) {

        // `article` nesnesindeki `userId`'nin boş ya da null olup olmadığını kontrol eder.
        // Eğer `userId` doluysa (yani, bir değeri varsa), işlem devam eder; aksi takdirde `null` döner.
        UserDto userDto = StringUtils.hasLength(article.getUserId()) ?
                // Eğer `userId` varsa, `userDtoList` listesini stream olarak kullanır.
                userDtoList.stream()
                        // `filter` metodu, listedeki her bir `UserDto` nesnesini kontrol eder.
                        // Bu kontrol, `UserDto`'nun `id` alanının, `article.getUserId()` ile eşleşip eşleşmediğini kontrol eder.
                        .filter(c -> c.getId().equals(article.getUserId()))
                        // İlk bulunan eşleşmeyi alır (`findFirst`).
                        // Eğer eşleşen bir öğe bulunamazsa, `orElseThrow()` metodu bir istisna (exception) fırlatır.
                        .findFirst()
                        .orElseThrow()
                // Eğer `userId` boş ya da null ise, `null` döndürür.
                : null;

        CategoryDto categoryDto =  StringUtils.hasLength(article.getCategoryId()) ?
                categoryDtoList.stream()
                        .filter(c-> c.getId().equals(article.getCategoryId()))
                        .findFirst()
                        .orElseThrow()
                :null;

        return ArticleDto.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .created(article.getCreated())
                .modified(article.getModified())
                .likeCount(article.getLikeCount())
                .user(userDto)
                .category(categoryDto)
                .build();
    }

}
