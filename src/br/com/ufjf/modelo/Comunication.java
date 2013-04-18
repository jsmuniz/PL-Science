/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author magnus
 */
@Entity
@Table(name = "Comunication")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comunication.findAll", query = "SELECT c FROM Comunication c"),
    @NamedQuery(name = "Comunication.findByIdComunication", query = "SELECT c FROM Comunication c WHERE c.comunicationPK.idComunication = :idComunication"),
    @NamedQuery(name = "Comunication.findByMessage", query = "SELECT c FROM Comunication c WHERE c.message = :message"),
    @NamedQuery(name = "Comunication.findByIdRationale", query = "SELECT c FROM Comunication c WHERE c.comunicationPK.idRationale = :idRationale"),
    @NamedQuery(name = "Comunication.findByIdScientistReceptor", query = "SELECT c FROM Comunication c WHERE c.comunicationPK.idScientistReceptor = :idScientistReceptor"),
    @NamedQuery(name = "Comunication.findBySubfeature", query = "SELECT c FROM Comunication c WHERE c.subfeature = :subfeature")})
public class Comunication implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ComunicationPK comunicationPK;
    @Column(name = "message")
    private String message;
    @Column(name = "Subfeature")
    private String subfeature;
    @JoinColumn(name = "idScientistReceptor", referencedColumnName = "idScientist", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Scientist scientist;
    @JoinColumn(name = "idRationale", referencedColumnName = "idRationale", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Rationale rationale;

    public Comunication() {
    }

    public Comunication(ComunicationPK comunicationPK) {
        this.comunicationPK = comunicationPK;
    }

    public Comunication(int idComunication, int idRationale, int idScientistReceptor) {
        this.comunicationPK = new ComunicationPK(idComunication, idRationale, idScientistReceptor);
    }

    public ComunicationPK getComunicationPK() {
        return comunicationPK;
    }

    public void setComunicationPK(ComunicationPK comunicationPK) {
        this.comunicationPK = comunicationPK;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubfeature() {
        return subfeature;
    }

    public void setSubfeature(String subfeature) {
        this.subfeature = subfeature;
    }

    public Scientist getScientist() {
        return scientist;
    }

    public void setScientist(Scientist scientist) {
        this.scientist = scientist;
    }

    public Rationale getRationale() {
        return rationale;
    }

    public void setRationale(Rationale rationale) {
        this.rationale = rationale;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comunicationPK != null ? comunicationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comunication)) {
            return false;
        }
        Comunication other = (Comunication) object;
        if ((this.comunicationPK == null && other.comunicationPK != null) || (this.comunicationPK != null && !this.comunicationPK.equals(other.comunicationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ufjf.modelo.Comunication[ comunicationPK=" + comunicationPK + " ]";
    }
    
}
