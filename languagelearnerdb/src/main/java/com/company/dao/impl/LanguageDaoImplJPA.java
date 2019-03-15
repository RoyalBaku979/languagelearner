package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.LanguageDaoInter;
import com.company.entity.Language;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Amin Nabiyev
 */
public class LanguageDaoImplJPA extends AbstractDao implements LanguageDaoInter {

    @Override
    public List<Language> getAll() {
        EntityManager em = em();
        Query query = em.createQuery("select l from Language l");
        List<Language> result = query.getResultList();
        em.close();
        return result;
    }

    @Override
    public List<Language> getAll(String name) {
        EntityManager em = em();
        Query query = em.createQuery("select l from Language l where l.name=:name");
        query.setParameter("name", name);
        List<Language> result = query.getResultList();
        em.close();
        return result;
    }

    @Override
    public Language getById(int id) {
        EntityManager em = em();
        Language language=em.find(Language.class, id);
        em.close();
        return language;
        
    }

    @Override
    public void add(Language l) {
        EntityManager em=em();
        em.getTransaction().begin();
        em.persist(l);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Language l) {
        EntityManager em=em();
        em.getTransaction().begin();
        em.merge(l);
        em.getTransaction().commit();
        em.close();
        
    }

    @Override
    public void remove(Language l) {
        EntityManager em=em();
        Language language=em.find(Language.class, l.getId());
        em.getTransaction().begin();
        em.remove(language);
        em.getTransaction().commit();
        em.close();
    }

}
