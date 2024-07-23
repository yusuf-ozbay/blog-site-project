package org.example.blogsiteproject.domain.auth.user.impl;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.blogsiteproject.library.rest.AbstractEntity;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractEntity {
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
}
