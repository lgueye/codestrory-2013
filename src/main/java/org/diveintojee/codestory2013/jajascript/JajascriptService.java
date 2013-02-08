package org.diveintojee.codestory2013.jajascript;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author louis.gueye@gmail.com
 */
@Component
public class JajascriptService {

  /**
   * Weighted interval scheduling problem <br/>
   * value(i) = max{w[i] + value(j), value(i+1)}<br/>
   *
   * Solution = value(n)
   */
  public Plan optimize(List<Rent> rents) {
    long start = System.currentTimeMillis();
    Collections.sort(rents);
    TreeMap<Integer, Rent> rentsByEndDate = new TreeMap<Integer, Rent>();
    Map<Rent, Plan> solutions = new HashMap<Rent, Plan>();

    Plan previousRentSolution = null;
    for (Rent rent : rents) {
      Map.Entry<Integer, Rent> entry = rentsByEndDate.floorEntry(rent.getStart());
      Rent firstNonConflictingRentBeforeStartDate = entry != null ? entry.getValue() : null;
      Plan currentRentSolution = firstNonConflictingRentBeforeStartDate != null ?
                                 solutions.get(firstNonConflictingRentBeforeStartDate).addRent(rent)
                                                                                : new Plan(rent);

      Plan bestPlan = (previousRentSolution == null
                       || previousRentSolution.compareTo(currentRentSolution) < 0) ?
                      currentRentSolution : previousRentSolution;

      solutions.put(rent, bestPlan);
      rentsByEndDate.put(rent.getEnd(), rent);
      previousRentSolution = bestPlan;
    }

    System.out.println("optimize took = " + (System.currentTimeMillis() - start));
    return previousRentSolution;
  }

}
