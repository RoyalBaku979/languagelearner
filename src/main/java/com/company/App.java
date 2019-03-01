package com.company;

import com.company.dao.inter.UserDaoInter;
import com.company.entity.User;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        UserDaoInter userDao = Context.instanceDao();
        User u= userDao.getById(3);
        System.out.println("Elvida, "+u.getName()+"!!!!");

        userDao.remove(u);
    }
}
