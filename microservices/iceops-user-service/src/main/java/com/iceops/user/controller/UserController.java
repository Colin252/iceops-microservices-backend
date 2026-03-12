package com.iceops.user.controller;

import com.iceops.user.entity.UserEntity;
import com.iceops.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserEntity> users() {
        return service.getUsers();
    }

    @GetMapping("/{id}")
    public UserEntity getUser(@PathVariable Long id) {
        return service.getUser(id);
    }

}