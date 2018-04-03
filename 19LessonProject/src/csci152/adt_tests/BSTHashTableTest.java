package csci152.adt_tests;

import csci152.adt.Set;
import csci152.impl.BSTHashTableSet;
import csci152.impl.LLQHashTableSet;

public class BSTHashTableTest {
    public static void main(String[] args) {

        Student asd;
        Set<Student> test = new BSTHashTableSet<>(10);
        for(int i = 100; i<300; i++) {
            asd = new Student("Bob", i);
            test.add(asd);
        }

            print(test);

        print(((BSTHashTableSet<Student>) test).getBucketSizeStandardDev());
        print(((BSTHashTableSet<Student>) test).getLoadFactor());


        /* <----- ~ -----> */

        Set<Student> test2 = new BSTHashTableSet<>(100);

        for(int i = 100; i<300; i++) {
            test2.add(new Student("Bob", i));
        }

        print(((BSTHashTableSet<Student>) test2).getBucketSizeStandardDev());
        print(((BSTHashTableSet<Student>) test2).getLoadFactor());
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
