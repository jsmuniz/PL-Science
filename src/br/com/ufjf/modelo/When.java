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
@Table(name = "When?")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "When.findAll", query = "SELECT w FROM When w"),
    @NamedQuery(name = "When.findByIdWhen", query = "SELECT w FROM When w WHERE w.idWhen = :idWhen"),
    @NamedQuery(name = "When.findByDay", query = "SELECT w FROM When w WHERE w.day = :day"),
    @NamedQuery(name = "When.findByMonth", query = "SELECT w FROM When w WHERE w.month = :month"),
    @NamedQuery(name = "When.findByYear", query = "SELECT w FROM When w WHERE w.year = :year"),
    @NamedQuery(name = "When.findByTime", query = "SELECT w FROM When w WHERE w.time = :time"),
    @NamedQuery(name = "When.findByMinute", query = "SELECT w FROM When w WHERE w.minute = :minute")})
public class When implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idWhen?")
    private Integer idWhen;
    @Column(name = "day")
    private Integer day;
    @Column(name = "month")
    private Integer month;
    @Column(name = "year")
    private Integer year;
    @Column(name = "time")
    private Integer time;
    @Column(name = "minute")
    private Integer minute;

    public When() {
    }

    public When(Integer idWhen) {
        this.idWhen = idWhen;
    }

    public Integer getIdWhen() {
        return idWhen;
    }

    public void setIdWhen(Integer idWhen) {
        this.idWhen = idWhen;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWhen != null ? idWhen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof When)) {
            return false;
        }
        When other = (When) object;
        if ((this.idWhen == null && other.idWhen != null) || (this.idWhen != null && !this.idWhen.equals(other.idWhen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ufjf.modelo.When[ idWhen=" + idWhen + " ]";
    }
    
}
