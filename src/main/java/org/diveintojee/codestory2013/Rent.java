package org.diveintojee.codestory2013;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author louis.gueye@gmail.com
 */
@XmlRootElement
public class Rent implements Serializable, Comparable<Rent>{

  private String name;
  private Integer start;
  private Integer duration;
  private Long price;

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

  public void setName(String name) {
    this.name = name;
  }

  public Integer getStart() {
    return start;
  }

  public void setStart(Integer start) {
    this.start = start;
  }

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Rent)) {
      return false;
    }

    Rent flight = (Rent) o;

    if (!duration.equals(flight.duration)) {
      return false;
    }
    if (!name.equals(flight.name)) {
      return false;
    }
    if (!price.equals(flight.price)) {
      return false;
    }
    if (!start.equals(flight.start)) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = name.hashCode();
    result = 31 * result + start.hashCode();
    result = 31 * result + duration.hashCode();
    result = 31 * result + price.hashCode();
    return result;
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
    return this.start+this.duration;
  }

  @Override
  public int compareTo(Rent o) {
    return this.start-o.start;
  }
}
