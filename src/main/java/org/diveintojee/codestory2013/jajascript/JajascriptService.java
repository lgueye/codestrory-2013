package org.diveintojee.codestory2013.jajascript;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author louis.gueye@gmail.com
 */
@Component
public class JajascriptService {

    public Plan optimize(List<Rent> rents) {
        long start = System.currentTimeMillis();
        Collections.sort(rents);
        Map<Integer, List<Rent>> rentsByHour = groupRentsByStartHour(rents);
        final List<Integer> effectiveHours = Lists.newArrayList(rentsByHour.keySet());
        Collections.sort(effectiveHours);
        Map<Integer, Plan> bestPlanByHour = new HashMap<Integer, Plan>();
        // scan each hour for departures, starting from the first hour
        for (Integer hour : effectiveHours) {
            List<Rent> rentsForHour = rentsByHour.get(hour);
            if (rentsForHour == null) continue;
            for (Rent rent : rentsForHour) {
                // Find the most profitable plan whose end is less or equal than current rent's start date
                Plan candidatePlan = findMostProfitableAppendablePlan(hour, bestPlanByHour);
                Plan tmp = Plan.fromPlan(candidatePlan);
                tmp.addRent(rent);
                int end = tmp.getEnd();
                Plan existingPlan = bestPlanByHour.get(end);
                if (existingPlan == null) {
                    removePlansBefore(hour, bestPlanByHour);
                    bestPlanByHour.put(end, tmp);
                } else {
                    if (tmp.compareTo(existingPlan) < 0) {
                        removePlansBefore(hour, bestPlanByHour);
                        bestPlanByHour.put(end, tmp);
                    }
                }
            }
        }

        Plan best = getBest(bestPlanByHour);
        System.out.println("resolve took = " + (System.currentTimeMillis() - start) + " ms");
        return best;

    }

  private void removePlansBefore(Integer hour, Map<Integer, Plan> bestPlanByHour) {
      for(Iterator<Map.Entry<Integer,Plan>> it = bestPlanByHour.entrySet().iterator();it.hasNext();){
          Map.Entry<Integer, Plan> entry = it.next();
          if (entry.getKey() <= hour) {
              it.remove();
          }
      }
  }

  private Map<Integer, List<Rent>> groupRentsByStartHour(List<Rent> rents) {
        Map<Integer, List<Rent>> rentsByHour = Maps.newHashMap();
        for (Rent rent : rents) {
            int start = rent.getStart();
            if (rentsByHour.get(start) == null) {
                rentsByHour.put(start, Lists.<Rent>newArrayList());
            }
            rentsByHour.get(start).add(rent);
        }
        return rentsByHour;
    }

    private List<Plan> findAppendablePlans(int hour, Map<Integer, Plan> bestPlanByHour) {
        List<Plan> list = Lists.newArrayList();
        for (Integer end : bestPlanByHour.keySet()) {
            if (end <= hour) {
              final Plan plan = bestPlanByHour.get(end);
              list.add(plan);
            }
        }
        return list;
    }

    private Plan findMostProfitableAppendablePlan(int hour, Map<Integer, Plan> bestPlanByHour) {
        Plan best = new Plan(Lists.<Rent>newArrayList());
        for (Integer end : bestPlanByHour.keySet()) {
            if (end <= hour) {
              final Plan plan = bestPlanByHour.get(end);
              if (best == null || plan.compareTo(best) < 0) best = plan;
            }
        }
        return best;
    }

    private Plan getBest(Map<Integer, Plan> bestPlanByHour) {
        final List<Plan> plans = Lists.newArrayList(bestPlanByHour.values());
        Collections.sort(plans);
        return plans.get(0);
    }
}
