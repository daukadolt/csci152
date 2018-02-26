package csci152.adt_tests;

import csci152.adt.SortedQueue;
import csci152.impl.LinkedListSortedQueue;

public class Main {

    public static void main(String[] args) {

        SortedQueue test = new LinkedListSortedQueue();

        for(int i = 90; i>=10; i-=10) {
            test.insert(i);
        }

        print(test);
        print("Size: " + test.getSize());

        try {
            test.dequeue();
            test.dequeue();
            test.dequeue();
        } catch (Exception ex) {
            print(ex.getMessage());
        }

        for(int i = 100; i<=900; i+=100) {
            test.insert(i);
        }

        print(test);
        print("Size: " + test.getSize());

        try {
            test.dequeue();
            test.dequeue();
            test.dequeue();
            test.dequeue();
        } catch (Exception ex) {
            print(ex.getMessage());
        }

        print(test);
        print("Size: " + test.getSize());

        for(int i = 5; i<=915; i+=5) {
            test.insert(i);
        }

        print(test);
        print("Size: " + test.getSize());

        /* A for loop to dequeue all items */

        int size = test.getSize();

        for(int i = 0; i<size; i++) {
            try {
                test.dequeue();
            } catch (Exception ex) {
                print(ex.getMessage());
                break;
            }
        }

        print(test);
        print("Size: " + test.getSize());

        /* 3 integers of my choice inserted */

        test.insert(123);
        test.insert(678);
        test.insert(456);

        print(test);
        print("Size: " + test.getSize());

        /* Clear the queue and print */

        test.clear();

        print(test);
        print("Size: " + test.getSize());

        /* Insert 4 more integers */

        test.insert(123124);
        test.insert(123121);
        test.insert(123126);
        test.insert(124126);

        print(test);
        print("Size: " + test.getSize());



    }

    public static void print(Object msg) {
        System.out.println(msg);
    }

}
