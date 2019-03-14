package com.company;

import com.company.dao.inter.UserDaoInter;
import com.company.dao.inter.WordlistDaoInter;
import com.company.entity.User;
import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.GroupDaoInter;
import com.company.dao.inter.GroupRoleDaoInter;
import com.company.dao.inter.GroupUserDaoInter;
import com.company.dao.inter.UserLanguageDaoInter;
import com.company.entity.UserLanguage;
import com.company.entity.Wordlist;
import com.company.dao.inter.LanguageDaoInter;
import com.company.dao.inter.RoleDaoInter;
import com.company.entity.Group1;
import com.company.entity.GroupRole;
import com.company.entity.GroupUser;
import com.company.entity.Language;
import com.company.entity.Role;
import java.util.List;

public class App {

    public static void main(String[] args) {

//        UserLanguageDaoInter userLanguage = Context.instanceUserLanguageDao();
//        UserDaoInter user=Context.instanceUserDao();
//        LanguageDaoInter language=Context.instanceLanguageDao();
//        User u=user.getById(2);
//        Language l=language.getById(2);
//        Wordlist word=wDao.getById(6);
//        wDao.remove(word);
//        UserLanguage ul=new UserLanguage(0,4);
//        ul.setLanguageId(l);
//        ul.setUserId(u);
//        UserLanguage ul=userLanguage.getByUserId(2);
//        ul.setLevel(3);
//        userLanguage.remove(ul);
        GroupRoleDaoInter groupRoleDao = Context.instanceGroupRoleDao();
//        System.out.println(gDao.getByGroupId(1));
//        GroupRole groupRole=new GroupRole();
//        GroupDaoInter groupDao=Context.instanceGroupDao();        
//        Group1 group=groupDao.getById(2);
//        RoleDaoInter roleDao=Context.instanceRoleDao();
//        Role role=roleDao.getById(1);
//        groupRole.setGroupId(group);
//        groupRole.setRoleId(role);
//        groupRoleDao.add(groupRole);

//        GroupRole groupRole=groupRoleDao.getById(2);
//        System.out.println(groupRole);
        
//        GroupRole groupRole = groupRoleDao.getById(5);
//        groupRoleDao.remove(groupRole);

        GroupUserDaoInter groupUserDao=Context.instanceGroupUserDao();
        GroupUser groupUser = groupUserDao.getById(3);

        groupUserDao.remove(groupUser);

        AbstractDao.closeEmf();
    }
}
