/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "User")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByIdScientist", query = "SELECT u FROM User u WHERE u.idScientist = :idScientist"),
    @NamedQuery(name = "User.findByNomeScientist", query = "SELECT u FROM User u WHERE u.nomeScientist = :nomeScientist"),
    @NamedQuery(name = "User.findByLoginScientist", query = "SELECT u FROM User u WHERE u.loginScientist = :loginScientist"),
    @NamedQuery(name = "User.findBySenhaScientist", query = "SELECT u FROM User u WHERE u.senhaScientist = :senhaScientist"),
    @NamedQuery(name = "User.findByCpfScientist", query = "SELECT u FROM User u WHERE u.cpfScientist = :cpfScientist"),
    @NamedQuery(name = "User.findByEmailScientist", query = "SELECT u FROM User u WHERE u.emailScientist = :emailScientist"),
    @NamedQuery(name = "User.findByInstituicaoScientist", query = "SELECT u FROM User u WHERE u.instituicaoScientist = :instituicaoScientist")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idScientist")
    private Integer idScientist;
    @Basic(optional = false)
    @Column(name = "nomeScientist")
    private String nomeScientist;
    @Basic(optional = false)
    @Column(name = "loginScientist")
    private String loginScientist;
    @Basic(optional = false)
    @Column(name = "senhaScientist")
    private String senhaScientist;
    @Basic(optional = false)
    @Column(name = "cpfScientist")
    private String cpfScientist;
    @Basic(optional = false)
    @Column(name = "emailScientist")
    private String emailScientist;
    @Column(name = "instituicaoScientist")
    private String instituicaoScientist;

    public User() {
    }

    public User(Integer idScientist) {
        this.idScientist = idScientist;
    }

    public User(Integer idScientist, String nomeScientist, String loginScientist, String senhaScientist, String cpfScientist, String emailScientist) {
        this.idScientist = idScientist;
        this.nomeScientist = nomeScientist;
        this.loginScientist = loginScientist;
        this.senhaScientist = senhaScientist;
        this.cpfScientist = cpfScientist;
        this.emailScientist = emailScientist;
    }

    public Integer getIdScientist() {
        return idScientist;
    }

    public void setIdScientist(Integer idScientist) {
        this.idScientist = idScientist;
    }

    public String getNomeScientist() {
        return nomeScientist;
    }

    public void setNomeScientist(String nomeScientist) {
        this.nomeScientist = nomeScientist;
    }

    public String getLoginScientist() {
        return loginScientist;
    }

    public void setLoginScientist(String loginScientist) {
        this.loginScientist = loginScientist;
    }

    public String getSenhaScientist() {
        return senhaScientist;
    }

    public void setSenhaScientist(String senhaScientist) {
        this.senhaScientist = senhaScientist;
    }

    public String getCpfScientist() {
        return cpfScientist;
    }

    public void setCpfScientist(String cpfScientist) {
        this.cpfScientist = cpfScientist;
    }

    public String getEmailScientist() {
        return emailScientist;
    }

    public void setEmailScientist(String emailScientist) {
        this.emailScientist = emailScientist;
    }

    public String getInstituicaoScientist() {
        return instituicaoScientist;
    }

    public void setInstituicaoScientist(String instituicaoScientist) {
        this.instituicaoScientist = instituicaoScientist;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idScientist != null ? idScientist.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.idScientist == null && other.idScientist != null) || (this.idScientist != null && !this.idScientist.equals(other.idScientist))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ufjf.modelo.User[ idScientist=" + idScientist + " ]";
    }
    
}
