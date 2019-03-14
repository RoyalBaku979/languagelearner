/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sarkhanrasullu
 */
@Entity
@Table(name = "language")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Language.findAll", query = "SELECT l FROM Language l")
    , @NamedQuery(name = "Language.findById", query = "SELECT l FROM Language l WHERE l.id = :id")
    , @NamedQuery(name = "Language.findByName", query = "SELECT l FROM Language l WHERE l.name = :name")})
public class Language implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wordLangId", fetch = FetchType.LAZY)
    private List<Wordlist> wordlistList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "translationLangId", fetch = FetchType.LAZY)
    private List<Wordlist> wordlistList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "languageId", fetch = FetchType.LAZY)
    private List<UserLanguage> userLanguageList;

    public Language() {
    }

    public Language(Integer id) {
        this.id = id;
    }

    public Language(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Wordlist> getWordlistList() {
        return wordlistList;
    }

    public void setWordlistList(List<Wordlist> wordlistList) {
        this.wordlistList = wordlistList;
    }

    @XmlTransient
    public List<Wordlist> getWordlistList1() {
        return wordlistList1;
    }

    public void setWordlistList1(List<Wordlist> wordlistList1) {
        this.wordlistList1 = wordlistList1;
    }

    @XmlTransient
    public List<UserLanguage> getUserLanguageList() {
        return userLanguageList;
    }

    public void setUserLanguageList(List<UserLanguage> userLanguageList) {
        this.userLanguageList = userLanguageList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Language)) {
            return false;
        }
        Language other = (Language) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id="+id+ ", name="+name;
    }
    
}
