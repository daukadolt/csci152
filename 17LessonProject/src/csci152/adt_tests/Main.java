package csci152.adt_tests;

import csci152.adt.Set;
import csci152.impl.BSTSet;

public class Main {

    public static void main(String[] args) {

        Set<Integer> test = new BSTSet<>();
        test.add(2);
        test.add(4);
        test.add(3);
        test.add(5);
        test.add(0);
        test.add(1);
        test.add(-1);

        print("Size: " + test.getSize());
        print(test);

        try {
            test.removeAny();
        } catch (Exception ex) {
            print(ex.getMessage());
        }

        print("Size: " + test.getSize());
        print(test);
    }

    public static void print(Object o) {
        System.out.println(o);
    }

}
