package com.company.dao.inter;


import com.company.entity.User;

import java.util.List;

public interface UserDaoInter {

    public List<User> getAll();

    public User getById(int id);

    public List<User> getAll(String name);

    public void add(User u);

    public void update(User u);

    public void remove(User u);

    public User getByEmail(String email);
}
