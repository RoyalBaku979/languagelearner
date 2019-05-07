package com.company.dao.impl;

import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository("userDao")
@Primary
@Transactional
public class UserDaoCustomImpl implements UserDaoCustom {

    @Autowired
    EntityManager em;

    @Override
//    @Cacheable(value="users")
    public List<User> getAll() {
        Query query = em.createQuery("select u from User u");//JPQL
        List<User> list = query.getResultList();//sql
        return list;
    }

    @Override
    public List<User> getAll(String name) {

//        Query query = em.createNativeQuery("select * from user where name = ?");
//        query.setParameter(1, name);
        Query query = em.createQuery("select u from User u where u.name = :name");
        query.setParameter("name", name);
        List<User> list = query.getResultList();//sql

        return list;
    }

    @Override
    public User getById(int id) {
        User user = em.find(User.class, id);

        return user;
    }

    @Override
    public void add(User u) {
        em.persist(u);//
    }

    @Override
    public void update(User u) {
        em.merge(u);//
    }

    @Override
    @CachePut(value = "users", key="#u.id")
    public void remove(User u) {
        User u2 = em.find(User.class, u.getId());
        em.remove(u2);//
    }

    @Override
    public User getByEmail(String email) {
        Query query = em.createQuery("select u from User u where u.email = :email");
        query.setParameter("email", email);
        List<User> list = query.getResultList();//sql

        if(list.size()>0){
            return list.get(0);
        }
        return null;
    }
}
