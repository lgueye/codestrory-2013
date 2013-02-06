package org.diveintojee.codestory2013.jajascript;

import com.google.common.collect.Lists;
import com.google.common.primitives.Longs;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author louis.gueye@gmail.com
 */
public class PayloadGenerator {
    private Random rand = new Random();

    private Rent[] randFilghts(int nbFlights) {
        List<Rent> flights = new ArrayList<Rent>();

        for (int i=0; i<nbFlights; i++) {
            Rent rent = new Rent();
            rent.setName(UUID.randomUUID().toString());
            rent.setStart(rand.nextInt(nbFlights / 2));
            rent.setDuration(rand.nextInt(10) + 1);
            rent.setAmount(rand.nextInt(100) + 1);
            flights.add(rent);
        }
        return flights.toArray(new Rent[nbFlights]);
    }

    private void testALevel(int nbFlights) {
        int nbOccurToTest = 5;

        long totalElapsedTime = 0;
        long minElapsedTime = Long.MAX_VALUE;
        long maxElapsedTime = 0;

        for (int i = 0; i <= nbOccurToTest; i++) {

            JajascriptService service;
            long startTime;
                Rent[] flights = randFilghts(nbFlights);
                startTime = System.nanoTime();
                service = new JajascriptService();

            service.optimize(Lists.newArrayList(flights));

            long elapsedTime = System.nanoTime() - startTime;

            if (i != 0) {
                totalElapsedTime += elapsedTime;
                minElapsedTime = Longs.min(minElapsedTime, elapsedTime);
                maxElapsedTime = Longs.max(maxElapsedTime, elapsedTime);
            }

            System.out.println("Test " + i + " : " + TimeUnit.NANOSECONDS.toMillis(elapsedTime));
        }
        System.out.println("NbFlights " + nbFlights + " :");
        System.out.println("\tMin : " + TimeUnit.NANOSECONDS.toMillis(minElapsedTime));
        System.out.println("\tMax : " + TimeUnit.NANOSECONDS.toMillis(maxElapsedTime));
        System.out.println("\tMoy : " + TimeUnit.NANOSECONDS.toMillis(totalElapsedTime / nbOccurToTest));
    }

    @Test
    public void testManyLevels() {
        testALevel(5000);
//        testALevel(10000);
//        testALevel(50000);
//        testALevel(100000);
//        testALevel(200000);
//        testALevel(500000);
//        testALevel(1000000);

    }
}
