package org.example.blogsiteproject.domain.auth.auth.impl;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.blogsiteproject.domain.auth.auth.api.LoginDto;
import org.example.blogsiteproject.domain.auth.auth.api.RegisterDto;
import org.example.blogsiteproject.domain.auth.auth.web.LoginRequest;
import org.example.blogsiteproject.domain.auth.auth.web.RegisterRequest;
import org.example.blogsiteproject.domain.auth.user.impl.UserType;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AuthMapper {

    public static RegisterDto toRegisterDto(RegisterRequest request, UserType userType) {
        return RegisterDto.builder()
                .email(request.email())
                .password(request.password())
                .userType(userType)
                .build();
    }

    public static LoginDto toLoginDto(LoginRequest request, UserType userType) {
        return LoginDto.builder()
                .email(request.email())
                .password(request.password())
                .userType(userType)
                .build();
    }
}
