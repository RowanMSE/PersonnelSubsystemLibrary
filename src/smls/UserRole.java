/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smls;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author junxin
 */
@Entity
@Table(name = "USER_ROLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserRole.findAll", query = "SELECT u FROM UserRole u"),
    @NamedQuery(name = "UserRole.findByUserRole", query = "SELECT u FROM UserRole u WHERE u.userRole = :userRole")})
public class UserRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USER_ROLE")
    private String userRole;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userRole")
    private Collection<SkillsTraining> skillsTrainingCollection;

    public UserRole() {
    }

    public UserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @XmlTransient
    public Collection<SkillsTraining> getSkillsTrainingCollection() {
        return skillsTrainingCollection;
    }

    public void setSkillsTrainingCollection(Collection<SkillsTraining> skillsTrainingCollection) {
        this.skillsTrainingCollection = skillsTrainingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userRole != null ? userRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRole)) {
            return false;
        }
        UserRole other = (UserRole) object;
        if ((this.userRole == null && other.userRole != null) || (this.userRole != null && !this.userRole.equals(other.userRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smls.UserRole[ userRole=" + userRole + " ]";
    }
    
}
