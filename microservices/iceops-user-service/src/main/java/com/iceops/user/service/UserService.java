package com.iceops.user.service;

import com.iceops.user.entity.UserEntity;
import com.iceops.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserEntity> getUsers() {
        return repository.findAll();
    }

    public UserEntity getUser(Long id) {
        return repository.findById(id).orElse(null);
    }

}