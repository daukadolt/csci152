package csci152.adt_tests;

import csci152.impl.LinkedListDeque;
import csci152.adt.Deque;

public class Main {

    public static void main(String[] args) {
        Deque test = new LinkedListDeque<Integer>();

        /* Pop from both the front and the back of the empty deque */

        try {
            test.popFromBack();
        } catch (Exception ex) {
            print(ex.getMessage());
        }

        try {
            test.popFromFront();
        } catch (Exception ex) {
            print(ex.getMessage());
        }


        /* Pushes 5 items to the front of the deque, and print */

        print("\nPushes 5 items to the front\n");

        for(int i = 0; i<5; i++) {
            test.pushToFront(i);
            print(test);
            print("Size: " + test.getSize());
        }

        /* Pops the 5 items from the front of the deque, and print */

        print("\nPops the 5 items from the back\n");

        for(int i = 0; i<5; i++) {
            try {
                test.popFromFront();
                print(test);
                print("Size: " + test.getSize());
            } catch (Exception ex) {
                print(ex.getMessage());
            }
        }

        /* Pushes 6 items to the front of the deque, and print its contents and resulting size after each push. */

        print("\nPushes the 6 items to the front\n");

        for(int i = 0; i<6; i++) {
            test.pushToFront(i);
            print(test);
            print("Size: " + test.getSize());
        }

        /* Pops the 6 items from the back of the deque, and print its contents and resulting size after each pop. */

        print("\nPops the 6 items from the back\n");

        for(int i = 0; i<6; i++) {
            try {
                test.popFromBack();
                print(test);
                print("Size: " + test.getSize());
            } catch (Exception ex) {
                print(ex.getMessage());
            }
        }

        /* Pushes 7 items to the back of the deque, and print its contents and resulting size after each push. */

        print("\nPushes the 7 items to the back\n");

        for(int i = 0; i<7; i++) {
            test.pushToBack(i);
            print(test);
            print("Size: " + test.getSize());
        }

        /* Pops the 7 items from the back of the deque, and print its contents and resulting size after each pop. */

        print("\nPops the 7 items from the back\n");

        for(int i = 0; i<7; i++) {
            try {
                test.popFromBack();
                print(test);
                print("Size: " + test.getSize());
            } catch (Exception ex) {
                print(ex.getMessage());
            }
        }

        /* Pushes 8 items to the back of the deque, and print its contents and resulting size after each push. */

        print("\nPushes the 8 items to the back\n");

        for(int i = 0; i<8; i++) {
            test.pushToBack(i);
            print(test);
            print("Size: " + test.getSize());
        }

        /* Pops the 8 items from the front of the deque, and print its contents and resulting size after each pop. */

        print("\nPops the 8 items from the back\n");

        for(int i = 0; i<8; i++) {
            try {
                test.popFromFront();
                print(test);
                print("Size: " + test.getSize());
            } catch (Exception ex) {
                print(ex.getMessage());
            }
        }

        /* 10 times: Pushes an item to the front, and then to the back, and print the contents and resulting size */

        print("\nPushes the 10 items from the front and the back\n");

        for(int i = 0; i<10; i++) {
            test.pushToFront(i);
            test.pushToBack(i);
            print(test);
            print("Size: " + test.getSize());
        }

        /* 8 times: Pops an item from the front, and then from the back, and print the contents and resulting size */

        print("\nPops the 8 items from the front and the back\n");

        for(int i = 0; i<8; i++) {
            try {
                test.popFromFront();
                test.popFromBack();
                print(test);
                print("Size: " + test.getSize());
            } catch (Exception ex) {
                print(ex.getMessage());
            }
        }

        /* Clear the remaining elements from the deque, and print its contents and resulting size */

        test.clear();

        print(test);

        /* Push some more items to the deque from either end, and print its contents and resulting size */

        print("\nPush some more items to the deque from either end\n");

        for(int i = 16; i<24; i++) {
            test.pushToFront(i);
            test.pushToBack(i);
            print(test);
            print("Size: " + test.getSize());
        }

        /* 2. */

        Deque<Integer> a = new LinkedListDeque<Integer>();
        Deque<Integer> b = new LinkedListDeque<Integer>();

        for(int i = 0; i<4; i++) {
            a.pushToBack(i);
        }

        for(int i = 5; i<10; i++) {
            b.pushToBack(i);
        }

        /*  */


    }

    public static void print(Object o) {
        System.out.println(o);
    }

    public static Deque<Integer> merge(Deque<Integer> d1, Deque<Integer> d2) {
        Deque<Integer> result = new LinkedListDeque<Integer>();
        int val = 0, firstSize = d1.getSize(), secondSize = d2.getSize();
        for(int i = 0; i<firstSize; i++) {
            try {
                val = d1.popFromBack();
                d1.pushToFront(val);
                result.pushToFront(val);
            } catch (Exception ex) {
                print(ex.getMessage());
                break;
            }
        }

        for(int i = 0; i<secondSize; i++) {
            try {
                val = d2.popFromFront();
                d2.pushToBack(val);
                result.pushToBack(val);
            } catch (Exception ex) {
                print(ex.getMessage());
                break;
            }
        }
        return result;
    }


    public static Deque<Integer>[] split(Deque<Integer> deq) {
        int size = deq.getSize(), a_size = size/2, b_size = size - a_size;
        Deque<Integer> a = new LinkedListDeque<Integer>();
        Deque<Integer> b = new LinkedListDeque<Integer>();

        for(int i = 0; i<a_size; i++) {
            try {
                a.pushToBack(deq.popFromFront());
            } catch (Exception ex) {
                print(ex.getMessage());
            }
        }

        for(int i = 0; i<b_size; i++) {
            try {
                b.pushToBack(deq.popFromFront());
            } catch (Exception ex) {
                print(ex.getMessage());
            }
        }

        Deque[] result = new Deque[2];

        result[0] = a;
        result[1] = b;

        return result;

    }


    public static Deque<Integer> mergeSort(Deque<Integer> deq) {
    /* Step 0:  base case???
        Step 1:  split deq into two Deques of relatively equal size
        Step 2:  pass both of these Deques into mergeSort
        Step 3:  pass the resulting Deques into merge, and return the result
     */
    Deque<Integer> result = new LinkedListDeque<Integer>();
    int size = deq.getSize();

    if(size == 1) {
        try {
            result.pushToFront(deq.popFromFront());
        } catch (Exception ex) {
            print(ex.getMessage());
        }
    } else if (size == 2) {
        print(deq);
    }
    else {
        int a_size = size/2, b_size = size - a_size;
        if(a_size > b_size) {
            int temp = a_size;
            a_size = b_size;
            b_size = temp;
        }
        Deque<Integer> a = new LinkedListDeque<Integer>();
        Deque<Integer> b = new LinkedListDeque<Integer>();

        for(int i = 0; i<a_size; i++) {
            try {
                a.pushToBack(deq.popFromFront());
            } catch (Exception ex) {
                print(ex.getMessage());
            }
        }

        for(int i = 0; i<b_size; i++) {
            try {
                b.pushToBack(deq.popFromFront());
            } catch (Exception ex) {
                print(ex.getMessage());
            }
        }

        a = mergeSort(a);
        b = mergeSort(b);

        result = merge(a, b);
    }


    return result;
    }

}
