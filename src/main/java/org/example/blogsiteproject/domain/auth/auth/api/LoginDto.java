package org.example.blogsiteproject.domain.auth.auth.api;

import lombok.*;
import org.example.blogsiteproject.domain.auth.user.impl.UserType;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDto {

    private String email;
    private String password;
    private UserType userType;

}
