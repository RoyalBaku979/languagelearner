package com.company.entity;

import com.company.entity.Language;
import com.company.entity.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-02T21:27:47")
@StaticMetamodel(Wordlist.class)
public class Wordlist_ { 

    public static volatile SingularAttribute<Wordlist, Date> importDate;
    public static volatile SingularAttribute<Wordlist, String> wrongCount;
    public static volatile SingularAttribute<Wordlist, String> translation;
    public static volatile SingularAttribute<Wordlist, User> importUserId;
    public static volatile SingularAttribute<Wordlist, Integer> id;
    public static volatile SingularAttribute<Wordlist, Language> wordLangId;
    public static volatile SingularAttribute<Wordlist, Language> translationLangId;
    public static volatile SingularAttribute<Wordlist, String> word;
    public static volatile SingularAttribute<Wordlist, String> rightCount;

}