package org.example.blogsiteproject.domain.auth.user.web;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.blogsiteproject.domain.auth.user.impl.UserType;

import java.util.Date;

@Getter
@Setter
@Builder
@RequiredArgsConstructor
public class UserResponse {
    private final String id;
    private final String userName;
    private final Date created;
    private final Date modified;
    private final String email;
    private final String password;
    private final String phoneNumber;
    private final UserType userType;
    private final Boolean active;
}
