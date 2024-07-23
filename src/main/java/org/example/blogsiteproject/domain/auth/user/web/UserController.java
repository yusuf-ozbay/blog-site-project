package org.example.blogsiteproject.domain.auth.user.web;

import lombok.RequiredArgsConstructor;
import org.example.blogsiteproject.domain.auth.user.api.UserMapper;
import org.example.blogsiteproject.domain.auth.user.api.UserService;
import org.example.blogsiteproject.library.rest.BaseController;
import org.example.blogsiteproject.library.rest.MetaResponse;
import org.example.blogsiteproject.library.rest.PageResponse;
import org.example.blogsiteproject.library.rest.Response;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController extends BaseController {

    private final UserService userService;

    @PostMapping
    private Response<UserResponse> save(@RequestBody UserRequest request){
        return respond(UserMapper.toResponse(userService.save(UserMapper.toDto(request))));
    }
    @GetMapping("/{id}")
    private Response<UserResponse> get(@PathVariable("id") String id){
        return respond(UserMapper.toResponse(userService.getById(id)));
    }
    @GetMapping
    private Response<PageResponse<UserResponse>> getAll(Pageable pageable){
        return respond(UserMapper.toPageResponse(userService.getAll(pageable)));
    }
    @DeleteMapping("/{id}")
    private Response<Void> delete(@PathVariable("id") String id){
        userService.delete(id);
        return new Response<>(MetaResponse.success());
    }
    @PutMapping("/{id}")
    private Response<UserResponse> update(@PathVariable("id") String id , @RequestBody UserRequest request){
        return respond(UserMapper.toResponse(userService.update(id , UserMapper.toDto(request))));
    }


}
