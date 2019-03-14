package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;

import com.company.dao.inter.RoleDaoInter;
import com.company.entity.Group1;
import com.company.entity.Role;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Amin Nabiyev
 */
public class RoleDaoImplJPA extends AbstractDao implements RoleDaoInter {

    @Override
    public List<Role> getAll() {
        EntityManager em = em();
        Query query = em.createQuery("select r from Role r");
        List<Role> result = query.getResultList();
        em.close();
        return result;
    }

    @Override
    public List<Role> getAll(String name) {
        EntityManager em = em();
        Query query = em.createQuery("select r from Role r where r.name=:name");
        query.setParameter("name", name);
        List<Role> result = query.getResultList();
        em.close();
        return result;
    }

    @Override
    public Role getById(int id) {
        EntityManager em = em();
        Role role = em.find(Role.class, id);
        em.close();
        return role;
    }

    @Override
    public void add(Role r) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Role r) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(r);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remove(Role r) {
        EntityManager em=em();
        Role role=em.find(Role.class, r.getId());
        em.getTransaction().begin();
        em.remove(role);
        em.getTransaction().commit();
        em.close();
    }

}
