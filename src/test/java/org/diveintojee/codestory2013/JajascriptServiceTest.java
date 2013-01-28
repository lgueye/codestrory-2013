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
    final Plan expected = new Plan(18L, Lists.newArrayList("a", "c"));
    assertEquals(expected, underTest.optimize(rents));
  }
}
