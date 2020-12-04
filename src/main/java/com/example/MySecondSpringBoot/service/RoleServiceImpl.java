package com.example.MySecondSpringBoot.service;



import com.example.MySecondSpringBoot.dao.RoleDao;
import com.example.MySecondSpringBoot.model.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;

    @Override
    public Set<Role> getAll() {
        return roleDao.getAll();
    }

    @Override
    public Role getById(long id) {
        return roleDao.getById(id);
    }

    @Override
    @Transactional
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    @Transactional
    public void remove(long id) {
        roleDao.remove(id);
    }


}


