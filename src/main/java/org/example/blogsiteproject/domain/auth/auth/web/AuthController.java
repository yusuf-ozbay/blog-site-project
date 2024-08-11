package org.example.blogsiteproject.domain.auth.auth.web;

import lombok.RequiredArgsConstructor;
import org.example.blogsiteproject.domain.auth.auth.api.TokenDto;
import org.example.blogsiteproject.domain.auth.auth.impl.AuthMapper;
import org.example.blogsiteproject.domain.auth.auth.impl.AuthServiceImpl;
import org.example.blogsiteproject.domain.auth.user.impl.UserType;
import org.example.blogsiteproject.library.rest.BaseController;
import org.example.blogsiteproject.library.rest.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("auths")
public class AuthController extends BaseController {

    private final AuthServiceImpl service;

    @PostMapping("register")
    public Response<TokenDto> register(@RequestBody RegisterRequest request){
        return respond(service.register(AuthMapper.toRegisterDto(request, UserType.USER)));
    }

    @PostMapping("login")
    public Response<TokenDto> login(@RequestBody LoginRequest request){
        return respond(service.login(AuthMapper.toLoginDto(request,UserType.USER)));
    }

    @PostMapping("admin-login")
    public Response<TokenDto> adminLogin(@RequestBody LoginRequest request){
        return respond(service.login(AuthMapper.toLoginDto(request,UserType.ADMIN)));
    }
}
