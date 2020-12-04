package com.example.MySecondSpringBoot.dao;

import com.example.MySecondSpringBoot.model.Role;
import com.example.MySecondSpringBoot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    User getById(long id);
    void save(User user);
    void remove(long id);
    void update(long id, User user);
    User getUserByUserName(String name);
    Role findRoleByName(String role);
}
