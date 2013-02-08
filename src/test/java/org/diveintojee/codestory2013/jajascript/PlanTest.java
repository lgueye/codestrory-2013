package org.diveintojee.codestory2013.jajascript;

import com.google.common.collect.Lists;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author louis.gueye@gmail.com
 */
public class PlanTest {

    @Test
    public void compareToShouldSucceed() throws Exception {
      Rent a = new Rent("a", 0, 5, 6);
      Plan planA = new Plan(a);
      Rent b = new Rent("b", 4, 2, 9);
      Plan planB = new Plan(b);
      assertTrue(planB.compareTo(planA) > 0);
    }

}
