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
@Table(name = "EMERGENCY_CONTACT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmergencyContact.findAll", query = "SELECT e FROM EmergencyContact e"),
    @NamedQuery(name = "EmergencyContact.findByUserId", query = "SELECT e FROM EmergencyContact e WHERE e.userId = :userId"),
    @NamedQuery(name = "EmergencyContact.findByEName", query = "SELECT e FROM EmergencyContact e WHERE e.eName = :eName"),
    @NamedQuery(name = "EmergencyContact.findByRelationship", query = "SELECT e FROM EmergencyContact e WHERE e.relationship = :relationship"),
    @NamedQuery(name = "EmergencyContact.findByPhone", query = "SELECT e FROM EmergencyContact e WHERE e.phone = :phone"),
    @NamedQuery(name = "EmergencyContact.findByStreet", query = "SELECT e FROM EmergencyContact e WHERE e.street = :street"),
    @NamedQuery(name = "EmergencyContact.findByCity", query = "SELECT e FROM EmergencyContact e WHERE e.city = :city"),
    @NamedQuery(name = "EmergencyContact.findByStates", query = "SELECT e FROM EmergencyContact e WHERE e.states = :states"),
    @NamedQuery(name = "EmergencyContact.findByPostalCode", query = "SELECT e FROM EmergencyContact e WHERE e.postalCode = :postalCode")})
public class EmergencyContact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USER_ID")
    private String userId;
    @Column(name = "E_NAME")
    private String eName;
    @Column(name = "RELATIONSHIP")
    private String relationship;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "STREET")
    private String street;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATES")
    private String states;
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private UserId userId1;

    public EmergencyContact() {
    }

    public EmergencyContact(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEName() {
        return eName;
    }

    public void setEName(String eName) {
        this.eName = eName;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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
        if (!(object instanceof EmergencyContact)) {
            return false;
        }
        EmergencyContact other = (EmergencyContact) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smls.EmergencyContact[ userId=" + userId + " ]";
    }
    
}
