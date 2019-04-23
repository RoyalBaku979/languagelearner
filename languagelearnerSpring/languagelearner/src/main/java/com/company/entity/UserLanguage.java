
package com.company.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author sarkhanrasullu
 */
@Entity
@Table(name = "user_language")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserLanguage.findAll", query = "SELECT u FROM UserLanguage u")
    , @NamedQuery(name = "UserLanguage.findById", query = "SELECT u FROM UserLanguage u WHERE u.id = :id")
    , @NamedQuery(name = "UserLanguage.findByLevel", query = "SELECT u FROM UserLanguage u WHERE u.level = :level")})
public class UserLanguage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "level")
    private int level;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User userId;
    @JoinColumn(name = "language_id", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Language languageId;

    public UserLanguage() {
    }

    public UserLanguage(Integer id) {
        this.id = id;
    }

    public UserLanguage(Integer id, int level) {
        this.id = id;
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Language getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Language languageId) {
        this.languageId = languageId;
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
        if (!(object instanceof UserLanguage)) {
            return false;
        }
        UserLanguage other = (UserLanguage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "user name="+userId.getName()+ " language="+languageId.getName();
    }
    
}
