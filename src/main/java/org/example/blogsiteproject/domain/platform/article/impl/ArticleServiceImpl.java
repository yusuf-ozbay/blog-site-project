package org.example.blogsiteproject.domain.platform.article.impl;

import lombok.RequiredArgsConstructor;
import org.example.blogsiteproject.domain.auth.user.api.UserDto;
import org.example.blogsiteproject.domain.auth.user.api.UserService;
import org.example.blogsiteproject.domain.platform.article.api.ArticleDto;
import org.example.blogsiteproject.domain.platform.article.api.ArticleService;
import org.example.blogsiteproject.domain.platform.category.api.CategoryDto;
import org.example.blogsiteproject.domain.platform.category.api.CategoryService;
import org.example.blogsiteproject.library.utils.PageUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ArticleServiceImpl  implements ArticleService {

    private final ArticleRepository repository;
    private final UserService userService;
    private final CategoryService categoryService;

    public final int ARTICLE_STATUS_NONE = 0;
    public final int ARTICLE_STATUS_DRAFT= 1;

    @Override
    public ArticleDto save(ArticleDto dto) {
        UserDto userDto = userService.getById(dto.getUser().getId());
        CategoryDto categoryDto = categoryService.getById(dto.getCategory().getId());

        return ArticleMapper.toDto(repository.save(ArticleMapper.toEntity(new Article(), dto)), userDto,categoryDto);
    }

    @Override
    public ArticleDto getById(String id) {
        Article article = repository.findById(id).orElseThrow();
        UserDto userDto = userService.getById(article.getUserId());
        CategoryDto categoryDto = categoryService.getById(article.getCategoryId());

        return ArticleMapper.toDto(article, userDto, categoryDto);
    }

    @Override
    public void delete(String id) {
        /*var  article = repository.findById(id).orElseThrow();
        repository.delete(article);*/
        repository.findById(id);
    }

    @Override
    public ArticleDto update(String id, ArticleDto dto) {
        // Mevcut article'ı id'ye göre bul
        Article article = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));

        // Güncellenmiş User ve Category verilerini al
        UserDto userDto = userService.getById(dto.getUser().getId());
        CategoryDto categoryDto = categoryService.getById(dto.getCategory().getId());

        // Article nesnesini DTO'dan gelen verilerle güncelle
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
        article.setLikeCount(dto.getLikeCount());
        article.setStatus(dto.getStatus());
        article.setUserId(userDto.getId());
        article.setCategoryId(categoryDto.getId());

        // Güncellenmiş article'ı kaydet ve DTO'ya dönüştürüp geri döndür
        return ArticleMapper.toDto(repository.save(article), userDto, categoryDto);
    }


    @Override
    public Page<ArticleDto> getAll(Pageable pageable) {
        return PageToDto(repository.findAll(pageable));
    }

    @Override
    public List<ArticleDto> getByIds(List<String> articalIds) {
        List<Article> articles=repository.findAllById(articalIds);
        List<CategoryDto> categoryDtoList=categoryService.getByIds(articles.stream().map(Article::getCategoryId).collect(Collectors.toList()));
        List<UserDto> userDtoList=userService.getByIds(articles.stream().map(Article::getUserId).collect(Collectors.toList()));

        return repository.findAllById(articalIds).stream().map(article -> ArticleMapper.toDto(article,userDtoList,categoryDtoList)).toList();
    }

    public Page<ArticleDto> PageToDto(Page<Article> articles){
        List<String> categoryIds = articles.stream().map(Article::getCategoryId).toList();
        List<String> userIds = articles.stream().map(Article::getUserId).toList();

        List<CategoryDto> categoryDtoList = categoryService.getByIds(categoryIds);
        List<UserDto> userDtoList = userService.getByIds(userIds);

        return PageUtil.pageToDto(articles , (article)->{
            CategoryDto categoryDto = categoryDtoList.stream().filter(category -> category.getId().equals(article.getCategoryId())).findFirst().orElseThrow();
            UserDto userDto = userDtoList.stream().filter(user -> user.getId().equals(article.getUserId())).findFirst().orElseThrow();
            return ArticleMapper.toDto(article, userDto, categoryDto);
        });
    }

}
