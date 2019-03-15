
package com.company.dao.inter;

import com.company.entity.GroupRole;
import java.util.List;

/**
 *
 * @author Amin Nabiyev
 */
public interface GroupRoleDaoInter {
     public GroupRole getById(int id);
     public List<GroupRole> getByGroupId(int groupId);
     public List<GroupRole> getByGroupIdAndRoleId(int groupId,int roleId);
     public void add(GroupRole g);
     public void update(GroupRole g);
     public void remove(GroupRole g);
}
