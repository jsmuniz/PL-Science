/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.modelo;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author magnus
 */
@Entity
@Table(name = "Who?")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Who.findAll", query = "SELECT w FROM Who w"),
    @NamedQuery(name = "Who.findByIdWho", query = "SELECT w FROM Who w WHERE w.whoPK.idWho = :idWho"),
    @NamedQuery(name = "Who.findByIdScientist", query = "SELECT w FROM Who w WHERE w.whoPK.idScientist = :idScientist")})
public class Who implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WhoPK whoPK;

    public Who() {
    }

    public Who(WhoPK whoPK) {
        this.whoPK = whoPK;
    }

    public Who(int idWho, int idScientist) {
        this.whoPK = new WhoPK(idWho, idScientist);
    }

    public WhoPK getWhoPK() {
        return whoPK;
    }

    public void setWhoPK(WhoPK whoPK) {
        this.whoPK = whoPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (whoPK != null ? whoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Who)) {
            return false;
        }
        Who other = (Who) object;
        if ((this.whoPK == null && other.whoPK != null) || (this.whoPK != null && !this.whoPK.equals(other.whoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ufjf.modelo.Who[ whoPK=" + whoPK + " ]";
    }
    
}
