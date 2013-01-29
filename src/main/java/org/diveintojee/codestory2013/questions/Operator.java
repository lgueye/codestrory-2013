package org.diveintojee.codestory2013.questions;

/**
 * @author louis.gueye@gmail.com
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
