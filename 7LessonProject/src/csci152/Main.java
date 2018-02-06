package csci152;

import csci152.impl.TestIntQueue;

public class Main {

    public static void main(String[] args) {

        TestIntQueue queue = new TestIntQueue();

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
