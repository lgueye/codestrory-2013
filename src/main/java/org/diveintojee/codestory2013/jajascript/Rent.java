package org.diveintojee.codestory2013.jajascript;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author louis.gueye@gmail.com
 */
@XmlRootElement
public class Rent implements Serializable, Comparable<Rent> {

    @JsonProperty("VOL")
    private String name;
    @JsonProperty("DEPART")
    private int start;
    @JsonProperty("DUREE")
    private int duration;
    @JsonProperty("PRIX")
    private int amount;

    public Rent() {
    }

    public Rent(String name, int start, int duration, int amount) {
        this.name = name;
        this.start = start;
        this.duration = duration;
        this.amount = amount;
    }

    @JsonIgnore
    public Integer getEnd() {
        return this.start + this.duration;
    }

    @Override
    public int compareTo(Rent o) {
        return this.start - o.start;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rent rent = (Rent) o;

        if (!name.equals(rent.name)) return false;

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
                append("amount", amount).
                toString();
    }
}
