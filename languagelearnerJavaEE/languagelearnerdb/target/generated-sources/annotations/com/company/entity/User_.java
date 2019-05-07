package com.company.entity;

import com.company.entity.GroupUser;
import com.company.entity.UserLanguage;
import com.company.entity.Wordlist;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-02T21:27:47")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> surname;
    public static volatile SingularAttribute<User, String> name;
    public static volatile ListAttribute<User, Wordlist> wordlistList;
    public static volatile SingularAttribute<User, Boolean> active;
    public static volatile ListAttribute<User, GroupUser> groupUserList;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile ListAttribute<User, UserLanguage> userLanguageList;
    public static volatile SingularAttribute<User, String> email;

}