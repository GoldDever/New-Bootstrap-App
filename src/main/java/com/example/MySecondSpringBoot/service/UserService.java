package com.example.MySecondSpringBoot.service;

import com.example.MySecondSpringBoot.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(long id);
    void save(User user);
    void deleteById(long id);
    void update(long id, User user);
    User getUserByUserName(String name);
}
