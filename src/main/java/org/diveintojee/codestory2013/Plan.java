package org.diveintojee.codestory2013;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @author louis.gueye@gmail.com
 */
public class Plan implements Serializable {

  private Long gain = 0L;
  private Integer end = 0;
  private List<String> path = Lists.newArrayList();

  private List<Rent> rents = Lists.newArrayList();

  public Plan() {
  }

  public Plan(Long gain, List<String> path) {
    setGain(gain);
    setPath(path);
  }

  public Plan(Plan plan) {
    setGain(plan.getGain());
    this.rents = plan.getRents();
    this.path = plan.getPath();
  }

  public Long getGain() {
    return gain;
  }

  public void setGain(Long gain) {
    this.gain = gain;
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

    Plan that = (Plan) o;

    if (!gain.equals(that.gain)) {
      return false;
    }
    if (!path.equals(that.path)) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = gain.hashCode();
    result = 31 * result + path.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this).
        append("gain", gain).
        append("path", path).
        toString();
  }

  public boolean matches(Rent candidate) {
    System.out.println("running candidate = " + candidate);
    final Rent last = Iterables.getLast(rents, null);
    if(last == null || candidate.getStart() >= last.getEnd() && candidate.getEnd() <= 24) {
      this.end = candidate.getEnd();
      this.gain += candidate.getPrice();
      System.out.println("adding candidate = " + candidate);
      this.rents.add(candidate);
      return true;
    }
    return false;
  }

  @JsonIgnore
  public List<Rent> getRents() {
    return rents;
  }
}
