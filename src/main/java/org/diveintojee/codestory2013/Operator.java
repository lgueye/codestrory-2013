package org.diveintojee.codestory2013;

/**
 * User: lgueye Date: 22/01/13 Time: 17:53
 */
public enum Operator {
  plus("+"),minus("-"),divide("/"),multiply("*");

  private String symbol;

  private Operator(String symbol) {
    this.symbol = symbol;
  }

  public String toString() {
    return this.symbol;
  }

}
