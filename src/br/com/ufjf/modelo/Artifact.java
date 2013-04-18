/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author magnus
 */
@Entity
@Table(name = "Artifact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artifact.findAll", query = "SELECT a FROM Artifact a"),
    @NamedQuery(name = "Artifact.findByIdArtifact", query = "SELECT a FROM Artifact a WHERE a.idArtifact = :idArtifact"),
    @NamedQuery(name = "Artifact.findByName", query = "SELECT a FROM Artifact a WHERE a.name = :name"),
    @NamedQuery(name = "Artifact.findByPurpose", query = "SELECT a FROM Artifact a WHERE a.purpose = :purpose"),
    @NamedQuery(name = "Artifact.findByLocal", query = "SELECT a FROM Artifact a WHERE a.local = :local")})
public class Artifact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idArtifact")
    private Integer idArtifact;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Purpose")
    private String purpose;
    @Basic(optional = false)
    @Column(name = "Local")
    private String local;
    @ManyToMany(mappedBy = "artifactCollection")
    private Collection<Where1> where1Collection;

    public Artifact() {
    }

    public Artifact(Integer idArtifact) {
        this.idArtifact = idArtifact;
    }

    public Artifact(Integer idArtifact, String name, String local) {
        this.idArtifact = idArtifact;
        this.name = name;
        this.local = local;
    }

    public Integer getIdArtifact() {
        return idArtifact;
    }

    public void setIdArtifact(Integer idArtifact) {
        this.idArtifact = idArtifact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @XmlTransient
    public Collection<Where1> getWhere1Collection() {
        return where1Collection;
    }

    public void setWhere1Collection(Collection<Where1> where1Collection) {
        this.where1Collection = where1Collection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArtifact != null ? idArtifact.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artifact)) {
            return false;
        }
        Artifact other = (Artifact) object;
        if ((this.idArtifact == null && other.idArtifact != null) || (this.idArtifact != null && !this.idArtifact.equals(other.idArtifact))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ufjf.modelo.Artifact[ idArtifact=" + idArtifact + " ]";
    }
    
}
