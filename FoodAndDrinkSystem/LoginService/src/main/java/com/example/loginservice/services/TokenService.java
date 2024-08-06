package com.example.loginservice.services;

import com.example.loginservice.modal.Token;

public interface TokenService {
    Token createToken(Token token);

    Token findByToken(String token);
}

