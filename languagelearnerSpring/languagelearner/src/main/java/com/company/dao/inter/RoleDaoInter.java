
package com.company.dao.inter;

import com.company.entity.Role;

import java.util.List;

/**
 *
 * @author Amin Nabiyev
 */
public interface RoleDaoInter {
     public List<Role> getAll();
    public List<Role> getAll(String name);
    public Role getById(int id);
    public void add(Role r);
    public void update(Role r);
    public void remove(Role r);
}
