package org.example.blogsiteproject.domain.platform.article.web;

import lombok.RequiredArgsConstructor;

import org.example.blogsiteproject.domain.platform.article.api.ArticleMapper;
import org.example.blogsiteproject.domain.platform.article.api.ArticleService;
import org.example.blogsiteproject.library.rest.BaseController;
import org.example.blogsiteproject.library.rest.MetaResponse;
import org.example.blogsiteproject.library.rest.PageResponse;
import org.example.blogsiteproject.library.rest.Response;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("articles")
@RequiredArgsConstructor
public class ArticleController extends BaseController {

    private final ArticleService service;
    @PostMapping("create")
    private Response<ArticleResponse> save(@RequestBody ArticleRequest request){
        return respond(ArticleMapper.toResponse(service.save(ArticleMapper.toDto(request))));
    }

    @GetMapping("/{id}")
    private Response<ArticleResponse> get(@PathVariable("id") String id){
        return respond(ArticleMapper.toResponse(service.getById(id)));
    }
    @GetMapping
    private Response<PageResponse<ArticleResponse>> getAll(Pageable pageable){
        return respond(ArticleMapper.toPageResponse(service.getAll(pageable)));
    }
    @DeleteMapping("/{id}")
    private Response<Void> delete(@PathVariable("id") String id){
        service.delete(id);
        return new Response(MetaResponse.success());
    }
    @PutMapping("/{id}")
    private Response<ArticleResponse> update(@PathVariable("id") String id , @RequestBody ArticleRequest request){
        return respond(ArticleMapper.toResponse(service.update(id , ArticleMapper.toDto(request))));
    }
}
