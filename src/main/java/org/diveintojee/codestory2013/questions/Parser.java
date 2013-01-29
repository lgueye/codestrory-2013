package org.diveintojee.codestory2013.questions;

import com.google.common.base.CharMatcher;

/**
 * @author louis.gueye@gmail.com
 */
public class Parser {

    int pos;
    String input;

    Parser(String input) {
        pos = 0;
        this.input = input;
    }

    char lookNext() {
        if (input.length() <= pos) {
            return '\n';
        }
        return input.charAt(pos);
    }

    char next() {
        char c = lookNext();
        pos++;
        return c;
    }

    boolean end() {
        return lookNext() == '\n';
    }

    String read(CharMatcher matcher) {
        StringBuilder sb = new StringBuilder();
        while (matcher.matches(lookNext())) {
            sb.append(next());
        }
        return sb.toString();
    }
}
