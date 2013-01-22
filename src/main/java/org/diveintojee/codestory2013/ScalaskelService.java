package org.diveintojee.codestory2013;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

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
            for (int bar = 0; bar <= 100; bar++)
                for (int qix = 0; qix <= 100; qix++)
                    for (int baz = 0; baz <= 100; baz++)
                        if (foo * 1 + bar * 7 + qix * 11 + baz * 21 == id) {
                            System.out.println("found matching amount = {'foo':" + foo + ", 'bar':" + bar + ", 'qix':" + qix + ", 'baz':" + baz + "}");
                            if (collecter.get(id) == null)
                                collecter.put(Integer.valueOf(id), Lists.<Map<String, Integer>>newArrayList());
                            Map<String, Integer> match = Maps.newHashMap();
                            match.put("foo", foo);
                            match.put("bar", bar);
                            match.put("qix", qix);
                            match.put("baz", baz);
                            collecter.get(id).add(match);
                        }

        return collecter;
        //throw new UnsupportedOperationException("Not yet implemented");
    }
}
