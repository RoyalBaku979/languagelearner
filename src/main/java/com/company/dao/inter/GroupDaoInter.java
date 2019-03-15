
package com.company.dao.inter;

import com.company.entity.Group1;
import java.util.List;

/**
 *
 * @author Amin Nabiyev
 */
public interface GroupDaoInter {

    public List<Group1> getAll();
    public List<Group1> getAll(String name);
    public Group1 getById(int id);
    public void add(Group1 g);
    public void update(Group1 g);
    public void remove(Group1 g);

}
