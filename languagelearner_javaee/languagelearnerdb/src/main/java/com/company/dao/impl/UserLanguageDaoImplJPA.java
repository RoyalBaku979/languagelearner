package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.UserLanguageDaoInter;
import com.company.entity.User;
import com.company.entity.UserLanguage;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UserLanguageDaoImplJPA extends AbstractDao implements UserLanguageDaoInter {

    @Override
    public UserLanguage getByUserId(int userId) {
        EntityManager emUser = em();
        EntityManager em = em();
        User user = emUser.find(User.class, userId);
        Query query = em.createQuery("select u from UserLanguage u where u.userId=:userId");
        query.setParameter("userId", user);
        UserLanguage userL = (UserLanguage) query.getSingleResult();
        return userL;

    }

    @Override
    public void add(UserLanguage u) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void update(UserLanguage u) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remove(UserLanguage u) {
        EntityManager em = em();
        em.getTransaction().begin();
        UserLanguage userLan=em.find(UserLanguage.class, u.getId());
        em.remove(userLan);
        em.getTransaction().commit();
        em.close();
    }

}
