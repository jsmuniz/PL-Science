/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "Scientist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Scientist.findAll", query = "SELECT s FROM Scientist s"),
    @NamedQuery(name = "Scientist.findByIdScientist", query = "SELECT s FROM Scientist s WHERE s.idScientist = :idScientist"),
    @NamedQuery(name = "Scientist.findByFirstName", query = "SELECT s FROM Scientist s WHERE s.firstName = :firstName"),
    @NamedQuery(name = "Scientist.findByLastName", query = "SELECT s FROM Scientist s WHERE s.lastName = :lastName"),
    @NamedQuery(name = "Scientist.findByCity", query = "SELECT s FROM Scientist s WHERE s.city = :city"),
    @NamedQuery(name = "Scientist.findByState", query = "SELECT s FROM Scientist s WHERE s.state = :state"),
    @NamedQuery(name = "Scientist.findByCountry", query = "SELECT s FROM Scientist s WHERE s.country = :country"),
    @NamedQuery(name = "Scientist.findByDegree", query = "SELECT s FROM Scientist s WHERE s.degree = :degree"),
    @NamedQuery(name = "Scientist.findByEmail", query = "SELECT s FROM Scientist s WHERE s.email = :email")})
public class Scientist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idScientist")
    private Integer idScientist;
    @Basic(optional = false)
    @Column(name = "FirstName")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LastName")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "City")
    private String city;
    @Basic(optional = false)
    @Column(name = "State")
    private String state;
    @Basic(optional = false)
    @Column(name = "Country")
    private String country;
    @Basic(optional = false)
    @Column(name = "degree")
    private String degree;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "scientist")
    private Collection<Comunication> comunicationCollection;

    public Scientist() {
    }

    public Scientist(Integer idScientist) {
        this.idScientist = idScientist;
    }

    public Scientist(Integer idScientist, String firstName, String lastName, String city, String state, String country, String degree, String email) {
        this.idScientist = idScientist;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.country = country;
        this.degree = degree;
        this.email = email;
    }

    public Integer getIdScientist() {
        return idScientist;
    }

    public void setIdScientist(Integer idScientist) {
        this.idScientist = idScientist;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        hash += (idScientist != null ? idScientist.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Scientist)) {
            return false;
        }
        Scientist other = (Scientist) object;
        if ((this.idScientist == null && other.idScientist != null) || (this.idScientist != null && !this.idScientist.equals(other.idScientist))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ufjf.modelo.Scientist[ idScientist=" + idScientist + " ]";
    }
    
}
