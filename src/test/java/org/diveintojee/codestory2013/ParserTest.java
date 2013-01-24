package org.diveintojee.codestory2013;

import com.google.common.base.CharMatcher;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author louis.gueye@gmail.com
 */
public class ParserTest {

    @Test
    public void readShoudHandleDoubles() {
        String q = "1.5";
        CharMatcher matcher = CharMatcher.anyOf("0123456789.");
        Parser parser = new Parser(q);
        assertEquals("1.5", parser.read(matcher));
    }

}
