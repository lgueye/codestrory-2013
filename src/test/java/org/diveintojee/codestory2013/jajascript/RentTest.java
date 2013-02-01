package org.diveintojee.codestory2013.jajascript;

import com.google.common.collect.Lists;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author louis.gueye@gmail.com
 */
public class RentTest {

    @Test
    public void conflictsWithShouldSucceed() throws Exception {
        Rent a = new Rent("a", 0, 5, 6);
        Plan plan = new Plan(Lists.<Rent>newArrayList());
        plan.addRent(a);
        Rent b = new Rent("b", 4, 2, 9);
        assertTrue(b.conflictsWith(plan));

    }
}
