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
@Table(name = "GENDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gender.findAll", query = "SELECT g FROM Gender g"),
    @NamedQuery(name = "Gender.findByGender", query = "SELECT g FROM Gender g WHERE g.gender = :gender")})
public class Gender implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "GENDER")
    private Character gender;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gender")
    private Collection<PersonalInfo> personalInfoCollection;

    public Gender() {
    }

    public Gender(Character gender) {
        this.gender = gender;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    @XmlTransient
    public Collection<PersonalInfo> getPersonalInfoCollection() {
        return personalInfoCollection;
    }

    public void setPersonalInfoCollection(Collection<PersonalInfo> personalInfoCollection) {
        this.personalInfoCollection = personalInfoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gender != null ? gender.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gender)) {
            return false;
        }
        Gender other = (Gender) object;
        if ((this.gender == null && other.gender != null) || (this.gender != null && !this.gender.equals(other.gender))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smls.Gender[ gender=" + gender + " ]";
    }
    
}
