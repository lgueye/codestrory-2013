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
        assertEquals(8, underTest.getAnswer(q));
    }

    @Test
    public void getAnswerShouldSubtract() throws Exception {
        String q = "5-3";
        assertEquals(2, underTest.getAnswer(q));
    }

    @Test
    public void getAnswerShouldDivide() throws Exception {
        String q = "6/2";
        assertEquals(3, underTest.getAnswer(q));
    }

    @Test
    public void getAnswerShouldMultiply() throws Exception {
        String q = "7*3";
        assertEquals(21, underTest.getAnswer(q));
    }

    @Test
    public void getAnswerShoudHandleParenthesis() {
        String q = "(3*2) 1";
        assertEquals(7, underTest.getAnswer(q));
    }

  @Test
  public void getAnswerShoudComplexExpression() {
      String q = "((3*2) 2)/2 (3-1)";
      assertEquals(6, underTest.getAnswer(q));
  }

  @Test
  public void getAnswerShoudHandlePrecedence() {
      String q = "2 15*3-1";
      assertEquals(46, underTest.getAnswer(q));
  }

}
