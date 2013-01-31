package org.diveintojee.codestory2013.jajascript;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/**
 * @author louis.gueye@gmail.com
 */
@Component
public class JajascriptService {

    public Plan optimize(List<Rent> rents) {
        long start;
        Collections.sort(rents);
        int maxStart = resolveMaxStart(rents);
        // scan each hour for departures, starting from the last hour, ending at the first
        while (maxStart > -1) {
            System.out.println("current hour = " + maxStart);
            maxStart --;
        }
        return null;
    }

  private int resolveMaxStart(List<Rent> rents) {
    final Collection<Rent> iterable = Collections2.filter(rents, new Predicate<Rent>() {
      @Override
      public boolean apply(Rent input) {
        throw new UnsupportedOperationException("Not implemented");
        // return false;  //To change body of implemented methods use File | Settings | File Templates.
      }
    });
    return Iterables.getFirst(iterable, null).getStart();
  }
}
