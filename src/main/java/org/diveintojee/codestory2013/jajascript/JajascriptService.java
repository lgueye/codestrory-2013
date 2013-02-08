package org.diveintojee.codestory2013.jajascript;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author louis.gueye@gmail.com
 */
@Component
public class JajascriptService {

//  public Plan optimize(List<Rent> rents) {
//    long start = System.currentTimeMillis();
//    int maxHour = resolvMaxHour(rents);
//    Collections.sort(rents);
//    Map<Integer, List<Rent>> rentsByHour = groupRentsByStartHour(rents);
//    Map<Integer, Plan> bestPlanByHour = new HashMap<Integer, Plan>();
//    // scan each hour for departures, starting from the first hour
//    for (int hour = 0; hour <= maxHour; hour++) {
//      List<Rent> rentsForHour = rentsByHour.get(hour);
//      // No rent at given hour, continue
//      if (rentsForHour == null) {
//        continue;
//      }
//      Plan mostProfitablePlanAtHour = findMostProfitablePlanAtHour(hour, bestPlanByHour);
//      for (Rent rent : rentsForHour) {
//        Plan candidate;
//        if (mostProfitablePlanAtHour == null) {
//          candidate = new Plan(Lists.<Rent>newArrayList());
//        } else {
//          candidate = Plan.fromPlan(mostProfitablePlanAtHour);
//        }
//        candidate.addRent(rent);
//        int end = candidate.getEnd();
//        Plan existingPlanAtHour = bestPlanByHour.get(end);
//        if (existingPlanAtHour == null || candidate.compareTo(existingPlanAtHour) > 0) {
//          bestPlanByHour.put(end, candidate);
//        }
//      }
//    }
//    Plan best = getBest(bestPlanByHour);
//    System.out.println("resolve took = " + (System.currentTimeMillis() - start) + " ms");
//    return best;
//  }


  /**
   * Weighted interval scheduling problem
   * plan(i) = max{w[i] + value(j), value(i+1)}
   *
   *
   * @param rents
   * @return
   */
  public Plan optimize(List<Rent> rents) {
    rents = Lists.newLinkedList(rents);

    Collections.sort(rents);
    TreeMap<Integer, Rent> endDateRents = new TreeMap<Integer, Rent>();
    Map<Rent, Plan> solutions = new HashMap<Rent, Plan>();

    Rent previousRent = null;
    for (Rent rent : rents) {
      Plan previousRentSolution = previousRent != null ? solutions.get(previousRent) : null;

      Map.Entry<Integer, Rent> entry = endDateRents.floorEntry(rent.getStart());
      Rent lastNonConflictingRent = entry != null ? entry.getValue() : null;
      Plan solutionWithCurrentRent = lastNonConflictingRent != null ? solutions.get(lastNonConflictingRent).addRent(rent) : new Plan(rent);

      Plan bestPlan;
      if (previousRentSolution != null) {
        bestPlan = previousRentSolution.compareTo(solutionWithCurrentRent) > 0 ? previousRentSolution : solutionWithCurrentRent;
      } else {
        bestPlan = solutionWithCurrentRent;
      }
      solutions.put(rent, bestPlan);

      endDateRents.put(rent.getEnd(), rent);
      previousRent = rent;
    }

    return solutions.get(previousRent);
  }

//  int resolvMaxHour(List<Rent> rents) {
//    Collections.sort(rents, new Comparator<Rent>() {
//      @Override
//      public int compare(Rent o1, Rent o2) {
//        return o2.getEnd() - o1.getEnd();
//      }
//    });
//    return rents.get(0).getEnd();
//  }
//
//  Rent findMostProfitableRentAtHour(List<Rent> rentsForHour) {
//    Collections.sort(rentsForHour, new Comparator<Rent>() {
//      @Override
//      public int compare(Rent o1, Rent o2) {
//        return o2.getAmount() - o1.getAmount();
//      }
//    });
//    Rent rent = rentsForHour.get(0);
//    return rent;
//  }
//
//  Map<Integer, List<Rent>> groupRentsByStartHour(List<Rent> rents) {
//    Map<Integer, List<Rent>> rentsByHour = Maps.newHashMap();
//    for (Rent rent : rents) {
//      int start = rent.getStart();
//      if (rentsByHour.get(start) == null) {
//        rentsByHour.put(start, Lists.<Rent>newArrayList());
//      }
//      rentsByHour.get(start).add(rent);
//    }
//    return rentsByHour;
//  }
//
//  Plan findMostProfitablePlanAtHour(int hour, Map<Integer, Plan> bestPlanByHour) {
//    Plan best = null;
//    for (Map.Entry<Integer, Plan> entry : bestPlanByHour.entrySet()) {
//      Plan value = entry.getValue();
//      if (value.getEnd() <= hour && (best == null || value.compareTo(best) > 0)) {
//        best = Plan.fromPlan(value);
//      }
//    }
//    return best;
//  }
//
//  Plan getBest(Map<Integer, Plan> bestPlanByHour) {
//    final List<Plan> plans = Lists.newArrayList(bestPlanByHour.values());
//    Collections.sort(plans);
//    return plans.get(plans.size() - 1);
//  }

}
