/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smls;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "USER_ID")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserId.findAll", query = "SELECT u FROM UserId u"),
    @NamedQuery(name = "UserId.findByUserId", query = "SELECT u FROM UserId u WHERE u.userId = :userId")})
public class UserId implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USER_ID")
    private String userId;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userId1")
    private AccessInfo accessInfo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userId1")
    private SkillsTraining skillsTraining;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userId1")
    private AddressPhone addressPhone;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userId1")
    private PersonalInfo personalInfo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userId1")
    private EmergencyContact emergencyContact;

    public UserId() {
    }

    public UserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public AccessInfo getAccessInfo() {
        return accessInfo;
    }

    public void setAccessInfo(AccessInfo accessInfo) {
        this.accessInfo = accessInfo;
    }

    public SkillsTraining getSkillsTraining() {
        return skillsTraining;
    }

    public void setSkillsTraining(SkillsTraining skillsTraining) {
        this.skillsTraining = skillsTraining;
    }

    public AddressPhone getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(AddressPhone addressPhone) {
        this.addressPhone = addressPhone;
    }

    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

    public EmergencyContact getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(EmergencyContact emergencyContact) {
        this.emergencyContact = emergencyContact;
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
        if (!(object instanceof UserId)) {
            return false;
        }
        UserId other = (UserId) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smls.UserId[ userId=" + userId + " ]";
    }
    
}
