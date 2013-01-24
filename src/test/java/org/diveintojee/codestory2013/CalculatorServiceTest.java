package org.diveintojee.codestory2013;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * User: lgueye Date: 22/01/13 Time: 18:40
 */
public class CalculatorServiceTest {

    private CalculatorService underTest;

    @Before
    public void before() {
        underTest = new CalculatorService();
    }

    @Test
    public void getAnswerShouldAdd() throws Exception {
        String q = "3 5";
        assertEquals(8.0, underTest.getAnswer(q) ,0);
    }

    @Test
    public void getAnswerShouldSubtract() throws Exception {
        String q = "5-3";
        assertEquals(2.0, underTest.getAnswer(q) ,0);
    }

    @Test
    public void getAnswerShouldDivide() throws Exception {
        String q = "6/2";
        assertEquals(3.0, underTest.getAnswer(q) ,0);
    }

    @Test
    public void getAnswerShouldMultiply() throws Exception {
        String q = "7*3";
        assertEquals(21.0, underTest.getAnswer(q), 0);
    }

    @Test
    public void getAnswerShoudHandleParenthesis() {
        String q = "(3*2) 1";
        assertEquals(7, underTest.getAnswer(q) ,0);
    }

  @Test
  public void getAnswerShoudHandleComplexExpression() {
      String q = "((3*2) 2)/2 (3-1)";
      assertEquals(6, underTest.getAnswer(q) ,0);
  }

  @Test
  public void getAnswerShoudHandlePrecedence() {
      String q = "2 15*3-1";
      assertEquals(46, underTest.getAnswer(q) ,0);
  }

  @Test
  public void getAnswerShoudHandleDoubles() {
      String q = "(1 2)/2";
      assertEquals(1.5, underTest.getAnswer(q) ,0);
  }

}
