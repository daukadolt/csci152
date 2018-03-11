package csci152.adt_tests;


import csci152.adt.Set;
import csci152.impl.BSTSet;


public class BSTSetTest {

    public static void main(String[] args) {

        /* Adding  5, 12, 3, 6, 14, 2, -6, 8, and 0 */

        Set<Integer> test = new BSTSet<>();
        int[] vals = {5, 12, 3, 6, 14, 2, -6, 8, 0};
        int size = vals.length;
        for(int i = 0; i < size; i++) {
            test.add(vals[i]);
        }

        print("Size: " + test.getSize());
        print(test);

        /* Re-adding 14, -6 and 5 */

        test.add(14);
        test.add(-6);
        test.add(5);

        print("Size: " + test.getSize());
        print(test);

        /* Testing contains on 12, 7, 2, -8, and 5 */

        int[] a_vals = {12, 7, 2, -8, 5};
        size = a_vals.length;
        for(int i = 0; i < size; i++) {
            print("Val: "+ a_vals[i] +" Contains: " + test.contains(a_vals[i]));
        }

        /* <--------------------------------------- LESSON 17 ---------------------------------------> */

        print("<--------------------------------------- LESSON 17 --------------------------------------->");

        /* Removing 0, 6, and 3 */

        print("/* Removing 0, 6, and 3 */");

        print("Size: " + test.getSize());
        print(test);

        test.remove(0);
        test.remove(6);
        test.remove(3);

        print("Size: " + test.getSize());
        print(test);

        /* Adding 6, 13, 99 and 11 */

        print("/* Adding 6, 13, 99 and 11 */");

        test.add(6);
        test.add(13);
        test.add(99);
        test.add(11);

        print("Size: " + test.getSize());
        print(test);

        /* Removing 12 from the set */

        print("/* Removing 12 from the set */");

        test.remove(12);

        print("Size: " + test.getSize());
        print(test);

        /* Removing 5 (the root) from the set */

        print("/* Removing 5 (the root) from the set */");

        test.remove(5);

        print("Size: " + test.getSize());
        print(test);

        /* Calling removeAny() 3 times */

        print("/* Calling removeAny() 3 times */");

        try {

            test.removeAny();
            test.removeAny();
            test.removeAny();

        } catch (Exception ex) {
            print(ex.getMessage());
        }

        print("Size: " + test.getSize());
        print(test);

        print("<--------------------------------------- LESSON 17 --------------------------------------->");

        /* <--------------------------------------- LESSON 17 ---------------------------------------> */


        /* Clearing the set and printing size, contents */

        test.clear();
        print("<--------Set cleared-------->");
        print("Size: " + test.getSize());
        print(test);

        /* Adding 55, 24, 78, and 51 */

        int[] b_vals = {55, 24, 78, 51};
        size = b_vals.length;

        for(int i = 0; i<size; i++) {
            test.add(b_vals[i]);
        }
        print("Size: " + test.getSize());
        print(test);

        /* 2. Students class tests */

        Set<Student> st_test = new BSTSet<>();
        st_test.add(new Student("Daulet", 201585214));
        st_test.add(new Student("Adlet", 201585315));
        st_test.add(new Student("Germann", 201685311));
        st_test.add(new Student("Gref", 201435311));
        st_test.add(new Student("Ernst", 201364312));

        print("Size: " + st_test.getSize());
        print(st_test);

        /* Attempt to add 2 new Student objects that have the same values as those already in the set, and print the set’s contents and size afterwards */

        st_test.add(new Student("Adlet", 201585315));
        st_test.add(new Student("Germann", 201685311));

        print("Size: " + st_test.getSize());
        print(st_test);

        /* Add 3 new Students to the set whose values are not already present, and print the set’s contents and size */

        st_test.add(new Student("Thor Odinson", 1));
        st_test.add(new Student("Loki Odinson", 0));
        st_test.add(new Student("Starlord Planetson", 3));

        print("Size: " + st_test.getSize());
        print(st_test);

        /* Clear the set, and print its contents and resulting size */

        st_test.clear();

        print("Size: " + st_test.getSize());
        print(st_test);

        /* Finally, add 2 new Students to the set, and print the set’s contents and size */

        st_test.add(new Student("Thor Odinson", 1));
        st_test.add(new Student("Loki Odinson", 0));

        print("Size: " + st_test.getSize());
        print(st_test);


    }

    public static void print(Object o) {
        System.out.println(o);
    }

}
