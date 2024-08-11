package org.example.blogsiteproject.domain.platform.category.web;

import lombok.RequiredArgsConstructor;
import org.example.blogsiteproject.domain.platform.category.api.CategoryMapper;
import org.example.blogsiteproject.domain.platform.category.api.CategoryService;
import org.example.blogsiteproject.library.rest.BaseController;
import org.example.blogsiteproject.library.rest.MetaResponse;
import org.example.blogsiteproject.library.rest.PageResponse;
import org.example.blogsiteproject.library.rest.Response;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController extends BaseController {

    private final CategoryService service;

    @PostMapping
    private Response<CategoryResponse> save(@RequestBody CategoryRequest request){
        return respond(CategoryMapper.toResponse(service.save(CategoryMapper.toDto(request))));
    }
    @GetMapping("/{id}")
    private Response<CategoryResponse> get(@PathVariable String id){
        return respond(CategoryMapper.toResponse(service.getById(id)));
    }
    @GetMapping
    private Response<PageResponse<CategoryResponse>> getAll(Pageable pageable){
        return respond(CategoryMapper.toPageResponse(service.getAll(pageable)));
    }
    @DeleteMapping("/{id}")
    private Response<Void> delete(@PathVariable String id){
        service.delete(id);
        return new Response<>(MetaResponse.success());
    }
    @PutMapping("/{id}")
    private Response<CategoryResponse> update(@PathVariable String id , @RequestBody CategoryRequest request){
        return respond(CategoryMapper.toResponse(service.update(id , CategoryMapper.toDto(request))));
    }
}
