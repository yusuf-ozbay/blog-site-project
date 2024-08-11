package org.example.blogsiteproject.domain.auth.auth.web;


public record RegisterRequest (
        String email,
        String password
){
}
