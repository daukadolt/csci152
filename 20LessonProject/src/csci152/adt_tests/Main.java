package csci152.adt_tests;

import csci152.adt.Set;
import csci152.impl.BSTHashTableSet;
import csci152.impl.LLQHashTableSet;
import java.lang.Math.*;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        /* <----- 10 Buckets, 50k elements test -----> */

        Random rand = new Random();

        Set<Integer> set = new LLQHashTableSet<>(10);

        System.out.println("Starting timing tests...");
        long time1, time2, duration;
        time1 = System.currentTimeMillis();

        for (int i = 0; i < 100; i = i + 2) {
//            set.add(Math.abs(rand.nextInt()));
            set.add(i);
        }

        time2 = System.currentTimeMillis();
        duration = time2 - time1;

        System.out.println("Time taken in ms: " + duration);
        print("Stdev: " + ((LLQHashTableSet<Integer>) set).getBucketSizeStandardDev());
        print("Load factor "+((LLQHashTableSet<Integer>) set).getLoadFactor());
        print(set);

        /* <----- ~ -----> */


        /* <----- ~ -----> */
        /* <----- ~ -----> */
        /* <----- ~ -----> */
        /* <----- ~ -----> */
        /* <----- ~ -----> */

    }

    public static void print(Object o) {
        System.out.println(o);
    }

}
