package org.example.blogsiteproject.domain.auth.auth.impl;

import lombok.RequiredArgsConstructor;
import org.example.blogsiteproject.domain.auth.auth.api.LoginDto;
import org.example.blogsiteproject.domain.auth.auth.api.RegisterDto;
import org.example.blogsiteproject.domain.auth.auth.api.TokenDto;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl {

    public TokenDto register(RegisterDto registerDto) {
        return null;
    }

    public TokenDto login(LoginDto loginDto){
        return null;
    }

}
