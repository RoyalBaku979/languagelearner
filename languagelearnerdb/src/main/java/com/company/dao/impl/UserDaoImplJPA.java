package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UserDaoImplJPA extends AbstractDao implements UserDaoInter {

    @Override
    public List<User> getAll() {
        EntityManager em = em();

        Query query = em.createQuery("select u from User u");//JPQL

        List<User> list = query.getResultList();//sql

        em.close();
        return list;
    }

    @Override
    public List<User> getAll(String name) {
        EntityManager em = em();

//        Query query = em.createNativeQuery("select * from user where name = ?");
//        query.setParameter(1, name);
        Query query = em.createQuery("select u from User u where u.name = :name");
        query.setParameter("name", name);
        List<User> list = query.getResultList();//sql

        em.close();
        return list;
    }

    @Override
    public User getById(int id) {
        EntityManager em = em();

        User user = em.find(User.class, id);

        em.close();
        return user;
    }

    @Override
    public void add(User u) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(u);//
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(User u) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(u);//
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remove(User u) {
        EntityManager em = em();
        em.getTransaction().begin();
        User u2 = em.find(User.class, u.getId());
        em.remove(u2);//
        em.getTransaction().commit();
        em.close();
    }
}
