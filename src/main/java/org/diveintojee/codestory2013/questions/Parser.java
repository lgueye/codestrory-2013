package org.diveintojee.codestory2013.questions;

import com.google.common.base.CharMatcher;

/**
 * @author louis.gueye@gmail.com
 */
public class Parser {

    int position;
    String input;

    Parser(String input) {
        position = 0;
        this.input = input;
    }

    char lookNext() {
        if (input.length() <= position) {
            return '\n';
        }
        return input.charAt(position);
    }

    char next() {
        char c = lookNext();
        position++;
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
