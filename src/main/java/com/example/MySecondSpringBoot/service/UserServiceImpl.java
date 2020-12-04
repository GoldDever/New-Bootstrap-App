package com.example.MySecondSpringBoot.service;

import com.example.MySecondSpringBoot.dao.UserDao;
import com.example.MySecondSpringBoot.model.Role;
import com.example.MySecondSpringBoot.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findById(long id) {
        return userDao.getById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.getAll();
    }

    @Override
    @Transactional
    public void save(User user) {
        User user1 = allRoles(user);
        userDao.save(user1);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        userDao.remove(id);
    }

    @Override
    @Transactional
    public void update(long id, User user) {
        User user1 = allRoles(user);
        userDao.update(id, user1);
    }

    @Override
    public User getUserByUserName(String name) {
        return userDao.getUserByUserName(name);
    }

    public User allRoles(User user) {
        Set<Role> set = user.getRoles();
        Set<Role> set1 = new HashSet<>();
        for (Role r: set) {
            set1.add(userDao.findRoleByName(r.getRole()));
        }
        user.setRoles(set1);
        return user;
    }
}

