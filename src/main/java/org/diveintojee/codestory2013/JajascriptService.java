package org.diveintojee.codestory2013;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * @author louis.gueye@gmail.com
 */
@Component
public class JajascriptService {

  public Plan optimize(List<Rent> rents) {
    computeConflicts(rents);
    return resolve(Lists.<Rent>newArrayList(), Sets.newLinkedHashSet(rents));
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

  public Plan resolve(List<Rent> selected, LinkedHashSet<Rent> remainings) {
    if (!remainings.isEmpty()) {
      LinkedHashSet<Rent> newRemainings = Sets.newLinkedHashSet(remainings);
      final Iterator<Rent> iterator = newRemainings.iterator();
      Rent current = iterator.next();
      iterator.remove();
      if (conflictsWithAny(newRemainings, current)) {
        List<Rent> selectedLeft = Lists.newArrayList(selected);
        selectedLeft.add(current);
        LinkedHashSet<Rent> cleanRemainings = Sets.newLinkedHashSet(newRemainings);
        cleanRemainings.removeAll(current.getConflicts());
        Plan resultLeft = resolve(selectedLeft, cleanRemainings);

        Plan resultRight = resolve(selected, newRemainings);
        return resultLeft.getGain() > resultRight.getGain() ? resultLeft : resultRight;
      } else {
        List<Rent> newSelected = Lists.newArrayList(selected);
        newSelected.add(current);
        return resolve(newSelected, newRemainings);
      }
    } else {
      return new Plan(selected);
    }
  }

  private boolean conflictsWithAny(LinkedHashSet<Rent> newRemainings, Rent current) {
    return !Sets.intersection(current.getConflicts(), newRemainings).isEmpty();
  }
}
