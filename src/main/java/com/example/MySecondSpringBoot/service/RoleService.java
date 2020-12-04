package com.example.MySecondSpringBoot.service;

import com.example.MySecondSpringBoot.model.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> getAll();
    Role getById(long id);
    void save(Role role);
    void remove(long id);
}
