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
public class ComunicationPK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "idComunication")
    private int idComunication;
    @Basic(optional = false)
    @Column(name = "idRationale")
    private int idRationale;
    @Basic(optional = false)
    @Column(name = "idScientistReceptor")
    private int idScientistReceptor;

    public ComunicationPK() {
    }

    public ComunicationPK(int idComunication, int idRationale, int idScientistReceptor) {
        this.idComunication = idComunication;
        this.idRationale = idRationale;
        this.idScientistReceptor = idScientistReceptor;
    }

    public int getIdComunication() {
        return idComunication;
    }

    public void setIdComunication(int idComunication) {
        this.idComunication = idComunication;
    }

    public int getIdRationale() {
        return idRationale;
    }

    public void setIdRationale(int idRationale) {
        this.idRationale = idRationale;
    }

    public int getIdScientistReceptor() {
        return idScientistReceptor;
    }

    public void setIdScientistReceptor(int idScientistReceptor) {
        this.idScientistReceptor = idScientistReceptor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idComunication;
        hash += (int) idRationale;
        hash += (int) idScientistReceptor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComunicationPK)) {
            return false;
        }
        ComunicationPK other = (ComunicationPK) object;
        if (this.idComunication != other.idComunication) {
            return false;
        }
        if (this.idRationale != other.idRationale) {
            return false;
        }
        if (this.idScientistReceptor != other.idScientistReceptor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ufjf.modelo.ComunicationPK[ idComunication=" + idComunication + ", idRationale=" + idRationale + ", idScientistReceptor=" + idScientistReceptor + " ]";
    }
    
}
