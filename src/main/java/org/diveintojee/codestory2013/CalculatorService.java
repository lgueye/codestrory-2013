package org.diveintojee.codestory2013;

import com.google.common.base.CharMatcher;

import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

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


  public static final NumberFormat NUMBER_FORMATTER = NumberFormat.getInstance(Locale.FRANCE);


  public double getAnswer(String q) {
    Parser parser = new Parser(q);
    double result = evaluateSum(parser);
    if (!parser.end()) {
      throw new IllegalArgumentException("Unexpected trailing chars, got " + parser.lookNext());
    }
    System.out.println("evaluated answer = " + result);
    return result;
  }

  private double evaluateSum(Parser parser) {
    double left = evaluateFactor(parser);
    while (matchesSumOperator(parser)) {
      char operator = parser.next();
      double right = evaluateFactor(parser);
      if (operator == Operator.plus.getSymbol()) {
        left = left + right;
      } else {
        left = left - right;
      }
    }
    System.out.println("evaluated sum = " + left);
    return left;
  }

  private boolean matchesSumOperator(Parser parser) {
    return CharMatcher.anyOf(Operator.plus.toString() + Operator.minus.toString()).matches(parser.lookNext());
  }

  private double evaluateFactor(Parser parser) {
    double left = evaluateExpression(parser);
    while (matchesFactorOperator(parser)) {
      char operator = parser.next();
      double right = evaluateExpression(parser);
      if (operator == Operator.multiply.getSymbol()) {
        left = left * right;
      } else {
        left = left / right;
      }
    }
    System.out.println("evaluated factor = " + left);
    return left;
  }

  private boolean matchesFactorOperator(Parser parser) {
    return CharMatcher.anyOf(Operator.multiply.toString() + Operator.divide.toString()).matches(parser.lookNext());
  }

  private double evaluateExpression(Parser parser) {
    final char nextChar = parser.lookNext();
    if (CharMatcher.DIGIT.matches(nextChar)) {
      final double v = parseLiteral(parser);
      System.out.println("parsed literal = " + v);
      return v;
    } else if ('(' == nextChar) {
      parser.next();
      double result = evaluateSum(parser);
      char next = parser.next();
      if (next != ')') {
        throw new IllegalArgumentException("Unexpected token: " + next + ". Expected: ')'");
      }
      System.out.println("evaluated expression = " + result);
      return result;
    } else {
      throw new IllegalArgumentException("Unexpected token: " + nextChar);
    }
  }

  private double parseLiteral(Parser parser) {
    final String legalChars = "0123456789,";
    final String literalAsString = parser.read(CharMatcher.anyOf(legalChars));
    try {
      return NUMBER_FORMATTER.parse(literalAsString).doubleValue();
    } catch (ParseException e) {
      final String message = "Parse failed for input [" + literalAsString + "]. Legal chars are [" + legalChars + "]";
      throw new IllegalArgumentException(message);
    }
  }

}
