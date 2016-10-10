/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author linusgoransson
 */
@Entity
@Table(name = "filmer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Filmer.findAll", query = "SELECT f FROM Filmer f"),
    @NamedQuery(name = "Filmer.findByTitel", query = "SELECT f FROM Filmer f WHERE f.titel = :titel"),
    @NamedQuery(name = "Filmer.findByRegiss\u00f6r", query = "SELECT f FROM Filmer f WHERE f.regiss\u00f6r = :regiss\u00f6r"),
    @NamedQuery(name = "Filmer.findByBetyg", query = "SELECT f FROM Filmer f WHERE f.betyg = :betyg"),
    @NamedQuery(name = "Filmer.findByDatum", query = "SELECT f FROM Filmer f WHERE f.datum = :datum")})
public class Filmer implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "titel")
    private String titel;
    @Basic(optional = false)
    @Column(name = "regiss\u00f6r")
    private String regissör;
    @Basic(optional = false)
    @Column(name = "betyg")
    private double betyg;
    @Basic(optional = false)
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;

    public Filmer() {
    }

    public Filmer(String titel) {
        this.titel = titel;
    }

    public Filmer(String titel, String regissör, double betyg, Date datum) {
        this.titel = titel;
        this.regissör = regissör;
        this.betyg = betyg;
        this.datum = datum;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        String oldTitel = this.titel;
        this.titel = titel;
        changeSupport.firePropertyChange("titel", oldTitel, titel);
    }

    public String getRegissör() {
        return regissör;
    }

    public void setRegissör(String regissör) {
        String oldRegissör = this.regissör;
        this.regissör = regissör;
        changeSupport.firePropertyChange("regiss\u00f6r", oldRegissör, regissör);
    }

    public double getBetyg() {
        return betyg;
    }

    public void setBetyg(double betyg) {
        double oldBetyg = this.betyg;
        this.betyg = betyg;
        changeSupport.firePropertyChange("betyg", oldBetyg, betyg);
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        Date oldDatum = this.datum;
        this.datum = datum;
        changeSupport.firePropertyChange("datum", oldDatum, datum);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (titel != null ? titel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filmer)) {
            return false;
        }
        Filmer other = (Filmer) object;
        if ((this.titel == null && other.titel != null) || (this.titel != null && !this.titel.equals(other.titel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projekt2.Filmer[ titel=" + titel + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
