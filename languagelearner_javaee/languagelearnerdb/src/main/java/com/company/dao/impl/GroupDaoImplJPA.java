package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.GroupDaoInter;
import com.company.entity.Group1;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Amin Nabiyev
 */
public class GroupDaoImplJPA extends AbstractDao implements GroupDaoInter {

    @Override
    public List<Group1> getAll() {
        EntityManager em = em();
        Query query = em.createQuery("select g from Group1 g");
        List<Group1> result = query.getResultList();
        em.close();
        return result;
    }

    @Override
    public List<Group1> getAll(String name) {
        EntityManager em = em();
        Query query = em.createQuery("select g from Group1 g where g.name=:name");
        query.setParameter("name", name);
        List<Group1> result = query.getResultList();
        em.close();
        return result;
    }

    @Override
    public Group1 getById(int id) {
        EntityManager em = em();
        Group1 group = em.find(Group1.class, id);
        em.close();
        return group;
    }

    @Override
    public void add(Group1 g) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(g);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Group1 g) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(g);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remove(Group1 g) {
        EntityManager em=em();
        Group1 group=em.find(Group1.class, g.getId());
        em.getTransaction().begin();
        em.remove(group);
        em.getTransaction().commit();
        em.close();
    }

}
