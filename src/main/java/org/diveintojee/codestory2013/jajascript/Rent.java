package org.diveintojee.codestory2013.jajascript;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author louis.gueye@gmail.com
 */
@XmlRootElement
public class Rent implements Serializable, Comparable<Rent> {

    private String vol;
    private Integer depart;
    private Integer duree;
    private Long prix;
    private Set<Rent> conflicts = new HashSet<Rent>();

    public Rent() {
    }

    public Rent(String vol, Integer depart, Integer duree, Long prix) {
        this.vol = vol;
        this.depart = depart;
        this.duree = duree;
        this.prix = prix;
    }

    public String getVol() {
        return vol;
    }

    public Integer getDepart() {
        return depart;
    }

    public Integer getDuree() {
        return duree;
    }

    public Long getPrix() {
        return prix;
    }

    @JsonIgnore
    public Set<Rent> getConflicts() {
        return conflicts;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }

    public void setDepart(Integer depart) {
        this.depart = depart;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public void setPrix(Long prix) {
        this.prix = prix;
    }

    public void setConflicts(Set<Rent> conflicts) {
        this.conflicts = conflicts;
    }

    public boolean conflictsWith(Rent other) {
        return getDepart() < other.getEnd() && getEnd() > other.getDepart();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Rent)) {
            return false;
        }

        Rent rent = (Rent) o;

        if (!vol.equals(rent.vol)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return vol.hashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).
                append("vol", vol).
                append("depart", depart).
                append("duree", duree).
                append("prix", prix).
                toString();
    }

    @JsonIgnore
    public Integer getEnd() {
        return this.depart + this.duree;
    }

    @Override
    public int compareTo(Rent o) {
        return this.depart - o.depart;
    }
}
