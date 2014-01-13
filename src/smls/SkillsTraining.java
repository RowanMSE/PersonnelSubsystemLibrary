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
@Table(name = "SKILLS_TRAINING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SkillsTraining.findAll", query = "SELECT s FROM SkillsTraining s"),
    @NamedQuery(name = "SkillsTraining.findByUserId", query = "SELECT s FROM SkillsTraining s WHERE s.userId = :userId"),
    @NamedQuery(name = "SkillsTraining.findByNumberYearsExperience", query = "SELECT s FROM SkillsTraining s WHERE s.numberYearsExperience = :numberYearsExperience"),
    @NamedQuery(name = "SkillsTraining.findByTrainingCertificateName", query = "SELECT s FROM SkillsTraining s WHERE s.trainingCertificateName = :trainingCertificateName"),
    @NamedQuery(name = "SkillsTraining.findByCertificateDate", query = "SELECT s FROM SkillsTraining s WHERE s.certificateDate = :certificateDate")})
public class SkillsTraining implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USER_ID")
    private String userId;
    @Column(name = "NUMBER_YEARS_EXPERIENCE")
    private Integer numberYearsExperience;
    @Column(name = "TRAINING_CERTIFICATE_NAME")
    private String trainingCertificateName;
    @Column(name = "CERTIFICATE_DATE")
    @Temporal(TemporalType.DATE)
    private Date certificateDate;
    @JoinColumn(name = "USER_ROLE", referencedColumnName = "USER_ROLE")
    @ManyToOne(optional = false)
    private UserRole userRole;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private UserId userId1;
    @JoinColumn(name = "SKILL", referencedColumnName = "SKILL")
    @ManyToOne
    private Skill skill;

    public SkillsTraining() {
    }

    public SkillsTraining(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getNumberYearsExperience() {
        return numberYearsExperience;
    }

    public void setNumberYearsExperience(Integer numberYearsExperience) {
        this.numberYearsExperience = numberYearsExperience;
    }

    public String getTrainingCertificateName() {
        return trainingCertificateName;
    }

    public void setTrainingCertificateName(String trainingCertificateName) {
        this.trainingCertificateName = trainingCertificateName;
    }

    public Date getCertificateDate() {
        return certificateDate;
    }

    public void setCertificateDate(Date certificateDate) {
        this.certificateDate = certificateDate;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public UserId getUserId1() {
        return userId1;
    }

    public void setUserId1(UserId userId1) {
        this.userId1 = userId1;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
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
        if (!(object instanceof SkillsTraining)) {
            return false;
        }
        SkillsTraining other = (SkillsTraining) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smls.SkillsTraining[ userId=" + userId + " ]";
    }
    
}
