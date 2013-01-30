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

    private String VOL;
    private Integer DEPART;
    private Integer DUREE;
    private Long PRIX;
    private Set<Rent> conflicts = new HashSet<Rent>();

    public Rent() {
    }

    public Rent(String VOL, Integer DEPART, Integer DUREE, Long PRIX) {
        this.VOL = VOL;
        this.DEPART = DEPART;
        this.DUREE = DUREE;
        this.PRIX = PRIX;
    }

    public String getVOL() {
        return VOL;
    }

    public Integer getDEPART() {
        return DEPART;
    }

    public Integer getDUREE() {
        return DUREE;
    }

    public Long getPRIX() {
        return PRIX;
    }

    @JsonIgnore
    public Set<Rent> getConflicts() {
        return conflicts;
    }

    public void setVOL(String VOL) {
        this.VOL = VOL;
    }

    public void setDEPART(Integer DEPART) {
        this.DEPART = DEPART;
    }

    public void setDUREE(Integer DUREE) {
        this.DUREE = DUREE;
    }

    public void setPRIX(Long PRIX) {
        this.PRIX = PRIX;
    }

    public void setConflicts(Set<Rent> conflicts) {
        this.conflicts = conflicts;
    }

    public boolean conflictsWith(Rent other) {
        return getDEPART() < other.getEnd() && getEnd() > other.getDEPART();
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

        if (!VOL.equals(rent.VOL)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return VOL.hashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).
                append("VOL", VOL).
                append("DEPART", DEPART).
                append("DUREE", DUREE).
                append("PRIX", PRIX).
                toString();
    }

    @JsonIgnore
    public Integer getEnd() {
        return this.DEPART + this.DUREE;
    }

    @Override
    public int compareTo(Rent o) {
        return this.DEPART - o.DEPART;
    }
}
