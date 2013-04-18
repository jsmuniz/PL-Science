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
@Table(name = "How?")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "How.findAll", query = "SELECT h FROM How h"),
    @NamedQuery(name = "How.findByIdHow", query = "SELECT h FROM How h WHERE h.idHow = :idHow"),
    @NamedQuery(name = "How.findByDescription", query = "SELECT h FROM How h WHERE h.description = :description")})
public class How implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHow?")
    private Integer idHow;
    @Column(name = "description")
    private String description;

    public How() {
    }

    public How(Integer idHow) {
        this.idHow = idHow;
    }

    public Integer getIdHow() {
        return idHow;
    }

    public void setIdHow(Integer idHow) {
        this.idHow = idHow;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHow != null ? idHow.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof How)) {
            return false;
        }
        How other = (How) object;
        if ((this.idHow == null && other.idHow != null) || (this.idHow != null && !this.idHow.equals(other.idHow))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ufjf.modelo.How[ idHow=" + idHow + " ]";
    }
    
}
