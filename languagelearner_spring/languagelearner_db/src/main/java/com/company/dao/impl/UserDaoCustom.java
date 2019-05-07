package com.company.dao.impl;


import com.company.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserDaoCustom {

    public List<User> getAll();

    public User getById(int id);

    public List<User> getAll(String name);

    public void add(User u);

    public void update(User u);

    public void remove(User u);

    public User getByEmail(String email);
}
