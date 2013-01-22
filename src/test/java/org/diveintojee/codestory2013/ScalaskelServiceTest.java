package org.diveintojee.codestory2013;

import com.google.common.collect.Iterables;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author louis.gueye@gmail.com
 */
public class ScalaskelServiceTest {

    private ScalaskelService underTest;

    @Before
    public void before () {
        underTest = new ScalaskelService();
    }

    @Test
    public void getChangeShouldReturn1000For1() throws Exception {
        int amount = 1;
        Map<Integer, List<Map<String,Integer>>> result = underTest.getChange(amount);
        List<Map<String, Integer>> matches = result.get(amount);
        assertNotNull(matches);
        assertEquals(1, matches.size());
        Map<String, Integer> firstMatch = Iterables.getOnlyElement(matches);
        assertEquals(Integer.valueOf(1), firstMatch.get("foo"));
        assertEquals(Integer.valueOf(0), firstMatch.get("bar"));
        assertEquals(Integer.valueOf(0), firstMatch.get("qix"));
        assertEquals(Integer.valueOf(0), firstMatch.get("baz"));
    }

    @Test
    public void getChangeShouldReturn6000For6() throws Exception {
        int amount = 6;
        Map<Integer, List<Map<String,Integer>>> result = underTest.getChange(amount);
        List<Map<String, Integer>> matches = result.get(amount);
        assertNotNull(matches);
        assertEquals(1, matches.size());
        Map<String, Integer> firstMatch = Iterables.getOnlyElement(matches);
        assertEquals(Integer.valueOf(6), firstMatch.get("foo"));
        assertEquals(Integer.valueOf(0), firstMatch.get("bar"));
        assertEquals(Integer.valueOf(0), firstMatch.get("qix"));
        assertEquals(Integer.valueOf(0), firstMatch.get("baz"));
    }

    @Test
    public void getChangeShouldReturn7000Or0100For7() throws Exception {
        int amount = 7;
        Map<Integer, List<Map<String,Integer>>> result = underTest.getChange(amount);
        List<Map<String, Integer>> matches = result.get(amount);
        assertNotNull(matches);
        assertEquals(2, matches.size());
        Map<String, Integer> firstMatch = Iterables.getFirst(matches, null);
        assertEquals(Integer.valueOf(7), firstMatch.get("foo"));
        assertEquals(Integer.valueOf(0), firstMatch.get("bar"));
        assertEquals(Integer.valueOf(0), firstMatch.get("qix"));
        assertEquals(Integer.valueOf(0), firstMatch.get("baz"));
        Map<String, Integer> lastMatch = Iterables.getLast(matches, null);
        assertEquals(Integer.valueOf(7), lastMatch.get("foo"));
        assertEquals(Integer.valueOf(0), lastMatch.get("bar"));
        assertEquals(Integer.valueOf(0), lastMatch.get("qix"));
        assertEquals(Integer.valueOf(0), lastMatch.get("baz"));
    }

}
