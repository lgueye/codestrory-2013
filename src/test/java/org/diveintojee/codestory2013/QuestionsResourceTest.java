package org.diveintojee.codestory2013;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * User: lgueye Date: 24/01/13 Time: 11:29
 */
public class QuestionsResourceTest {

    private QuestionsResource underTest;

    @Before
    public void before() {
        underTest = new QuestionsResource();
    }

    @Test
    public void isACalculationShouldSucceed() throws Exception {
        assertTrue(underTest.isACalculation("(1 2)*2"));
        assertTrue(underTest.isACalculation("2*2"));
        assertTrue(underTest.isACalculation("2 2"));
    }

    @Test
    public void isACalculationShouldFail() throws Exception {
        assertFalse(underTest.isACalculation("( je suis ton père )"));
        assertFalse(
                underTest.isACalculation("Ceci est un texte comprenant (incluant) des parenthèses"));
    }

    @Test
    public void frenchFormatShouldSucceed() throws Exception {
        BigDecimal result = new BigDecimal("31878018903828899277492024491376690701584023926880.7");
        assertEquals("31878018903828899277492024491376690701584023926880,7", underTest.frenchFormat(result));
    }

    @Test
    public void frenchFormatShouldStripTrailingZeros() throws Exception {
        BigDecimal result = new BigDecimal("31878018903828899277492024491376690701584023926880.00");
        assertEquals("31878018903828899277492024491376690701584023926880", underTest.frenchFormat(result));
    }

}
