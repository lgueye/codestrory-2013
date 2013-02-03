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
            for (Rent rent : rents) {
                // Only interested in rents who start at hour
                if (rent.startsAt(hour)) {
                    // Find plans whose end is less or equal than current rent's start date
                    List<Plan> candidatePlans = findAppendablePlans(hour, bestPlanByHour);
                    if (candidatePlans.isEmpty()) {
                        Plan plan = new Plan(Lists.<Rent>newLinkedList());
                        candidatePlans.add(plan);
                    }
                    for (Plan candidatePlan : candidatePlans) {
                        Plan tmp = Plan.fromPlan(candidatePlan);
                        tmp.addRent(rent);
                        int end = tmp.getEnd();
                        Plan existingPlan = bestPlanByHour.get(end);
                        if (existingPlan == null) bestPlanByHour.put(end, tmp);
                        else {
                            if (tmp.compareTo(existingPlan) > 0) bestPlanByHour.put(end, tmp);
                        }
                    }
                }
            }
        }
        Plan best = getBest(bestPlanByHour);
        System.out.println("resolve took = " + (System.currentTimeMillis() - start) + " ms");
        return best;

    }

    private List<Plan> findAppendablePlans(int hour, Map<Integer, Plan> bestPlanByHour) {
        List<Plan> list = Lists.newLinkedList();
        for (Integer end : bestPlanByHour.keySet()) {
            if (end <= hour) list.add(bestPlanByHour.get(end));
        }
        return list;
    }

    private Plan getBest(Map<Integer, Plan> bestPlanByHour) {
        final List<Plan> plans = Lists.newArrayList(bestPlanByHour.values());
        Collections.sort(plans);
        return plans.get(bestPlanByHour.size() - 1);
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
