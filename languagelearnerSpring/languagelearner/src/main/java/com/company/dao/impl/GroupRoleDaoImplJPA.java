//package com.company.dao.impl;
//
//import com.company.dao.inter.GroupRoleDaoInter;
//import com.company.entity.Group1;
//import com.company.entity.GroupRole;
//import com.company.entity.Role;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//import java.util.List;
//
///**
// *
// * @author Amin Nabiyev
// */
//public class GroupRoleDaoImplJPA extends AbstractDao implements GroupRoleDaoInter {
//
//    @Override
//    public GroupRole getById(int id) {
//        EntityManager em = em();
//        GroupRole result = em.find(GroupRole.class, id);
//        return result;
//
//    }
//
//    @Override
//    public List<GroupRole> getByGroupIdAndRoleId(int groupId, int roleId) {
//        EntityManager emGroup = em();
//        EntityManager emRole = em();
//        EntityManager em = em();
//
//        Group1 group=emGroup.find(Group1.class, groupId);
//        Role role =emRole.find(Role.class,roleId);
//        Query query = em.createQuery("select g from GroupRole g where g.groupId=:groupId and g.roleId=:roleId");
//        query.setParameter("groupId", group);
//        query.setParameter("roleId", role);
//        return query.getResultList();
//
//    }
//
//    @Override
//    public List<GroupRole> getByGroupId(int groupId) {
//        EntityManager emGroup = em();
//        EntityManager em = em();
//        Query query = em.createQuery("select g from GroupRole g where g.groupId=:groupId");
//        Group1 g = emGroup.find(Group1.class, groupId);
//        query.setParameter("groupId", g);
//        List<GroupRole> result = query.getResultList();
//        return result;
//
//    }
//
//    @Override
//    public void add(GroupRole g) {
//        EntityManager em = em();
//        em.getTransaction().begin();
//        em.persist(g);
//        em.getTransaction().commit();
//        em.close();
//    }
//
//    @Override
//    public void update(GroupRole g) {
//        EntityManager em = em();
//        em.getTransaction().begin();
//        em.merge(g);
//        em.getTransaction().commit();
//        em.close();
//
//    }
//
//    @Override
//    public void remove(GroupRole g) {
//        EntityManager em = em();
//        em.getTransaction().begin();
//        GroupRole gr = em.find(GroupRole.class, g.getId());
//        em.remove(gr);
//        em.getTransaction().commit();
//        em.close();
//    }
//}
