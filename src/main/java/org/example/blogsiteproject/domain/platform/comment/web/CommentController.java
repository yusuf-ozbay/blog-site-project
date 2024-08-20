package org.example.blogsiteproject.domain.platform.comment.web;

import lombok.RequiredArgsConstructor;
import org.example.blogsiteproject.domain.platform.comment.api.CommentMapper;
import org.example.blogsiteproject.domain.platform.comment.api.CommentService;
import org.example.blogsiteproject.library.rest.BaseController;
import org.example.blogsiteproject.library.rest.MetaResponse;
import org.example.blogsiteproject.library.rest.PageResponse;
import org.example.blogsiteproject.library.rest.Response;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("comments")
public class CommentController extends BaseController {

    private final CommentService service;

    @PostMapping("create")
    private Response<CommentResponse> save(@RequestBody CommentRequest request){
        return respond(CommentMapper.toResponse(service.save(CommentMapper.toDto(request))));
    }
    @GetMapping("/{id}")
    private Response<CommentResponse> get(@PathVariable String id){
        return respond(CommentMapper.toResponse(service.getById(id)));
    }
    @GetMapping
    private Response<PageResponse<CommentResponse>> getAll(Pageable pageable){
        return respond(CommentMapper.toPageResponse(service.getAll(pageable)));
    }
    @DeleteMapping("/{id}")
    private Response<Void> delete(@PathVariable String id){
        service.delete(id);
        return new Response<>(MetaResponse.success());
    }

}
