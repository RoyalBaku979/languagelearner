package com.company;

import com.company.dao.impl.UserDaoImplJDBC;
import com.company.dao.impl.UserDaoImplJPA;
import com.company.dao.inter.UserDaoInter;

public class Context {

    public static UserDaoInter instanceDao(){
        return new UserDaoImplJPA();
    }
}
