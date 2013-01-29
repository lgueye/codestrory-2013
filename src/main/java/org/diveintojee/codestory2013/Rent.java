package org.diveintojee.codestory2013;

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

    private String name;
    private Integer start;
    private Integer duration;
    private Long price;
    private Set<Rent> conflicts = new HashSet<Rent>();

    public Rent() {
    }

    public Rent(String name, Integer start, Integer duration, Long price) {
        this.name = name;
        this.start = start;
        this.duration = duration;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getDuration() {
        return duration;
    }

    public Long getPrice() {
        return price;
    }

    public Set<Rent> getConflicts() {
        return conflicts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setConflicts(Set<Rent> conflicts) {
        this.conflicts = conflicts;
    }

    public boolean conflictsWith(Rent other) {
        return getStart() < other.getEnd() && getEnd() > other.getStart();
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

        if (!name.equals(rent.name)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).
                append("name", name).
                append("start", start).
                append("duration", duration).
                append("price", price).
                toString();
    }

    @JsonIgnore
    public Integer getEnd() {
        return this.start + this.duration;
    }

    @Override
    public int compareTo(Rent o) {
        return this.start - o.start;
    }
}
