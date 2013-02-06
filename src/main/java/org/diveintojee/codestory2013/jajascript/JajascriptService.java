package org.diveintojee.codestory2013.jajascript;

import com.google.common.collect.Sets;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author louis.gueye@gmail.com
 */
@Component
public class JajascriptService {

  public Plan optimize(List<Rent> rents, final Map<Rent, Plan> cache) {
    long start;
    computeConflicts(rents);
    start = System.currentTimeMillis();
    Collections.sort(rents);
    final Plan solution = resolve(Sets.newLinkedHashSet(rents), cache);
    System.out.println("resolve took " + (System.currentTimeMillis() - start) + " ms");
    return solution;
  }

  public void computeConflicts(List<Rent> rents) {
    for (int i = 0; i < rents.size(); i++) {
      Rent current = rents.get(i);
      for (int j = i + 1; j < rents.size(); j++) {
        final Rent other = rents.get(j);
        if (current.conflictsWith(other)) {
          current.getConflicts().add(other);
          other.getConflicts().add(current);
        }
      }
    }
  }

  public Plan resolve(LinkedHashSet<Rent> remainings, final Map<Rent, Plan> cache) {
    if (!remainings.isEmpty()) {
      final Iterator<Rent> iterator = remainings.iterator();
      Rent current = iterator.next();
      if (cache.containsKey(current)) {
        return cache.get(current);
      }
      LinkedHashSet<Rent> newRemainings = Sets.newLinkedHashSet(remainings);
      newRemainings.remove(current);
      Plan result;
      if (conflictsWithAny(newRemainings, current)) {
        LinkedHashSet<Rent> cleanRemainings = Sets.newLinkedHashSet(newRemainings);
        cleanRemainings.removeAll(current.getConflicts());
        Plan resultLeft = resolve(cleanRemainings, cache).addRent(current);
        Plan resultRight = resolve(newRemainings, cache);
        result = resultLeft.getGain() > resultRight.getGain() ? resultLeft : resultRight;
      } else {
        result = resolve(newRemainings, cache).addRent(current);
      }
      cache.put(current, result);
      return result;
    } else {
      return Plan.EMPTY;
    }
  }

  private boolean conflictsWithAny(Set<Rent> newRemainings, Rent current) {
    return !Sets.intersection(current.getConflicts(), newRemainings).isEmpty();
  }
}
