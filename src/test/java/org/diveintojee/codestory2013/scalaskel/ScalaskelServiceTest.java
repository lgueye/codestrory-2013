package org.diveintojee.codestory2013.scalaskel;

import com.google.common.collect.Iterables;
import org.diveintojee.codestory2013.scalaskel.ScalaskelService;
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
    public void before() {
        underTest = new ScalaskelService();
    }

    @Test
    public void getChangeShouldReturn1000For1() throws Exception {
        int amount = 1;
        Map<Integer, List<Map<String, Integer>>> result = underTest.getChange(amount);
        List<Map<String, Integer>> matches = result.get(amount);
        assertNotNull(matches);
        assertEquals(1, matches.size());
        Map<String, Integer> firstMatch = Iterables.getOnlyElement(matches);
        assertEquals(Integer.valueOf(1), firstMatch.get("foo"));
        assertEquals(null, firstMatch.get("bar"));
        assertEquals(null, firstMatch.get("qix"));
        assertEquals(null, firstMatch.get("baz"));
    }

}
