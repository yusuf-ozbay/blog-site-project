package org.example.blogsiteproject.domain.platform.collection.web;

import lombok.RequiredArgsConstructor;
import org.example.blogsiteproject.domain.platform.collection.api.CollectionMapper;
import org.example.blogsiteproject.domain.platform.collection.api.CollectionService;

import org.example.blogsiteproject.library.rest.BaseController;
import org.example.blogsiteproject.library.rest.MetaResponse;
import org.example.blogsiteproject.library.rest.PageResponse;
import org.example.blogsiteproject.library.rest.Response;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("collections")
public class CollectionController  extends BaseController {

    private final CollectionService service;

    @PostMapping
    private Response<CollectionResponse> save(@RequestBody CollectionRequest request){
        return respond(CollectionMapper.toResponse(service.save(CollectionMapper.toDto(request))));
    }

    @GetMapping("/{id}")
    private Response<CollectionResponse> get(@PathVariable String id){
        return respond(CollectionMapper.toResponse(service.getById(id)));
    }
    @GetMapping
    private Response<PageResponse<CollectionResponse>> getAll(Pageable pageable){
        return respond(CollectionMapper.toPageResponse(service.getAll(pageable)));
    }
    @DeleteMapping("/{id}")
    private Response<Void> delete(@PathVariable String id){
        service.delete(id);
        return new Response<>(MetaResponse.success());
    }
    @PutMapping("/{id}")
    private Response<CollectionResponse> update(@PathVariable String id , @RequestBody CollectionRequest request){
        return respond(CollectionMapper.toResponse(service.update(id , CollectionMapper.toDto(request))));
    }

    @PostMapping("/articles")
    private Response<CollectionResponse> addArticle(@RequestBody AddArticleToCollectionRequest request){
        service.addArticle(CollectionMapper.toDto(request));
        return new Response<>(MetaResponse.success());
    }

}
