/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author magnus
 */
@Entity
@Table(name = "Rationale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rationale.findAll", query = "SELECT r FROM Rationale r"),
    @NamedQuery(name = "Rationale.findByIdRationale", query = "SELECT r FROM Rationale r WHERE r.rationalePK.idRationale = :idRationale"),
    @NamedQuery(name = "Rationale.findByIdWho", query = "SELECT r FROM Rationale r WHERE r.rationalePK.idWho = :idWho"),
    @NamedQuery(name = "Rationale.findByIdWhen", query = "SELECT r FROM Rationale r WHERE r.rationalePK.idWhen = :idWhen"),
    @NamedQuery(name = "Rationale.findByIdWhere", query = "SELECT r FROM Rationale r WHERE r.rationalePK.idWhere = :idWhere"),
    @NamedQuery(name = "Rationale.findByIdWhy", query = "SELECT r FROM Rationale r WHERE r.rationalePK.idWhy = :idWhy"),
    @NamedQuery(name = "Rationale.findByIdWhat", query = "SELECT r FROM Rationale r WHERE r.rationalePK.idWhat = :idWhat"),
    @NamedQuery(name = "Rationale.findByIdHow", query = "SELECT r FROM Rationale r WHERE r.rationalePK.idHow = :idHow"),
    @NamedQuery(name = "Rationale.findByIdNewRationale", query = "SELECT r FROM Rationale r WHERE r.idNewRationale = :idNewRationale"),
    @NamedQuery(name = "Rationale.findByDecisionidDecision", query = "SELECT r FROM Rationale r WHERE r.rationalePK.decisionidDecision = :decisionidDecision"),
    @NamedQuery(name = "Rationale.findByNotesidNotes", query = "SELECT r FROM Rationale r WHERE r.rationalePK.notesidNotes = :notesidNotes")})
public class Rationale implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RationalePK rationalePK;
    @Column(name = "idNewRationale")
    private Integer idNewRationale;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rationale")
    private Collection<Comunication> comunicationCollection;

    public Rationale() {
    }

    public Rationale(RationalePK rationalePK) {
        this.rationalePK = rationalePK;
    }

    public Rationale(int idRationale, int idWho, int idWhen, int idWhere, int idWhy, int idWhat, int idHow, int decisionidDecision, int notesidNotes) {
        this.rationalePK = new RationalePK(idRationale, idWho, idWhen, idWhere, idWhy, idWhat, idHow, decisionidDecision, notesidNotes);
    }

    public RationalePK getRationalePK() {
        return rationalePK;
    }

    public void setRationalePK(RationalePK rationalePK) {
        this.rationalePK = rationalePK;
    }

    public Integer getIdNewRationale() {
        return idNewRationale;
    }

    public void setIdNewRationale(Integer idNewRationale) {
        this.idNewRationale = idNewRationale;
    }

    @XmlTransient
    public Collection<Comunication> getComunicationCollection() {
        return comunicationCollection;
    }

    public void setComunicationCollection(Collection<Comunication> comunicationCollection) {
        this.comunicationCollection = comunicationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rationalePK != null ? rationalePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rationale)) {
            return false;
        }
        Rationale other = (Rationale) object;
        if ((this.rationalePK == null && other.rationalePK != null) || (this.rationalePK != null && !this.rationalePK.equals(other.rationalePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ufjf.modelo.Rationale[ rationalePK=" + rationalePK + " ]";
    }
    
}
