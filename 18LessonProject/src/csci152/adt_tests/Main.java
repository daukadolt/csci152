package csci152.adt_tests;

import csci152.adt.Set;
import csci152.impl.BSTSet;
import csci152.impl.LLQHashTableSet;
import csci152.impl.LinkedListQueue;

public class Main {

    public static void main(String[] args) {

        Set<Integer> test = new LLQHashTableSet<>(10);

        try {
            test.removeAny();
        } catch (Exception ex) {
            print(ex.getMessage());
        }

        print(test);
        print(test.getSize());

        /* <---- ~ ---->  */

        for(int i = 1; i<=20; i++) {
            test.add(i);
        }

        print(test);
        print(test.getSize());

        /* <---- ~ ---->  */

        for(int i = 20; i>=0; i-=2) {
            test.remove(i);
        }

        print(test);
        print(test.getSize());

        /* <---- ~ ---->  */

        print(test.remove(10));
        print(test.remove(100));

        print(test);
        print(test.getSize());

        /* <---- ~ ---->  */

        for(int i = 1; i<=30; i++) {
            test.add(i);
        }

        print(test);
        print(test.getSize());

        /* <---- ~ ---->  */

        for(int i = 0; i<10; i++) {
            try {
                print("RemovedAny: " + test.removeAny());
            } catch (Exception ex) {
                print(ex.getMessage());
            }
        }

        print(test);
        print(test.getSize());

        /* <---- ~ ---->  */

        test.clear();

        print(test);
        print(test.getSize());

        /* <---- ~ ---->  */

        for(int i = 51; i<=79; i+=2) {
            test.add(i);
        }

        print(test);
        print(test.getSize());

        /* <---- ~ ---->  */

    }

    public static void print(Object o) {
        System.out.println(o);
    }

}
