package org.diveintojee.codestory2013.jajascript;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author louis.gueye@gmail.com
 */
public class Plan implements Serializable {

  public static final Plan EMPTY = new Plan(Lists.<Rent>newArrayList(), 0L);

    private List<Rent> rents = Lists.newArrayList();
    private long gain = -1;

    public Plan(List<Rent> rents) {
        this.rents = rents;
    }

  public Plan(List<Rent> rents, long gain) {
      this.rents = rents;
    this.gain = gain;
  }

    public Plan addRent(Rent rent) {
      List<Rent> newRents = Lists.newArrayList(rent);
      newRents.addAll(rents);
      return new Plan(newRents, this.gain + rent.getAmount());
    }

    public Long getGain() {
      if (this.gain == -1) {
        long gain = 0;
        for (Rent rent : rents) {
          gain += rent.getAmount();
        }
        this.gain = gain;
      }
      return this.gain;
    }

    public List<String> getPath() {
      final List<Rent> copy = Lists.newLinkedList(getRents());
      Collections.sort(copy);
        Collection<String> names = Collections2.transform(copy, new Function<Rent, String>() {
            @Override
            public String apply(Rent input) {
                return input.getName();
            }
        });

        return Lists.newArrayList(names);
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
                append("path", getPath()).
                toString();
    }

    @JsonIgnore
    public List<Rent> getRents() {
        return rents;
    }
}
