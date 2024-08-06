/*
 * @ (#) UserController.java     1.0     5/26/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved
 */
package com.example.userservice.controllers;

import com.example.userservice.models.User;
import com.example.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * @description:
 * @author: Huynh Minh Thu
 * @date: 2:08 AM 5/26/2024
 * @version: 1.0
 *
 */
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    User getUserById(Long id){
        return userService.getUserById(id);
    }

//    @GetMapping("/users")
//    User createUser(User user){
//        return userService.createUser(user);
//    }

    @PostMapping("/users")
    User updateUser(User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(Long id){
        userService.deleteUser(id);
    }

}
