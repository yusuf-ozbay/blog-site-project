package org.example.blogsiteproject.domain.platform.follow.web;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.blogsiteproject.domain.auth.user.api.UserDto;

import java.util.Date;
@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class FollowResponse {

    private final String id;
    private final Date created;
    private final Date modified;
    private final UserDto follower;
    private final UserDto user;
    private final int count;
}
