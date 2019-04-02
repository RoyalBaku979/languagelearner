package com.company.entity;

import com.company.entity.GroupRole;
import com.company.entity.GroupUser;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-02T21:27:47")
@StaticMetamodel(Group1.class)
public class Group1_ { 

    public static volatile ListAttribute<Group1, GroupRole> groupRoleList;
    public static volatile SingularAttribute<Group1, String> name;
    public static volatile ListAttribute<Group1, GroupUser> groupUserList;
    public static volatile SingularAttribute<Group1, Integer> id;

}