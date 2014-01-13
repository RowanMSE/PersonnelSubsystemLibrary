/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smls;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author junxin
 */
@Entity
@Table(name = "PERSONAL_INFO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonalInfo.findAll", query = "SELECT p FROM PersonalInfo p"),
    @NamedQuery(name = "PersonalInfo.findByUserId", query = "SELECT p FROM PersonalInfo p WHERE p.userId = :userId"),
    @NamedQuery(name = "PersonalInfo.findByLastName", query = "SELECT p FROM PersonalInfo p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "PersonalInfo.findByFirstName", query = "SELECT p FROM PersonalInfo p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "PersonalInfo.findByMiddleName", query = "SELECT p FROM PersonalInfo p WHERE p.middleName = :middleName"),
    @NamedQuery(name = "PersonalInfo.findBySsn", query = "SELECT p FROM PersonalInfo p WHERE p.ssn = :ssn"),
    @NamedQuery(name = "PersonalInfo.findByBirthDate", query = "SELECT p FROM PersonalInfo p WHERE p.birthDate = :birthDate"),
    @NamedQuery(name = "PersonalInfo.findByServiceDate", query = "SELECT p FROM PersonalInfo p WHERE p.serviceDate = :serviceDate")})
public class PersonalInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USER_ID")
    private String userId;
    @Basic(optional = false)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    @Basic(optional = false)
    @Column(name = "SSN")
    private String ssn;
    @Basic(optional = false)
    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(name = "SERVICE_DATE")
    @Temporal(TemporalType.DATE)
    private Date serviceDate;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private UserId userId1;
    @JoinColumn(name = "GENDER", referencedColumnName = "GENDER")
    @ManyToOne(optional = false)
    private Gender gender;

    public PersonalInfo() {
    }

    public PersonalInfo(String userId) {
        this.userId = userId;
    }

    public PersonalInfo(String userId, String lastName, String firstName, String ssn, Date birthDate) {
        this.userId = userId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.ssn = ssn;
        this.birthDate = birthDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public UserId getUserId1() {
        return userId1;
    }

    public void setUserId1(UserId userId1) {
        this.userId1 = userId1;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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
        if (!(object instanceof PersonalInfo)) {
            return false;
        }
        PersonalInfo other = (PersonalInfo) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smls.PersonalInfo[ userId=" + userId + " ]";
    }
    
}
