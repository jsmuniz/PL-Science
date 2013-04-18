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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "Where?")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Where1.findAll", query = "SELECT w FROM Where1 w"),
    @NamedQuery(name = "Where1.findByIdWhere", query = "SELECT w FROM Where1 w WHERE w.idWhere = :idWhere"),
    @NamedQuery(name = "Where1.findByLocal", query = "SELECT w FROM Where1 w WHERE w.local = :local")})
public class Where1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idWhere?")
    private Integer idWhere;
    @Column(name = "local")
    private String local;
    @JoinTable(name = "ProductFamily", joinColumns = {
        @JoinColumn(name = "Where?_idWhere?", referencedColumnName = "idWhere?")}, inverseJoinColumns = {
        @JoinColumn(name = "Artifact_idArtifact", referencedColumnName = "idArtifact")})
    @ManyToMany
    private Collection<Artifact> artifactCollection;

    public Where1() {
    }

    public Where1(Integer idWhere) {
        this.idWhere = idWhere;
    }

    public Integer getIdWhere() {
        return idWhere;
    }

    public void setIdWhere(Integer idWhere) {
        this.idWhere = idWhere;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @XmlTransient
    public Collection<Artifact> getArtifactCollection() {
        return artifactCollection;
    }

    public void setArtifactCollection(Collection<Artifact> artifactCollection) {
        this.artifactCollection = artifactCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWhere != null ? idWhere.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Where1)) {
            return false;
        }
        Where1 other = (Where1) object;
        if ((this.idWhere == null && other.idWhere != null) || (this.idWhere != null && !this.idWhere.equals(other.idWhere))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ufjf.modelo.Where1[ idWhere=" + idWhere + " ]";
    }
    
}
