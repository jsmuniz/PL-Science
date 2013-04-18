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
@Table(name = "Notes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notes.findAll", query = "SELECT n FROM Notes n"),
    @NamedQuery(name = "Notes.findByIdNotes", query = "SELECT n FROM Notes n WHERE n.idNotes = :idNotes"),
    @NamedQuery(name = "Notes.findByDescription", query = "SELECT n FROM Notes n WHERE n.description = :description"),
    @NamedQuery(name = "Notes.findBySubfeatures", query = "SELECT n FROM Notes n WHERE n.subfeatures = :subfeatures")})
public class Notes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idNotes")
    private Integer idNotes;
    @Basic(optional = false)
    @Column(name = "Description")
    private String description;
    @Column(name = "Subfeatures")
    private String subfeatures;

    public Notes() {
    }

    public Notes(Integer idNotes) {
        this.idNotes = idNotes;
    }

    public Notes(Integer idNotes, String description) {
        this.idNotes = idNotes;
        this.description = description;
    }

    public Integer getIdNotes() {
        return idNotes;
    }

    public void setIdNotes(Integer idNotes) {
        this.idNotes = idNotes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubfeatures() {
        return subfeatures;
    }

    public void setSubfeatures(String subfeatures) {
        this.subfeatures = subfeatures;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotes != null ? idNotes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notes)) {
            return false;
        }
        Notes other = (Notes) object;
        if ((this.idNotes == null && other.idNotes != null) || (this.idNotes != null && !this.idNotes.equals(other.idNotes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ufjf.modelo.Notes[ idNotes=" + idNotes + " ]";
    }
    
}
