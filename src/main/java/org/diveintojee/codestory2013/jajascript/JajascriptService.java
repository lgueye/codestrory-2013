package org.diveintojee.codestory2013.jajascript;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

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
        Plan best = new Plan(Lists.<Rent>newArrayList());
        for (int hour = 0; hour < maxHour; hour++) {
            System.out.println("hour = " + hour);
            Rent bestForhour = null;
            boolean conflict = false;
            for (Rent rent : rents) {
                // Only interested in rents who start at hour
                if (rent.startsAt(hour)) {
                    if (rent.hasHigherAmount(bestForhour)) {
                        System.out.println("setting bestForHour to = " + rent);
                        bestForhour = rent;
                    }
                    if (!conflict && rent.conflictsWith(best)) {
                        conflict = true;
                    }
                }

            }

            if (bestForhour == null) continue;

            if (!conflict) {
                System.out.println("No conflict, adding best rent " + bestForhour + " for hour " + hour);
                best.addRent(bestForhour);
            } else {
                Plan candidate = new Plan(Lists.<Rent>newArrayList());
                candidate.addRent(bestForhour);
                boolean freshPlanBeatsOldOne = candidate.compareTo(best) > 0;
                if (freshPlanBeatsOldOne) {
                    System.out.println("Conflict, fresh plan beats old one, setting best to new plan " + candidate);
                    best = candidate;
                }
            }
        }
        System.out.println("optimize took = " + (System.currentTimeMillis() - start) + " ms");
        return best;
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
