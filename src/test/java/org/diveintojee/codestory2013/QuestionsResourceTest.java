package org.diveintojee.codestory2013;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    assertFalse(underTest.isACalculation("Ceci est un texte comprenant (incluant) des parenthèses"));
  }



}
