package org.example.blogsiteproject.domain.platform.follow.web;

import lombok.RequiredArgsConstructor;
import org.example.blogsiteproject.domain.platform.follow.api.FollowMapper;
import org.example.blogsiteproject.domain.platform.follow.api.FollowService;
import org.example.blogsiteproject.library.rest.BaseController;
import org.example.blogsiteproject.library.rest.MetaResponse;
import org.example.blogsiteproject.library.rest.PageResponse;
import org.example.blogsiteproject.library.rest.Response;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("follows")
public class FollowController extends BaseController {
    private final FollowService service;

    @PostMapping
    private Response<FollowResponse> save(@RequestBody FollowRequest request){
        return respond(FollowMapper.toResponse(service.save(FollowMapper.toDto(request))));
    }
    @GetMapping("/{id}")
    private Response<FollowResponse> get(@PathVariable String id){
        return respond(FollowMapper.toResponse(service.getById(id)));
    }
    @GetMapping
    private Response<PageResponse<FollowResponse>> getAll(Pageable pageable){
        return respond(FollowMapper.toPageResponse(service.getAll(pageable)));
    }
    @DeleteMapping("/{id}")
    private Response<Void> delete(@PathVariable String id){
        service.delete(id);
        return new Response<>(MetaResponse.success());
    }
}
