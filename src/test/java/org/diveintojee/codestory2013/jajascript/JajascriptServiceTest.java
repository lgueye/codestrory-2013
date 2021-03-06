package org.diveintojee.codestory2013.jajascript;

import com.google.common.collect.Lists;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
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
        final Rent a = new Rent("a", 0, 5, 10);
        rents.add(a);
        final Rent b = new Rent("b", 3, 7, 14);
        rents.add(b);
        final Rent c = new Rent("c", 5, 9, 8);
        rents.add(c);
        final Rent d = new Rent("d", 5, 9, 7);
        rents.add(d);
        final Plan plan = underTest.optimize(rents, new HashMap<Rent, Plan>());
        assertEquals(18L, (long) plan.getGain());
        assertEquals(Lists.newArrayList(a, c), plan.getRents());
    }

    @Test
    public void testOptimize2() throws Exception {
        List<Rent> rents = Lists.newArrayList();
        final Rent a = new Rent("a", 0, 2, 10);
        rents.add(a);
        final Rent b = new Rent("b", 1, 2, 9);
        rents.add(b);
        final Rent c = new Rent("c", 1, 3, 7);

        rents.add(c);
        final Rent d = new Rent("d", 2, 3, 15);
        rents.add(d);
        final Rent e = new Rent("e", 2, 1, 22);
        rents.add(e);
        final Rent f = new Rent("f", 0, 1, 25);
        rents.add(f);
        final Rent g = new Rent("g", 1, 1, 17);
        rents.add(g);
        final Plan plan = underTest.optimize(rents, new HashMap<Rent, Plan>());
        assertEquals(Lists.newArrayList(f, g, e), plan.getRents());
      assertEquals(64L, (long) plan.getGain());
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
      Plan solution = underTest.optimize(rents, new HashMap<Rent, Plan>());
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
      Plan solution = underTest.optimize(rents, new HashMap<Rent, Plan>());
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
      Plan solution = underTest.optimize(rents, new HashMap<Rent, Plan>());
      assertEquals(expected, solution);
  }

  @Test
  public void optimizeShouldSucceed4() {
      Rent a = new Rent("dark-playwright-49", 0, 5, 17);
      Rent b = new Rent("curious-toupee-34",0, 4, 2);
      Rent c = new Rent("swift-whirlwind-45",2, 2, 15);
      Rent d = new Rent("wide-eyed-workaholic-58",3, 1, 8);
      Rent e = new Rent("shy-vengeance-31",3, 14, 4);
      Rent f = new Rent("long-alcohol-70",6, 8, 24);
      Rent g = new Rent("sleepy-squabble-79",6, 2, 5);
      Rent h = new Rent("chubby-madwoman-24",7, 5, 1);
      Rent i = new Rent("eager-arsonist-2",7, 9, 6);
      Rent j = new Rent("tender-knitter-21",7, 15, 5);
      Rent k = new Rent("Early-hailstorm-74",10, 10, 21);
      Rent l = new Rent("hollow-slumlord-84",11, 4, 12);
      Rent m = new Rent("modern-lava-64",14, 9, 21);
      Rent n = new Rent("great-bather-46",14, 6, 6);
      Rent o = new Rent("round-tombstone-50",14, 3, 4);
      Rent p = new Rent("repulsive-saltwater-80",16, 11, 3);
      Rent q = new Rent("silent-shotgun-20",17, 9, 2);
      Rent r = new Rent("obedient-squirrel-22",19, 3, 6);
      Rent s = new Rent("bad-developer-97",19, 2, 5);
      Rent t = new Rent("dead-bead-29",19, 10, 7);
      Rent u = new Rent("clever-weakling-38",20, 7, 7);
      Rent v = new Rent("condemned-minion-8",20, 12, 1);
      Rent w = new Rent("joyous-yodeler-88",21, 3, 8);
      Rent x = new Rent("quick-blackjack-8",22, 8, 23);
      Rent y = new Rent("harsh-sword-34",23, 1, 23);
      Rent z = new Rent("puny-judo-34",27, 1, 2);
      Rent ab = new Rent("big-grail-71",28, 10, 4);
      Rent ac = new Rent("stupid-reformer-69",29, 3, 12);
      Rent ad = new Rent("tender-quagmire-69",29, 8, 4);
      Rent ae = new Rent("modern-corn-95",29, 3, 6);
      Rent af = new Rent("breakable-switchhitter-68",30, 10, 15);
      Rent ag = new Rent("young-revolutionary-2",30, 7, 10);
      Rent ah = new Rent("open-fowl-8",31, 5, 10);
      Rent ai = new Rent("important-temper-21",31, 3, 7);
      Rent aj = new Rent("blue-eyed-fishnet-70",32, 4, 22);
      Rent ak = new Rent("bad-instep-1",36, 8, 21);
      Rent al = new Rent("brainy-stereo-9",35, 1, 11);
      Rent am = new Rent("hushed-fencer-85",37, 1, 8);
      Rent an = new Rent("homeless-warship-63",39, 8, 16);
      Rent ao = new Rent("modern-oak-72",38, 11, 2);
      Rent ap = new Rent("weary-bonbon-33",40, 9, 1);
      Rent aq = new Rent("defeated-plaster-4",41, 3, 14);
      Rent ar = new Rent("jittery-letter-36",43, 3, 5);
      Rent as = new Rent("doubtful-jawbone-8",43, 6, 10);
      Rent at = new Rent("repulsive-teacup-84",43, 2, 1);
      List<Rent> rents = Lists.<Rent>newArrayList(a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,ab,ac,ad,ae, af, ag, ah, ai, aj, ak, al, am, an, ao, ap, aq, ar, as, at);
      final Plan expected = new Plan(Lists.newArrayList(a, f, m, y, z, ac, aj, am, an));
      final Plan actual = underTest.optimize(rents, new HashMap<Rent, Plan>());
      assertEquals(expected, actual);
  }
}
