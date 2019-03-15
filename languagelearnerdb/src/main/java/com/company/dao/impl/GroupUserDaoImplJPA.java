
package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import static com.company.dao.inter.AbstractDao.em;
import com.company.dao.inter.GroupUserDaoInter;
import com.company.entity.Group1;
import com.company.entity.GroupUser;
import com.company.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Amin Nabiyev
 */
public class GroupUserDaoImplJPA extends AbstractDao implements GroupUserDaoInter{
    @Override
    public GroupUser getById(int id) {
        EntityManager em = em();
        GroupUser result = em.find(GroupUser.class, id);
        return result;

    }

    @Override
    public List<GroupUser> getByGroupIdAndUserId(int groupId, int userId) {
        EntityManager emGroup = em();
        EntityManager emUser = em();
        EntityManager em = em();
        
        Group1 group=emGroup.find(Group1.class, groupId);
        User user =emUser.find(User.class,userId);
        Query query = em.createQuery("select g from GroupUser g where g.groupId=:groupId and g.userId:userId");
        query.setParameter("groupId", group);
        query.setParameter("userId", user);
        return query.getResultList();

    }

    @Override
    public List<GroupUser> getByGroupId(int groupId) {
        EntityManager emGroup = em();
        EntityManager em = em();
        Query query = em.createQuery("select g from GroupUser g where g.groupId=:groupId");
        Group1 g = emGroup.find(Group1.class, groupId);
        query.setParameter("groupId", g);
        List<GroupUser> result = query.getResultList();
        return result;

    }

    @Override
    public void add(GroupUser g) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(g);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(GroupUser g) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(g);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void remove(GroupUser g) {
        EntityManager em = em();
        em.getTransaction().begin();
        GroupUser gr = em.find(GroupUser.class, g.getId());
        em.remove(gr);
        em.getTransaction().commit();
        em.close();
    }
}
