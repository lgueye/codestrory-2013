package org.diveintojee.codestory2013.jajascript;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author louis.gueye@gmail.com
 */
public class JajascriptServiceTest {

    private JajascriptService underTest;

    @Before
    public void before() {
        underTest = new JajascriptService();
    }

    @Test
    public void optimizeShouldSucceed1() {
        Rent a = new Rent("a", 0, 5, 6);
        Rent b = new Rent("b", 4, 2, 9);
        Rent c = new Rent("c", 5, 10, 17);
        Rent d = new Rent("d", 6, 5, 11);
        Rent e = new Rent("e", 6, 4, 11);
        Rent f = new Rent("f", 11, 2, 7);
        List<Rent> rents = Lists.newArrayList(a, b, c, d, e, f);
        Plan expected = new Plan(Lists.newArrayList(b, e, f));
        Plan solution = underTest.optimize(rents);
        assertEquals(expected, solution);
    }

    @Test
    public void optimizeShouldSucceed2() {
        Rent a = new Rent("a", 0, 15, 75);
        Rent b = new Rent("b", 4, 2, 9);
        Rent c = new Rent("c", 5, 10, 17);
        Rent d = new Rent("d", 6, 5, 11);
        Rent e = new Rent("e", 6, 4, 11);
        Rent f = new Rent("f", 11, 2, 7);
        List<Rent> rents = Lists.newArrayList(a, b, c, d, e, f);
        Plan expected = new Plan(Lists.newArrayList(a));
        Plan solution = underTest.optimize(rents);
        assertEquals(expected, solution);
    }

    @Test
    public void optimizeShouldSucceed3() {
        Rent a = new Rent("a", 0, 2, 75);
        Rent b = new Rent("b", 3, 2, 9);
        Rent c = new Rent("c", 6, 2, 17);
        Rent d = new Rent("d", 9, 2, 11);
        Rent e = new Rent("e", 12, 2, 11);
        Rent f = new Rent("f", 15, 2, 7);
        List<Rent> rents = Lists.newArrayList(a, b, c, d, e, f);
        Plan expected = new Plan(rents);
        Plan solution = underTest.optimize(rents);
        assertEquals(expected, solution);
    }
}
