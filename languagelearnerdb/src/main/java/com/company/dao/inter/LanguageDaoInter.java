package com.company.dao.inter;

import com.company.entity.Language;
import java.util.List;

/**
 *
 * @author Amin Nabiyev
 */
public interface LanguageDaoInter {

    public List<Language> getAll();
    public List<Language> getAll(String name);
    public Language getById(int id);
    public void add(Language l);
    public void update(Language l);
    public void remove(Language l);
    
}
