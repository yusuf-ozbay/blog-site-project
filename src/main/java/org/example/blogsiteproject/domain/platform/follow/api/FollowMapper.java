package org.example.blogsiteproject.domain.platform.follow.api;

import org.example.blogsiteproject.domain.auth.user.api.UserDto;
import org.example.blogsiteproject.domain.platform.follow.web.FollowRequest;
import org.example.blogsiteproject.domain.platform.follow.web.FollowResponse;
import org.example.blogsiteproject.library.utils.PageUtil;
import org.springframework.data.domain.Page;

public class FollowMapper {

    public static FollowDto toDto(FollowRequest request) {
        return FollowDto.builder()
                .user(UserDto.builder().id(request.getUserId()).build())
                .follower(UserDto.builder().id(request.getFollowerId()).build())
                .build();
    }

    public static FollowResponse toResponse(FollowDto dto) {
        return FollowResponse.builder()
                .user(dto.getUser())
                .follower(dto.getFollower())
                .count(dto.getCount())
                .created(dto.getCreated())
                .modified(dto.getModified())
                .id(dto.getId())
                .build();
    }

    public static Page<FollowResponse> toPageResponse(Page<FollowDto> dtos) {
        return PageUtil.pageToDto(dtos, FollowMapper::toResponse);
    }

}
