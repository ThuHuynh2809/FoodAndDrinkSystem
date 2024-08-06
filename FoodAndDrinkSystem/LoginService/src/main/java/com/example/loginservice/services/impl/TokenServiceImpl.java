package com.example.loginservice.services.impl;

import com.example.loginservice.modal.Token;
import com.example.loginservice.repositories.TokenRepository;
import com.example.loginservice.services.TokenService;
import com.example.loginservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public Token createToken(Token token){
        return tokenRepository.saveAndFlush(token);
    }

    @Override
    public Token findByToken(String token){
        return tokenRepository.findByToken(token);
    }
}
