package org.diveintojee.codestory2013;

import org.springframework.stereotype.Component;

/**
 * User: lgueye Date: 22/01/13 Time: 17:49
 */
@Component
public class CalculatorService {

    public String getAnswer(String q) {
        Operator operator = resolveOperator(q);
        int[] operandes = resolveOperandes(operator, q);
        switch (operator) {
            case plus:
                return String.valueOf(operandes[0] + operandes[1]);
            case multiply:
                return String.valueOf(operandes[0] * operandes[1]);
            case divide:
                return String.valueOf(operandes[0] / operandes[1]);
            case minus:
                return String.valueOf(operandes[0] - operandes[1]);
        }
        return "";
    }

    private int[] resolveOperandes(Operator operator, String q) {
        String[] operandes = q.split("\\" + operator.toString());
        int[] operandesAsInt = new int[operandes.length];
        for (int i = 0; i < operandes.length; i++) {
            String operande = operandes[i];
            operandesAsInt[i] = Integer.valueOf(operande);
        }
        return operandesAsInt;
    }

    private Operator resolveOperator(String q) {
        if (matchesSubtractOperation(q)) {
            return Operator.minus;
        } else if (matchesAddOperation(q)) {
            return Operator.plus;
        } else if (matchesDivideOperation(q)) {
            return Operator.divide;
        } else if (matchesMultiplyOperation(q)) {
            return Operator.multiply;
        } else {
            throw new UnsupportedOperationException("Unknown operator in question " + q);
        }

    }

    boolean matchesMultiplyOperation(String q) {
        return q.matches("\\d+[\\*]\\d+");
    }

    boolean matchesDivideOperation(String q) {
        return q.matches("\\d+[/]\\d+");
    }

    boolean matchesAddOperation(String q) {
        return q.matches("\\d+[\\s]\\d+");
    }

    boolean matchesSubtractOperation(String q) {
        return q.matches("\\d+[\\-]\\d+");
    }


}
