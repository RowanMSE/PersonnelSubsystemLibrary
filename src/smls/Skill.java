/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smls;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "SKILL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Skill.findAll", query = "SELECT s FROM Skill s"),
    @NamedQuery(name = "Skill.findBySkill", query = "SELECT s FROM Skill s WHERE s.skill = :skill")})
public class Skill implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SKILL")
    private String skill;
    @OneToMany(mappedBy = "skill")
    private Collection<SkillsTraining> skillsTrainingCollection;

    public Skill() {
    }

    public Skill(String skill) {
        this.skill = skill;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
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
        hash += (skill != null ? skill.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Skill)) {
            return false;
        }
        Skill other = (Skill) object;
        if ((this.skill == null && other.skill != null) || (this.skill != null && !this.skill.equals(other.skill))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "smls.Skill[ skill=" + skill + " ]";
    }
    
}
