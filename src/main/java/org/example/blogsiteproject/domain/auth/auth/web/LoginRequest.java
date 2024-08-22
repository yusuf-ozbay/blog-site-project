package org.example.blogsiteproject.domain.auth.auth.web;


public record LoginRequest (
        String email,
        String password
) {
}

//otomatik olarak bazı meotları oluşturuyor
//record'un bu sınıfta kullanılmasının ana nedeni, LoginRequest gibi sınıfların çoğunlukla veri taşıma amacıyla oluşturulmasıdır.
// LoginRequest sınıfı sadece iki temel alan (email ve password) içerir ve bu verileri taşımaktan başka bir işlevi yoktur