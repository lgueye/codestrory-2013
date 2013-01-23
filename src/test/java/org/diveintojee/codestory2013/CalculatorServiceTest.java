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
        assertEquals("8", underTest.getAnswer(q));
    }

    @Test
    public void getAnswerShouldSubtract() throws Exception {
        String q = "5-3";
        assertEquals("2", underTest.getAnswer(q));
    }

    @Test
    public void getAnswerShouldDivide() throws Exception {
        String q = "6/2";
        assertEquals("3", underTest.getAnswer(q));
    }

    @Test
    public void getAnswerShouldMultiply() throws Exception {
        String q = "7*3";
        assertEquals("21", underTest.getAnswer(q));
    }

    @Test
    public void matchesMultiplyOperationShouldSucceed() throws Exception {
        String q = "25*289";
        assertTrue(underTest.matchesMultiplyOperation(q));
    }

    @Test
    public void matchesMultiplyOperationShouldNotSucceed() throws Exception {
        String q = "a*1";
        assertFalse(underTest.matchesMultiplyOperation(q));
    }

    @Test
    public void matchesDivideOperationShouldSucceed() throws Exception {
        String q = "25/289";
        assertTrue(underTest.matchesDivideOperation(q));
    }

    @Test
    public void matchesDivideOperationShouldNotSucceed() throws Exception {
        String q = "a/1";
        assertFalse(underTest.matchesDivideOperation(q));
    }

    @Test
    public void matchesSubtractOperationShouldSucceed() throws Exception {
        String q = "289-21";
        assertTrue(underTest.matchesSubtractOperation(q));
    }

    @Test
    public void matchesSubtractOperationShouldNotSucceed() throws Exception {
        String q = "a-1";
        assertFalse(underTest.matchesSubtractOperation(q));
    }

    @Test
    public void matchesAddOperationShouldSucceed() throws Exception {
        String q = "25 289";
        assertTrue(underTest.matchesAddOperation(q));
    }

    @Test
    public void matchesAddOperationShouldNotSucceed() throws Exception {
        String q = "a+1";
        assertFalse(underTest.matchesAddOperation(q));
    }

    @Test
    public void getAnswerShoudHandleParenthesis() {
        String q = "(3*2)+1";
        assertEquals("7", underTest.getAnswer(q));
    }

}
