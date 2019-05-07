package com.company.service;

import com.company.entity.User;

import java.util.List;

public interface UserServiceInter {
    public List<User> getAll();

    public User getById(int id);

    public List<User> getAll(String name);

    public void add(User u);

    public void update(User u);

    public void remove(User u);

    public User getByEmail(String email);
}
