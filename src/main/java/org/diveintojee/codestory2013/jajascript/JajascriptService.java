package org.diveintojee.codestory2013.jajascript;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
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
        int maxHour = resolveMaxHour(rents);
        // scan each hour for departures, starting from the first hour
        Map<Integer, Plan> bestPlanByHour = new HashMap<Integer, Plan>();
        for (int hour = 0; hour <= maxHour; hour++) {
            System.out.println("hour = " + hour);
            Rent bestForhour = null;
            for (Rent rent : rents) {
                // Only interested in rents who start at hour
                if (rent.startsAt(hour)) {
                    if (rent.hasHigherAmount(bestForhour)) {
                        bestForhour = rent;
                    }
                }
            }

            if (bestForhour == null) {
                final Plan best = getBest(bestPlanByHour);
                bestPlanByHour.put(best.getEnd(), best);
                continue;
            }

            Plan appendablePlan = bestPlanByHour.get(hour);
            // Tail
            if (appendablePlan == null) {
                appendablePlan = new Plan(Lists.<Rent>newLinkedList());
            }
            appendablePlan.addRent(bestForhour);
            final int conflictingHour = appendablePlan.getEnd();
            System.out.println("conflictingHour = " + conflictingHour);
            Plan conflict = bestPlanByHour.get(conflictingHour);
            if (hour==5){
              System.out.println("conflict = " + conflict);
              System.out.println("appendablePlan = " + appendablePlan);
            }
            if (conflict == null || appendablePlan.compareTo(conflict) > 0) bestPlanByHour.put(conflictingHour, appendablePlan);

            System.out.println("bestPlanByHour = " + bestPlanByHour);

        }
        final Plan best = getBest(bestPlanByHour);
        System.out.println(bestPlanByHour);
        System.out.println("optimize took = " + (System.currentTimeMillis() - start) + " ms");
        return best;

    }

    private Plan getBest(Map<Integer, Plan> bestPlanByHour) {
        final List<Plan> plans = Lists.newArrayList(bestPlanByHour.values());
        Collections.sort(plans);
        return plans.get(0);
    }

    int resolveMaxHour(List<Rent> rents) {
        int maxHour = 0;
        for (Rent rent : rents) {
            Integer rentEnd = rent.getEnd();
            if (rentEnd > maxHour) maxHour = rentEnd;
        }
        return maxHour;
    }
}
