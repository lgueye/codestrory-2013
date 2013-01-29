package org.diveintojee.codestory2013.jajascript;

import com.google.common.collect.Lists;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.List;

/**
 * @author louis.gueye@gmail.com
 */
public class Plan implements Serializable {

    private List<String> path = Lists.newArrayList();

    private List<Rent> rents = Lists.newArrayList();

    public Plan(List<Rent> rents) {
        this.rents = rents;
    }

    public Long getGain() {
        long gain = 0;
        for (Rent rent : rents) {
            gain += rent.getPrice();
        }
        return gain;
    }

    public List<String> getPath() {
        return path;
    }

    public void setPath(List<String> path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Plan)) {
            return false;
        }

        Plan plan = (Plan) o;

        if (!rents.equals(plan.rents)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return rents.hashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).
                append("gain", getGain()).
                append("path", path).
                toString();
    }

    @JsonIgnore
    public List<Rent> getRents() {
        return rents;
    }
}
