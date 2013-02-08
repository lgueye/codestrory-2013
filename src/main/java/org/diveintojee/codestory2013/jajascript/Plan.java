package org.diveintojee.codestory2013.jajascript;

import com.google.common.collect.Lists;

import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author louis.gueye@gmail.com
 */
public class Plan implements Serializable, Comparable<Plan> {

  private final Rent rent;
  private final Plan lastPlan;
  private int revenue;

  public Plan(Rent rent) {
    this(rent, null);
  }

  public Plan(Rent rent, Plan lastPlan) {
    this.rent = rent;
    this.lastPlan = lastPlan;
    this.revenue = (lastPlan != null ? lastPlan.getRevenue() : 0) + rent.getAmount();
  }

  @JsonProperty("path")
  public List<String> getPath() {
    final ArrayList<String> path = Lists.newArrayList();
    if (lastPlan != null) {
      path.addAll(lastPlan.getPath());
    }
    path.add(rent.getName());
    return path;
  }

  @JsonProperty("gain")
  public int getRevenue() {
    return revenue;
  }

  public Plan addRent(Rent rent) {
    return new Plan(rent, this);
  }

  public int compareTo(Plan other) {
    return this.getRevenue() - other.getRevenue();
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

    if (lastPlan != null ? !lastPlan.equals(plan.lastPlan) : plan.lastPlan != null) {
      return false;
    }
    if (!rent.equals(plan.rent)) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = rent.hashCode();
    result = 31 * result + (lastPlan != null ? lastPlan.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Plan{" +
           "gain=" + getRevenue() +
           ", path=" + getPath() +
           '}';
  }
}
