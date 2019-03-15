package com.company;

import com.company.dao.impl.GroupDaoImplJPA;
import com.company.dao.impl.GroupRoleDaoImplJPA;
import com.company.dao.impl.GroupUserDaoImplJPA;
import com.company.dao.impl.LanguageDaoImplJPA;
import com.company.dao.impl.RoleDaoImplJPA;
import com.company.dao.impl.UserDaoImplJDBC;
import com.company.dao.impl.UserDaoImplJPA;
import com.company.dao.impl.UserLanguageDaoImplJPA;
import com.company.dao.impl.WordlistDaoImplJPA;
import com.company.dao.inter.GroupDaoInter;
import com.company.dao.inter.GroupRoleDaoInter;
import com.company.dao.inter.GroupUserDaoInter;
import com.company.dao.inter.LanguageDaoInter;
import com.company.dao.inter.RoleDaoInter;
import com.company.dao.inter.UserDaoInter;
import com.company.dao.inter.UserLanguageDaoInter;
import com.company.dao.inter.WordlistDaoInter;

public class Context {

    public static UserDaoInter instanceUserDao() {
        return new UserDaoImplJPA();
    }

    public static GroupDaoInter instanceGroupDao() {
        return new GroupDaoImplJPA();
    }

    public static LanguageDaoInter instanceLanguageDao() {
        return new LanguageDaoImplJPA();
    }

    public static RoleDaoInter instanceRoleDao() {
        return new RoleDaoImplJPA();
    }

    public static WordlistDaoInter instanceWordlistDao() {
        return new WordlistDaoImplJPA();
    }

    public static UserLanguageDaoInter instanceUserLanguageDao() {
        return new UserLanguageDaoImplJPA();
    }

    public static GroupRoleDaoInter instanceGroupRoleDao() {
        return new GroupRoleDaoImplJPA();
    }
    
    public static GroupUserDaoInter instanceGroupUserDao(){
    return new GroupUserDaoImplJPA();
    }
}
