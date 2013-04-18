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
public class RationalePK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "idRationale")
    private int idRationale;
    @Basic(optional = false)
    @Column(name = "idWho")
    private int idWho;
    @Basic(optional = false)
    @Column(name = "idWhen?")
    private int idWhen;
    @Basic(optional = false)
    @Column(name = "idWhere?")
    private int idWhere;
    @Basic(optional = false)
    @Column(name = "idWhy?")
    private int idWhy;
    @Basic(optional = false)
    @Column(name = "idWhat?")
    private int idWhat;
    @Basic(optional = false)
    @Column(name = "idHow?")
    private int idHow;
    @Basic(optional = false)
    @Column(name = "Decision_idDecision")
    private int decisionidDecision;
    @Basic(optional = false)
    @Column(name = "Notes_idNotes")
    private int notesidNotes;

    public RationalePK() {
    }

    public RationalePK(int idRationale, int idWho, int idWhen, int idWhere, int idWhy, int idWhat, int idHow, int decisionidDecision, int notesidNotes) {
        this.idRationale = idRationale;
        this.idWho = idWho;
        this.idWhen = idWhen;
        this.idWhere = idWhere;
        this.idWhy = idWhy;
        this.idWhat = idWhat;
        this.idHow = idHow;
        this.decisionidDecision = decisionidDecision;
        this.notesidNotes = notesidNotes;
    }

    public int getIdRationale() {
        return idRationale;
    }

    public void setIdRationale(int idRationale) {
        this.idRationale = idRationale;
    }

    public int getIdWho() {
        return idWho;
    }

    public void setIdWho(int idWho) {
        this.idWho = idWho;
    }

    public int getIdWhen() {
        return idWhen;
    }

    public void setIdWhen(int idWhen) {
        this.idWhen = idWhen;
    }

    public int getIdWhere() {
        return idWhere;
    }

    public void setIdWhere(int idWhere) {
        this.idWhere = idWhere;
    }

    public int getIdWhy() {
        return idWhy;
    }

    public void setIdWhy(int idWhy) {
        this.idWhy = idWhy;
    }

    public int getIdWhat() {
        return idWhat;
    }

    public void setIdWhat(int idWhat) {
        this.idWhat = idWhat;
    }

    public int getIdHow() {
        return idHow;
    }

    public void setIdHow(int idHow) {
        this.idHow = idHow;
    }

    public int getDecisionidDecision() {
        return decisionidDecision;
    }

    public void setDecisionidDecision(int decisionidDecision) {
        this.decisionidDecision = decisionidDecision;
    }

    public int getNotesidNotes() {
        return notesidNotes;
    }

    public void setNotesidNotes(int notesidNotes) {
        this.notesidNotes = notesidNotes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idRationale;
        hash += (int) idWho;
        hash += (int) idWhen;
        hash += (int) idWhere;
        hash += (int) idWhy;
        hash += (int) idWhat;
        hash += (int) idHow;
        hash += (int) decisionidDecision;
        hash += (int) notesidNotes;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RationalePK)) {
            return false;
        }
        RationalePK other = (RationalePK) object;
        if (this.idRationale != other.idRationale) {
            return false;
        }
        if (this.idWho != other.idWho) {
            return false;
        }
        if (this.idWhen != other.idWhen) {
            return false;
        }
        if (this.idWhere != other.idWhere) {
            return false;
        }
        if (this.idWhy != other.idWhy) {
            return false;
        }
        if (this.idWhat != other.idWhat) {
            return false;
        }
        if (this.idHow != other.idHow) {
            return false;
        }
        if (this.decisionidDecision != other.decisionidDecision) {
            return false;
        }
        if (this.notesidNotes != other.notesidNotes) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ufjf.modelo.RationalePK[ idRationale=" + idRationale + ", idWho=" + idWho + ", idWhen=" + idWhen + ", idWhere=" + idWhere + ", idWhy=" + idWhy + ", idWhat=" + idWhat + ", idHow=" + idHow + ", decisionidDecision=" + decisionidDecision + ", notesidNotes=" + notesidNotes + " ]";
    }
    
}
