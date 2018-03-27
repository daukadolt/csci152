package csci152.adt_tests;

import csci152.adt.Set;
import csci152.impl.LLQHashTableSet;

public class Main {

    public static void main(String[] args) {

        Set<Student> test = new LLQHashTableSet<>(10);
        for(int i = 100; i<300; i++) {
            test.add(new Student("Bob", i));
        }

        print(((LLQHashTableSet<Student>) test).getLoadFactor());
        print(((LLQHashTableSet<Student>) test).getBucketSizeStandardDev());

        /* <----- ~ -----> */

        Set<Student> test2 = new LLQHashTableSet<>(100);
        for(int i = 100; i<300; i++) {
            test2.add(new Student("Bob", i));
        }

        print(((LLQHashTableSet<Student>) test2).getLoadFactor());
        print(((LLQHashTableSet<Student>) test2).getBucketSizeStandardDev());

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
