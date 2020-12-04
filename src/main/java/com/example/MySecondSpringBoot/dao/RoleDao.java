package com.example.MySecondSpringBoot.dao;

import com.example.MySecondSpringBoot.model.Role;

import java.util.Set;

public interface RoleDao {
    Set<Role> getAll();
    Role getById(long id);
    void save(Role role);
    void remove(long id);
}
