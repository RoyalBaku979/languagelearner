
package com.company.dao.inter;

import com.company.entity.Wordlist;

import java.util.List;

/**
 *
 * @author Amin Nabiyev
 */
public interface WordlistDaoInter {
    
    public List<Wordlist> getAll();
    public List<Wordlist> getByUserId(int importUserId);
    public Wordlist getById(int id);
    public void add(Wordlist wordList);
    public void update(Wordlist wordList);
    public void remove(Wordlist wordList);
    
}
