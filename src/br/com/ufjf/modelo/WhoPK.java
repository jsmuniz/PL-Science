/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author magnus
 */
@Embeddable
public class WhoPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "idWho")
    private int idWho;
    @Basic(optional = false)
    @Column(name = "idScientist")
    private int idScientist;

    public WhoPK() {
    }

    public WhoPK(int idWho, int idScientist) {
        this.idWho = idWho;
        this.idScientist = idScientist;
    }

    public int getIdWho() {
        return idWho;
    }

    public void setIdWho(int idWho) {
        this.idWho = idWho;
    }

    public int getIdScientist() {
        return idScientist;
    }

    public void setIdScientist(int idScientist) {
        this.idScientist = idScientist;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idWho;
        hash += (int) idScientist;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WhoPK)) {
            return false;
        }
        WhoPK other = (WhoPK) object;
        if (this.idWho != other.idWho) {
            return false;
        }
        if (this.idScientist != other.idScientist) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ufjf.modelo.WhoPK[ idWho=" + idWho + ", idScientist=" + idScientist + " ]";
    }
    
}
