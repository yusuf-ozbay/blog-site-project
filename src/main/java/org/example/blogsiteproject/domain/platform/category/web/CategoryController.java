package org.example.blogsiteproject.domain.platform.category.web;

import lombok.RequiredArgsConstructor;
import org.example.blogsiteproject.domain.platform.category.api.CategoryMapper;
import org.example.blogsiteproject.domain.platform.category.api.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping
    private CategoryResponse save(@RequestBody CategoryRequest request){
        return CategoryMapper.toResponse(service.save(CategoryMapper.toDto(request)));
    }
    @GetMapping("/{id}")
    private CategoryResponse get(@PathVariable String id){
        return CategoryMapper.toResponse(service.getById(id));
    }
    @GetMapping
    private List<CategoryResponse> getAll(){
        return CategoryMapper.toResponses(service.getAll());
    }
    @DeleteMapping("/{id}")
    private void delete(@PathVariable String id){
        service.delete(id);
    }
    @PutMapping("/{id}")
    private CategoryResponse update(@PathVariable String id , @RequestBody CategoryRequest request){
        return CategoryMapper.toResponse(service.update(id , CategoryMapper.toDto(request)));
    }
}
