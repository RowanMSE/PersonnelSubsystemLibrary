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
@Table(name = "ADDRESS_PHONE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AddressPhone.findAll", query = "SELECT a FROM AddressPhone a"),
    @NamedQuery(name = "AddressPhone.findByUserId", query = "SELECT a FROM AddressPhone a WHERE a.userId = :userId"),
    @NamedQuery(name = "AddressPhone.findByStreet", query = "SELECT a FROM AddressPhone a WHERE a.street = :street"),
    @NamedQuery(name = "AddressPhone.findByCity", query = "SELECT a FROM AddressPhone a WHERE a.city = :city"),
    @NamedQuery(name = "AddressPhone.findByStates", query = "SELECT a FROM AddressPhone a WHERE a.states = :states"),
    @NamedQuery(name = "AddressPhone.findByPostalCode", query = "SELECT a FROM AddressPhone a WHERE a.postalCode = :postalCode"),
    @NamedQuery(name = "AddressPhone.findByMobilePhone", query = "SELECT a FROM AddressPhone a WHERE a.mobilePhone = :mobilePhone"),
    @NamedQuery(name = "AddressPhone.findByOfficePhone", query = "SELECT a FROM AddressPhone a WHERE a.officePhone = :officePhone"),
    @NamedQuery(name = "AddressPhone.findByHomePhone", query = "SELECT a FROM AddressPhone a WHERE a.homePhone = :homePhone")})
public class AddressPhone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USER_ID")
    private String userId;
    @Basic(optional = false)
    @Column(name = "STREET")
    private String street;
    @Basic(optional = false)
    @Column(name = "CITY")
    private String city;
    @Basic(optional = false)
    @Column(name = "STATES")
    private String states;
    @Basic(optional = false)
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    @Basic(optional = false)
    @Column(name = "MOBILE_PHONE")
    private String mobilePhone;
    @Basic(optional = false)
    @Column(name = "OFFICE_PHONE")
    private String officePhone;
    @Column(name = "HOME_PHONE")
    private String homePhone;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private UserId userId1;

    public AddressPhone() {
    }

    public AddressPhone(String userId) {
        this.userId = userId;
    }

    public AddressPhone(String userId, String street, String city, String states, String postalCode, String mobilePhone, String officePhone) {
        this.userId = userId;
        this.street = street;
        this.city = city;
        this.states = states;
        this.postalCode = postalCode;
        this.mobilePhone = mobilePhone;
        this.officePhone = officePhone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
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
        if (!(object instanceof AddressPhone)) {
            return false;
        }
        AddressPhone other = (AddressPhone) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smls.AddressPhone[ userId=" + userId + " ]";
    }
    
}
