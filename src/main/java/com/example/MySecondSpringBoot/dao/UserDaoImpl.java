package com.example.MySecondSpringBoot.dao;

import com.example.MySecondSpringBoot.model.Role;
import com.example.MySecondSpringBoot.model.User;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao{


    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        return entityManager.createQuery
                ("select u from User u", User.class).getResultList();
    }

    @Override
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(long id, User updatedUser) {
        entityManager.merge(updatedUser);
    }

    @Override
    public void remove(long id) {
        User user = getById(id);
        entityManager.remove(user);
    }

    @Override
    public User getUserByUserName(String login) {
        Query q = (Query) entityManager.createQuery("SELECT u FROM User u WHERE u.login=:name");
        q.setParameter("name", login);
        User user = (User) q.getSingleResult();
        return user;
    }

    @Override
    public Role findRoleByName(String role) {
        TypedQuery<Role> q =  entityManager.createQuery("SELECT r FROM Role r WHERE r.role=:name", Role.class);
        q.setParameter("name", role);
        Role s = q.getSingleResult();
        return s;
    }
}

