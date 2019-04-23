///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.company.dao.impl;
//
//import com.company.dao.inter.WordlistDaoInter;
//import com.company.entity.User;
//import com.company.entity.Wordlist;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//import java.util.List;
//
///**
// *
// * @author Amin Nabiyev
// */
//public class WordlistDaoImplJPA  implements WordlistDaoInter {
//
//    @Override
//    public List<Wordlist> getAll() {
//        EntityManager em = em();
//        Query query = em.createQuery("Select w from Wordlist w");
//        List<Wordlist> result = query.getResultList();
//        em.close();
//        return result;
//
//    }
//
//    @Override
//    public List<Wordlist> getByUserId(int importUserId) {
//        EntityManager emUser = em();
//        EntityManager em = em();
//        User user = emUser.find(User.class, importUserId);
//        Query query = em.createQuery("select w from Wordlist w where w.importUserId=:importUserId");
//        query.setParameter("importUserId", user);
//        List<Wordlist> result = query.getResultList();
//        emUser.close();
//        em.close();
//        return result;
//    }
//
//    @Override
//    public Wordlist getById(int id) {
//        EntityManager em = em();
//        Wordlist wList = em.find(Wordlist.class, id);
//        em.close();
//        return wList;
//
//    }
//
//    @Override
//    public void add(Wordlist wordList) {
//        EntityManager em = em();
//        em.getTransaction().begin();
//        em.persist(wordList);
//        em.getTransaction().commit();
//        em.close();
//    }
//
//    @Override
//    public void update(Wordlist wordList) {
//        EntityManager em = em();
//        em.getTransaction().begin();
//        em.merge(wordList);
//        em.getTransaction().commit();
//        em.close();
//    }
//
//    @Override
//    public void remove(Wordlist wordList) {
//        EntityManager em = em();
//        em.getTransaction().begin();
//        Wordlist wList = em.find(Wordlist.class, wordList.getId());
//        em.remove(wList);
//        em.getTransaction().commit();
//        em.close();
//    }
//
//}
