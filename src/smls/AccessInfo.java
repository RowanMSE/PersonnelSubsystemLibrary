/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smls;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author junxin
 */
@Entity
@Table(name = "ACCESS_INFO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccessInfo.findAll", query = "SELECT a FROM AccessInfo a"),
    @NamedQuery(name = "AccessInfo.findByUserId", query = "SELECT a FROM AccessInfo a WHERE a.userId = :userId"),
    @NamedQuery(name = "AccessInfo.findByUsername", query = "SELECT a FROM AccessInfo a WHERE a.username = :username"),
    @NamedQuery(name = "AccessInfo.findByPassword", query = "SELECT a FROM AccessInfo a WHERE a.password = :password")})
public class AccessInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USER_ID")
    private String userId;
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private UserId userId1;

    public AccessInfo() {
    }

    public AccessInfo(String userId) {
        this.userId = userId;
    }

    public AccessInfo(String userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserId getUserId1() {
        return userId1;
    }

    public void setUserId1(UserId userId1) {
        this.userId1 = userId1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccessInfo)) {
            return false;
        }
        AccessInfo other = (AccessInfo) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smls.AccessInfo[ userId=" + userId + " ]";
    }
    
}
