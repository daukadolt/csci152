package csci152.adt_tests;

import csci152.adt.Queue;
import csci152.impl.ArrayQueue;

public class ArrayQueueTest {
    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayQueue();

        for(int i =0; i<10; i++) {
            queue.enqueue(i);
            print(queue.toString());
        }

        try {
            queue.dequeue();
            queue.dequeue();
        } catch (Exception ex) {
            print(ex+"");
        }

        print(queue.toString());

        for(int i =3 ; i<8; i++) {
            queue.enqueue(i);
        }
        print(queue.toString());

        queue.clear();

        print(queue.toString());

    }

    public static void print(String args) {
        System.out.println(args);
    }
}
