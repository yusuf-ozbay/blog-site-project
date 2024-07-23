package org.example.blogsiteproject.domain.auth.user.web;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
}
