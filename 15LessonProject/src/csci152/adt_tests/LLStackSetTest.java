package csci152.adt_tests;

import csci152.adt.Set;
import csci152.impl.LLStackSet;

public class LLStackSetTest {

    public static void main(String[] args) {

        Set<String> test1 = new LLStackSet<String>();
        Set<String> test2 = new LLStackSet<String>();

        test1.add("Daulet");
        test2.add("Daulet");
        test2.add("Adlet");

        print(union(test1, test2));

        print(test1);
        print(test2);



        Set<Integer> test_a = new LLStackSet<>();
        Set<Integer> test_b = new LLStackSet<>();

        test_a.add(2);
        test_a.add(4);
        test_a.add(6);

        test_b.add(1);
        test_b.add(2);
        test_b.add(3);
        test_b.add(4);
        test_b.add(5);
        test_b.add(6);

        print(isSubset(test_a, test_b));


        test_a.clear();
        test_b.clear();

        test_a.add(1);
        test_a.add(2);
        test_a.add(3);
        test_a.add(6);

        test_b.add(3);
        test_b.add(4);
        test_b.add(5);
        test_b.add(6);

        //Works for all cases except for the same set vs itself. A problem with referencing.

        print(intersection(test_a, test_b));


        /*  */
        /*  */
        /*  */
        /*  */
        /*  */
        /*  */
        /*  */

    }

    /* Specific methods */


    public static boolean isSubset(Set<Integer> set1, Set<Integer> set2) {
        boolean res = true;
        int size = set1.getSize(), val = 0;
        for(int i = 0; i<size; i++) {
            try {
                val = set1.removeAny();
                if(set2.contains(val)) continue;
                else {
                    res = false;
                    break;
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        return res;
    }

    public static Set<String> union(Set<String> set1, Set<String> set2) {
        Set<String> res = new LLStackSet<String>();
        Set<String> back1 = new LLStackSet<String>();
        Set<String> back2 = new LLStackSet<String>();

        int size = set1.getSize();
        String val;

        for(int i = 0; i<size; i++) {
            try {
                val = set1.removeAny();
                back1.add(val);
                if(set2.contains(val)) {
                    set2.remove(val);
                    back2.add(val);
                }
                res.add(val);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        size = set2.getSize();

        for(int i = 0; i<size; i++) {
            try {
                val = set2.removeAny();
                res.add(val);
                back2.add(val);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        size = back1.getSize();

        for(int i = 0; i<size; i++) {
            try {
                set1.add(back1.removeAny());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        size = back2.getSize();

        for(int i = 0; i<size; i++) {
            try {
                set2.add(back2.removeAny());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        return res;
    }

    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {

        Set<Integer> res = new LLStackSet<Integer>();
        Set<Integer> back = new LLStackSet<Integer>();
        int size = set1.getSize(), val = 0;

        for(int i = 0; i<size; i++) {
            try {
                val = set1.removeAny();
                if(set2.contains(val)) res.add(val);
                back.add(val);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        for(int i = 0; i<size; i++) {
            try {
               set1.add(back.removeAny());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }


        return res;

    }


    /* Specific methods end here */

    public static void print(Object o) {
        System.out.println(o);
    }

    public static void printContents(Set o) {
        print("Size: " + o.getSize());
        print(o);
    }

}
