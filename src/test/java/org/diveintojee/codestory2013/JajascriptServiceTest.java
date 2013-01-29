package org.diveintojee.codestory2013;

import com.google.common.collect.Lists;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author louis.gueye@gmail.com
 */
public class JajascriptServiceTest {

  JajascriptService underTest;

  @Before
  public void before() {
    underTest = new JajascriptService();
  }

  @Test
  public void testOptimize() throws Exception {
    List<Rent> rents = Lists.newArrayList();
    final Rent a = new Rent("a", 0, 5, 10L);
    rents.add(a);
    final Rent b = new Rent("b", 3, 7, 14L);
    rents.add(b);
    final Rent c = new Rent("c", 5, 9, 8L);
    rents.add(c);
    final Rent d = new Rent("d", 5, 9, 7L);
    rents.add(d);
    final Plan plan = underTest.optimize(rents);
    assertEquals(18L, (long) plan.getGain());
    assertEquals(Lists.newArrayList(a, c), plan.getRents());
  }

  @Test
  public void testOptimize2() throws Exception {
    List<Rent> rents = Lists.newArrayList();
    final Rent a = new Rent("a", 0, 2, 10L);
    rents.add(a);
    final Rent b = new Rent("b", 1, 2, 9L);
    rents.add(b);
    final Rent c = new Rent("c", 1, 3, 7L);
    rents.add(c);
    final Rent d = new Rent("d", 2, 3, 15L);
    rents.add(d);
    final Rent e = new Rent("e", 2, 1, 22L);
    rents.add(e);
    final Rent f = new Rent("f", 0, 1, 25L);
    rents.add(f);
    final Rent g = new Rent("g", 1, 1, 17L);
    rents.add(g);
    final Plan plan = underTest.optimize(rents);
    assertEquals(64L, (long) plan.getGain());
    assertEquals(Lists.newArrayList(e, f, g), plan.getRents());
  }
}
