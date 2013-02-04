package org.diveintojee.codestory2013.jajascript;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author louis.gueye@gmail.com
 */
public class Plan implements Serializable, Comparable<Plan> {

    private List<Rent> rents;

    public Plan(List<Rent> rents) {
        this.rents = rents;
    }

    public static Plan fromPlan(Plan plan) {
        Plan tmp = new Plan(Lists.<Rent>newLinkedList());
        for (Rent rent : plan.getRents()) {
            tmp.addRent(rent);
        }
        return tmp;
    }

    @JsonProperty("path")
    public List<String> getPath() {
        return Lists.newArrayList(Collections2.transform(this.rents, new Function<Rent, String>() {
            @Override
            public String apply(Rent input) {
                return input.getName();
            }
        }));
    }

    @JsonProperty("gain")
    public int getRevenue() {
        int revenue = 0;
        for (Rent rent : rents) {
            revenue += rent.getAmount();
        }
        return revenue;
    }

    public void addRent(Rent rent) {
        this.rents.add(rent);
    }

    public int compareTo(Plan other) {
        return other.getRevenue() - this.getRevenue();
    }

    @JsonIgnore
    public int getEnd() {
        int end = 0;
        for (Rent rent : rents) {
            if (rent.getEnd() > end) end = rent.getEnd();
        }
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plan plan = (Plan) o;

        if (!rents.equals(plan.rents)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return rents.hashCode();
    }

    @Override
    public String toString() {
        return "Plan{" +
                "gain=" + getRevenue() +
                ", path=" + getPath() +
                '}';
    }

    public List<Rent> getRents() {
        return rents;
    }
}
