/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author magnus
 */
@Entity
@Table(name = "Decision")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Decision.findAll", query = "SELECT d FROM Decision d"),
    @NamedQuery(name = "Decision.findByIdDecision", query = "SELECT d FROM Decision d WHERE d.idDecision = :idDecision"),
    @NamedQuery(name = "Decision.findByDescription", query = "SELECT d FROM Decision d WHERE d.description = :description"),
    @NamedQuery(name = "Decision.findBySubFeature", query = "SELECT d FROM Decision d WHERE d.subFeature = :subFeature")})
public class Decision implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDecision")
    private Integer idDecision;
    @Basic(optional = false)
    @Column(name = "Description")
    private String description;
    @Column(name = "SubFeature")
    private String subFeature;

    public Decision() {
    }

    public Decision(Integer idDecision) {
        this.idDecision = idDecision;
    }

    public Decision(Integer idDecision, String description) {
        this.idDecision = idDecision;
        this.description = description;
    }

    public Integer getIdDecision() {
        return idDecision;
    }

    public void setIdDecision(Integer idDecision) {
        this.idDecision = idDecision;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubFeature() {
        return subFeature;
    }

    public void setSubFeature(String subFeature) {
        this.subFeature = subFeature;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDecision != null ? idDecision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Decision)) {
            return false;
        }
        Decision other = (Decision) object;
        if ((this.idDecision == null && other.idDecision != null) || (this.idDecision != null && !this.idDecision.equals(other.idDecision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ufjf.modelo.Decision[ idDecision=" + idDecision + " ]";
    }
    
}
