package org.example.blogsiteproject.domain.auth.user.api;

import org.example.blogsiteproject.domain.auth.user.impl.User;
import org.example.blogsiteproject.domain.auth.user.web.UserRequest;
import org.example.blogsiteproject.domain.auth.user.web.UserResponse;
import org.example.blogsiteproject.library.rest.MetaResponse;
import org.example.blogsiteproject.library.utils.PageUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.support.PageableUtils;

public class UserMapper {

    public UserMapper(){

    }

    public static UserDto toDto(UserRequest request){
        return UserDto.builder()
                .userName(request.getUserName())
                .phoneNumber(request.getPhoneNumber())
                .password(request.getPassword())
                .email(request.getEmail())
                .userName(request.getUserName())
                .build();
    }

    public static UserResponse toResponse(UserDto dto) {
        return UserResponse.builder()
                .id(dto.getId())
                .created(dto.getCreated())
                .email(dto.getEmail())
                .userName(dto.getUserName())
                .modified(dto.getModified())
                .phoneNumber(dto.getPhoneNumber())
                .password(dto.getPassword())
                .build();
    }

    public static Page<UserResponse> toPageResponse(Page<UserDto> userDtos) {
        return PageUtil.pageToDto(userDtos, UserMapper::toResponse);
    }


}
