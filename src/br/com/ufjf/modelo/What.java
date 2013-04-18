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
@Table(name = "What?")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "What.findAll", query = "SELECT w FROM What w"),
    @NamedQuery(name = "What.findByIdWhat", query = "SELECT w FROM What w WHERE w.idWhat = :idWhat"),
    @NamedQuery(name = "What.findByType", query = "SELECT w FROM What w WHERE w.type = :type"),
    @NamedQuery(name = "What.findByDescription", query = "SELECT w FROM What w WHERE w.description = :description")})
public class What implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idWhat?")
    private Integer idWhat;
    @Column(name = "Type")
    private String type;
    @Column(name = "description")
    private String description;

    public What() {
    }

    public What(Integer idWhat) {
        this.idWhat = idWhat;
    }

    public Integer getIdWhat() {
        return idWhat;
    }

    public void setIdWhat(Integer idWhat) {
        this.idWhat = idWhat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        hash += (idWhat != null ? idWhat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof What)) {
            return false;
        }
        What other = (What) object;
        if ((this.idWhat == null && other.idWhat != null) || (this.idWhat != null && !this.idWhat.equals(other.idWhat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ufjf.modelo.What[ idWhat=" + idWhat + " ]";
    }
    
}
