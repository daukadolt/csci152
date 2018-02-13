package csci152.adt_tests;

import csci152.adt.Stack;
import csci152.impl.LinkedList;

public class LinkedListTest {

    public static void main(String[] args) {

        LinkedList stack = new LinkedList<Integer>();

        /* Creates a new stack and tries to pop from the empty stack */

        try {
            stack.pop();
        } catch (Exception ex) {
            print(ex);
        }

        /* Pushes 12 items on the stack using a loop, and then prints the stack contents and its size afterwards */

        for(int i = 0; i<13; i++) {
            stack.push(i);
        }

        print(stack);

        /* Pop several items from the stack, and print its contents and resulting size */

        try {
            stack.pop();
            stack.pop();
            stack.pop();
        } catch (Exception ex) {
            print(ex);
        }

        print(stack);
        print(stack.getSize());

        /* Clear the stack, and print its contents and resulting size */

        stack.clear();
        print(stack);

        /* Push 22 more items to the stack using a loop, and again print its contents and resulting size */

        for(int i = 20; i<43; i++) {
            stack.push(i);
        }

        print(stack);
        print(stack.getSize());

        try {
            stack.pop();
        } catch (Exception ex) {
            print(ex);
        }

        /* Testing task #2 */

        Stack test = new LinkedList<Double>();

        for(double i = 2; i<50; i*=2) {
            test.push(i);
        }
        print(isIncreasing(test));

    }

    public static void print(Object obj) {
        System.out.println(obj);
    }

    public static boolean isIncreasing(Stack<Double> st) {
        Stack backup = st;
        int size = backup.getSize();
        double temp = 0;
        double current = 0;

        try {
            temp = (double) backup.pop();
        } catch (Exception ex) {
            print(ex);
        }

        for(int i = 1; i< size; i++) {



            try {
                current = (double) backup.pop();
            } catch (Exception ex) {
                print(ex);
                break;
            }

            print("Temp: " + temp + "\nCurrent: " + current);

            if(current == temp || current*2 == temp)
            {
                temp = current;
                continue;
            }
            else return false;
        }

        return true;
    }

}
