package org.diveintojee.codestory2013;

/**
 * User: lgueye Date: 22/01/13 Time: 17:53
 */
public enum Operator {
    plus(' '), minus('-'), divide('/'), multiply('*');

    private Character symbol;

    private Operator(Character symbol) {
        this.symbol = symbol;
    }

    public Character getSymbol() {
        return symbol;
    }

    public String toString() {
        return String.valueOf(this.symbol);
    }

}
