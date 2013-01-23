package org.diveintojee.codestory2013;

import com.google.common.base.CharMatcher;

import org.springframework.stereotype.Component;

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

  public int getAnswer(String q) {
    Parser parser = new Parser(q);
    int result = evaluateSum(parser);
    if (!parser.end()) {
      throw new IllegalArgumentException("Unexpected trailing chars");
    }
    return result;
  }

  private int evaluateSum(Parser parser) {
    int left = evaluateFactor(parser);
    while (matchesSumOperator(parser)) {
      char operator = parser.next();
      int right = evaluateFactor(parser);
      if (operator == Operator.plus.getSymbol()) {
        left = left + right;
      } else {
        left = left - right;
      }
    }
    return left;
  }

  private boolean matchesSumOperator(Parser parser) {
    return CharMatcher.anyOf(Operator.plus.toString() + Operator.minus.toString()).matches(parser.lookNext());
  }

  private int evaluateFactor(Parser parser) {
    int left = evaluateExpression(parser);
    while (matchesFactorOperator(parser)) {
      char operator = parser.next();
      int right = evaluateExpression(parser);
      if (operator == Operator.multiply.getSymbol()) {
        left = left * right;
      } else {
        left = left / right;
      }
    }
    return left;
  }

  private boolean matchesFactorOperator(Parser parser) {
    return CharMatcher.anyOf(Operator.multiply.toString() + Operator.divide.toString()).matches(parser.lookNext());
  }

  private int evaluateExpression(Parser parser) {
    final char nextChar = parser.lookNext();
    if (CharMatcher.DIGIT.matches(nextChar)) {
      return parseLiteral(parser);
    } else if ('(' == nextChar) {
      parser.next();
      int result = evaluateSum(parser);
      char next = parser.next();
      if (next != ')') {
        throw new IllegalArgumentException("Unexpected token: " + next + ". Expected: ')'");
      }
      return result;
    } else {
      throw new IllegalArgumentException("Unexpected token: " + nextChar);
    }
  }

  private int parseLiteral(Parser input) {
    return Integer.parseInt(input.read(CharMatcher.DIGIT));
  }

}
