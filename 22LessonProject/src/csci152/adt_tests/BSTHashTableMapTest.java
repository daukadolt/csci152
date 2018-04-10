package csci152.adt_tests;

import csci152.impl.BSTHashTableMap;

public class BSTHashTableMapTest {

    public static void main(String[] args) {

        BSTHashTableMap<Integer, String> test = new BSTHashTableMap<>(10);

        /* 1 */

        try {
            test.removeAny();
        } catch (Exception ex) {
            print(ex.getMessage());
        }

        /* 2 */

        test.define(21, "Andrey");
        test.define(2, "Alex");
        test.define(3, "John");
        test.define(4, "Donald");
        test.define(5, "Amre");

        print("Size:" + test.getSize());
        print(test);

        /* 3 */


        print("removing 6");
        test.remove(6);

        print("Size:" + test.getSize());
        print(test);

        /* 4 */

        test.define(6, "Kalamkas");
        test.define(6, "Altynai");

        print("Size:" + test.getSize());
        print(test);

        /* 5 */

        print("removing Any");

        try {
            test.removeAny();
            test.removeAny();
//            test.remove(1);
        } catch (Exception ex) {
            print(ex.getMessage());
        }

        print("Size:" + test.getSize());
        print(test);

        /* 6 */

        test.clear();

        print("Size:" + test.getSize());
        print(test);

        /* 7 */

//        test.define(0, "Norm");
//        test.define(1, "Daulet");
//        test.define(2, "Alex");
//        test.define(3, "John");
//        test.define(4, "Donald");
//        test.define(5, "Amre");
        test.define(6, "Winston");
        test.define(7, "Edmond");
//        test.define(8, "Adlet");
//        test.define(9, "Mark");

        print("Size:" + test.getSize());
        print(test);
        print(test.getBucketSizeStandardDev());
        print(test.getLoadFactor());

        /* LLStack implementation */
        /* 9 */

    }

    public static void print(Object o) {
        System.out.println(o);
    }


}
