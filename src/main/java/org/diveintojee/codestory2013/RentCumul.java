package org.diveintojee.codestory2013;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * User: lgueye Date: 28/01/13 Time: 14:43
 */
public class RentCumul {
  private Set<Rent> rents = new LinkedHashSet<Rent>();
  private int end;
  private int price;

  public int getEnd() {
    return end;
  }

  public void setEnd(int end) {
    this.end = end;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public void accept(Rent rent) {
    final Integer flightEnd = rent.getEnd();
    if ( flightEnd > getEnd() ) {
      setEnd(flightEnd);
      this.rents.add(rent);
    }
  }
}
