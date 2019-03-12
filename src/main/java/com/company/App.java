package com.company;

import com.company.dao.inter.UserDaoInter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        
        UserDaoInter userDao = Context.instanceDao();//
        
        userDao.getAll();
    }
}
