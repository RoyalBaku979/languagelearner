
package com.company.dao.inter;

import com.company.entity.UserLanguage;

/**
 *
 * @author Amin Nabiyev
 */
public interface UserLanguageDaoInter {
    
     public UserLanguage getByUserId(int userId);
     public void add(UserLanguage u);
     public void update(UserLanguage u);
     public void remove(UserLanguage u);
     
    
}
