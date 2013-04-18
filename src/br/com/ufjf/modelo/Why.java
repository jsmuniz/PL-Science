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
@Table(name = "Why?")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Why.findAll", query = "SELECT w FROM Why w"),
    @NamedQuery(name = "Why.findByIdWhy", query = "SELECT w FROM Why w WHERE w.idWhy = :idWhy"),
    @NamedQuery(name = "Why.findByDescription", query = "SELECT w FROM Why w WHERE w.description = :description")})
public class Why implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idWhy?")
    private Integer idWhy;
    @Column(name = "description")
    private String description;

    public Why() {
    }

    public Why(Integer idWhy) {
        this.idWhy = idWhy;
    }

    public Integer getIdWhy() {
        return idWhy;
    }

    public void setIdWhy(Integer idWhy) {
        this.idWhy = idWhy;
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
        hash += (idWhy != null ? idWhy.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Why)) {
            return false;
        }
        Why other = (Why) object;
        if ((this.idWhy == null && other.idWhy != null) || (this.idWhy != null && !this.idWhy.equals(other.idWhy))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ufjf.modelo.Why[ idWhy=" + idWhy + " ]";
    }
    
}
