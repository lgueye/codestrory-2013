package org.diveintojee.codestory2013.scalaskel;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author louis.gueye@gmail.com
 */
@Component
public class ScalaskelService {

    public Map<Integer, List<Map<String, Integer>>> getChange(int id) {

        Map<Integer, List<Map<String, Integer>>> collecter = Maps.newHashMap();

        for (int foo = 0; foo <= 100; foo++)
            for (int bar = 0; bar <= 14; bar++)
                for (int qix = 0; qix <= 9; qix++)
                    for (int baz = 0; baz <= 4; baz++) {
                        if (foo + bar * 7 + qix * 11 + baz * 21 == id) {
                            if (collecter.get(id) == null) {
                                collecter.put(id,
                                        Lists.<Map<String, Integer>>newArrayList());
                            }
                            Map<String, Integer> match = new LinkedHashMap<String, Integer>();
                            if (foo > 0) match.put("foo", foo);
                            if (bar > 0) match.put("bar", bar);
                            if (qix > 0) match.put("qix", qix);
                            if (baz > 0) match.put("baz", baz);
                            collecter.get(id).add(match);
                        }
                    }
        return collecter;
    }
}
