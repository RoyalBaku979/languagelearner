
package com.company.dao.inter;

import com.company.entity.GroupUser;

import java.util.List;

/**
 *
 * @author Amin Nabiyev
 */
public interface GroupUserDaoInter {
    public GroupUser getById(int id);
     public List<GroupUser> getByGroupId(int groupId);
     public List<GroupUser> getByGroupIdAndUserId(int groupId, int userId);
     public void add(GroupUser g);
     public void update(GroupUser g);
     public void remove(GroupUser g);
}
