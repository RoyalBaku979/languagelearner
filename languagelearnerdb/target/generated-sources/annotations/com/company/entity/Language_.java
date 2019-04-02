package com.company.entity;

import com.company.entity.UserLanguage;
import com.company.entity.Wordlist;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-04-02T21:27:47")
@StaticMetamodel(Language.class)
public class Language_ { 

    public static volatile ListAttribute<Language, Wordlist> wordlistList1;
    public static volatile SingularAttribute<Language, String> name;
    public static volatile ListAttribute<Language, Wordlist> wordlistList;
    public static volatile SingularAttribute<Language, Integer> id;
    public static volatile ListAttribute<Language, UserLanguage> userLanguageList;

}