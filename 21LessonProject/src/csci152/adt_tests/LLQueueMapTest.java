package csci152.adt_tests;

import csci152.adt.Set;
import csci152.impl.LLQHashTableSet;
import csci152.impl.LLQueueMap;

import java.util.Random;

public class LLQueueMapTest {

    public static void main(String[] args) {

        LLQueueMap test = new LLQueueMap();

        /* 1 */

        try {
            test.removeAny();
        } catch (Exception ex) {
            print(ex.getMessage());
        }

        /* 2 */

        test.define(1, 1);
        test.define(2, 4);
        test.define(3, 9);
        test.define(4, 16);
        test.define(5, 25);

        print("Size:" + test.getSize());
        print(test);

        /* 3 */

        print("removing 5");
        test.remove(5);

        print("Size:" + test.getSize());
        print(test);

        /* 4 */

        test.remove(6);

        print("Size:" + test.getSize());
        print(test);

        /* 5 */

        test.define(6, 36);


        print("Size:" + test.getSize());
        print(test);

        test.define(6, 24);

        print("Size:" + test.getSize());
        print(test);

        /* 6 */

        test.define(7,49);
        test.define(8,64);
        test.define(9,81);

        print("Size:" + test.getSize());
        print(test);

        /* 7 */

        try {
            test.removeAny();
            test.removeAny();
        } catch (Exception ex) {
            print(ex.getMessage());
        }

        print("Size:" + test.getSize());
        print(test);

        /* 8 */

        test.clear();

        print("Size:" + test.getSize());
        print(test);

        /* 9 */

        test.define(6, 720);
        test.define(7, 5040);

        print("Size:" + test.getSize());
        print(test);

        /* LLStack implementation */
        /* 9 */

    }

    public static void print(Object o) {
        System.out.println(o);
    }

}
