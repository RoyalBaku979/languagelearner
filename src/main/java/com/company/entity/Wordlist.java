/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sarkhanrasullu
 */
@Entity
@Table(name = "wordlist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wordlist.findAll", query = "SELECT w FROM Wordlist w")
    , @NamedQuery(name = "Wordlist.findById", query = "SELECT w FROM Wordlist w WHERE w.id = :id")
    , @NamedQuery(name = "Wordlist.findByWord", query = "SELECT w FROM Wordlist w WHERE w.word = :word")
    , @NamedQuery(name = "Wordlist.findByTranslation", query = "SELECT w FROM Wordlist w WHERE w.translation = :translation")
    , @NamedQuery(name = "Wordlist.findByImportDate", query = "SELECT w FROM Wordlist w WHERE w.importDate = :importDate")})
public class Wordlist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "word")
    private String word;
    @Basic(optional = false)
    @Column(name = "translation")
    private String translation;
    @Basic(optional = false)
    @Column(name = "import_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date importDate;
    @Lob
    @Column(name = "wrong_count")
    private String wrongCount;
    @Lob
    @Column(name = "right_count")
    private String rightCount;
    @JoinColumn(name = "import_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User importUserId;
    @JoinColumn(name = "word_lang_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Language wordLangId;
    @JoinColumn(name = "translation_lang_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Language translationLangId;

    public Wordlist() {
    }

    public Wordlist(Integer id) {
        this.id = id;
    }

    public Wordlist(Integer id, String word, String translation, Date importDate) {
        this.id = id;
        this.word = word;
        this.translation = translation;
        this.importDate = importDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public String getWrongCount() {
        return wrongCount;
    }

    public void setWrongCount(String wrongCount) {
        this.wrongCount = wrongCount;
    }

    public String getRightCount() {
        return rightCount;
    }

    public void setRightCount(String rightCount) {
        this.rightCount = rightCount;
    }

    public User getImportUserId() {
        return importUserId;
    }

    public void setImportUserId(User importUserId) {
        this.importUserId = importUserId;
    }

    public Language getWordLangId() {
        return wordLangId;
    }

    public void setWordLangId(Language wordLangId) {
        this.wordLangId = wordLangId;
    }

    public Language getTranslationLangId() {
        return translationLangId;
    }

    public void setTranslationLangId(Language translationLangId) {
        this.translationLangId = translationLangId;
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
        if (!(object instanceof Wordlist)) {
            return false;
        }
        Wordlist other = (Wordlist) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id="+id+",word="+word+", translation="+translation;
    }
    
}
