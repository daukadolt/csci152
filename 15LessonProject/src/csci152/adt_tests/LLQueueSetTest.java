package csci152.adt_tests;

import csci152.adt.Set;
import csci152.impl.LLQueueSet;

public class LLQueueSetTest {

    public static void main(String[] args) {

        /* First tries to removeAny from the empty set — catch the exception, and print the set’s contents and size afterwards to make sure you didn’t break it. 🙂 */

        Set<Student> test = new LLQueueSet<Student>();

        try {
            test.removeAny();
        } catch (Exception ex) {
            print(ex.getMessage());
        }

        printContents(test);

        /* Add 5 unique Students to the set, and print its contents and size */

        test.add(new Student("Daulet", 201585214));
        test.add(new Student("Adlet", 201585315));
        test.add(new Student("Germann", 201685311));
        test.add(new Student("Gref", 201435311));
        test.add(new Student("Ernst", 201364312));

        printContents(test);

        /* Remove a specific Student from the set using a different object with the same values as the Student to be removed, and print the set’s contents and size */

        test.remove(new Student("Daulet", 201585214));

        printContents(test);

        /* Try to remove a Student from the set whose value is not there, and print the set’s contents and size */

        test.remove(new Student("Barack", 123432123));

        printContents(test);

        /* Attempt to add 2 new Student objects that have the same values as those already in the set, and print the set’s contents and size afterwards */

        test.add(new Student("Adlet", 201585315));
        test.add(new Student("Germann", 201685311));

        printContents(test);

        /* Add 3 new Students to the set whose values are not already present, and print the set’s contents and size */

        test.add(new Student("Thor Odinson", 1));
        test.add(new Student("Loki Odinson", 0));
        test.add(new Student("Starlord Planetson", 3));

        printContents(test);

        /* Call removeAny twice on the set, and output the values of those Students who were removed, as well as the resulting contents and size of the set */

        try {
            print(test.removeAny());
            print(test.removeAny());
        } catch (Exception ex) {
            print(ex.getMessage());
        }

        printContents(test);

        /* Clear the set, and print its contents and resulting size */

        test.clear();
        printContents(test);

        /* Finally, add 2 new Students to the set, and print the set’s contents and size */

        test.add(new Student("Thor Odinson", 1));
        test.add(new Student("Loki Odinson", 0));

        printContents(test);

        /*  */
        /*  */
        /*  */
        /*  */

    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void printContents(Set o) {
        print("Size: " + o.getSize());
        print(o);
    }


}
