package org.diveintojee.codestory2013;

import com.google.common.base.CharMatcher;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * ;Calculator Service Grammar expressed in EBNF
 * sum            := factor (sumOperator factor)*;
 * factor         := expression (factorOperator expression)*;
 * expression     := literal | lparen sum rparen;
 * sumOperator    :== ('+'|'-');
 * factorOperator :== ('*'|'/');
 * literal        :== ('1'..'9')+;
 * lparen         :== '(';
 * rparen         :== ')';
 *
 * @author louis.gueye@gmail.com
 */
@Component
public class CalculatorService {

    public BigDecimal getAnswer(String q) {
        Parser parser = new Parser(q);
        BigDecimal result = evaluateSum(parser);
        if (!parser.end()) {
            throw new IllegalArgumentException("Unexpected trailing chars, got " + parser.lookNext());
        }
//        System.out.println("evaluated answer = " + result);
        return result;
    }

    private BigDecimal evaluateSum(Parser parser) {
        BigDecimal left = evaluateFactor(parser);
        while (matchesSumOperator(parser)) {
            char operator = parser.next();
            BigDecimal right = evaluateFactor(parser);
            if (operator == Operator.plus.getSymbol()) {
                left = left.add(right);
            } else {
                left = left.add(right.negate());
            }
        }
//        System.out.println("evaluated sum = " + left);
        return left;
    }

    private boolean matchesSumOperator(Parser parser) {
        return CharMatcher.anyOf(Operator.plus.toString() + Operator.minus.toString()).matches(parser.lookNext());
    }

    private BigDecimal evaluateFactor(Parser parser) {
        BigDecimal left = evaluateExpression(parser);
        while (matchesFactorOperator(parser)) {
            char operator = parser.next();
            BigDecimal right = evaluateExpression(parser);
            if (operator == Operator.multiply.getSymbol()) {
                left = left.multiply(right);
            } else {
                left = left.divide(right);
            }
        }
//        System.out.println("evaluated factor = " + left);
        return left;
    }

    private boolean matchesFactorOperator(Parser parser) {
        return CharMatcher.anyOf(Operator.multiply.toString() + Operator.divide.toString()).matches(parser.lookNext());
    }

    private BigDecimal evaluateExpression(Parser parser) {
        final char nextChar = parser.lookNext();
        if (CharMatcher.DIGIT.matches(nextChar)) {
            final BigDecimal v = parseLiteral(parser);
//            System.out.println("parsed literal = " + v);
            return v;
        } else if ('(' == nextChar) {
            parser.next();
            BigDecimal result = evaluateSum(parser);
            char next = parser.next();
            if (next != ')') {
                throw new IllegalArgumentException("Unexpected token: " + next + ". Expected: ')'");
            }
//            System.out.println("evaluated expression = " + result);
            return result;
        } else {
            throw new IllegalArgumentException("Unexpected token: " + nextChar);
        }
    }

    private BigDecimal parseLiteral(Parser parser) {
        final String legalChars = "0123456789,";
        final String literalAsString = parser.read(CharMatcher.anyOf(legalChars));
        try {
            return new BigDecimal(literalAsString.replaceAll(",", "."));
        } catch (Exception e) {
            final String message = "Parse failed for input [" + literalAsString + "]. Legal chars are [" + legalChars + "]";
            throw new IllegalArgumentException(message);
        }
    }

}
