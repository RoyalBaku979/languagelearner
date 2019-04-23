package com.company.service;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserServiceInter {

    @Autowired
    UserDaoInter userDao;//UserDaoImpl

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public List<User> getAll(String name) {
        return userDao.getAll(name);
    }

    @Override
    public void add(User u) {
        userDao.add(u);
    }

    @Override
    public void update(User u) {
        userDao.update(u);
    }

    @Override
    public void remove(User u) {
        userDao.remove(u);
    }

    @Override
    public User getByEmail(String email) {
        return userDao.getByEmail(email);
    }
}
