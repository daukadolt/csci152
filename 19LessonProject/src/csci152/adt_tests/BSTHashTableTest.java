package csci152.adt_tests;

import csci152.adt.Set;
import csci152.impl.BSTHashTableSet;
import csci152.impl.LLQHashTableSet;

public class BSTHashTableTest {
    public static void main(String[] args) {

        Set<Student> test = new BSTHashTableSet<>(100);
        for(int i = 100; i<300; i++) {
            test.add(new Student("Bob", i));
        }

        print(((BSTHashTableSet<Student>) test).getLoadFactor());
        print(((BSTHashTableSet<Student>) test).getBucketSizeStandardDev());

        /* <----- ~ -----> */

        Set<Student> test2 = new BSTHashTableSet<>(10);

        for(int i = 100; i<300; i++) {
            test2.add(new Student("Bob", i));
        }

        print(((BSTHashTableSet<Student>) test2).getLoadFactor());
        print(((BSTHashTableSet<Student>) test).getBucketSizeStandardDev());

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
