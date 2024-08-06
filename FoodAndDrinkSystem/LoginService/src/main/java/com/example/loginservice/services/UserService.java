package com.example.loginservice.services;

import com.example.loginservice.authen.UserPrincipal;
import com.example.loginservice.modal.User;

public interface UserService {
    User createUser(User user);
    UserPrincipal findByUsername(String username);
}
