package csci152.adt_tests;

import csci152.adt.Stack;
import csci152.impl.ArrayStack;
import csci152.impl.LinkedListStack;

public class LinkedListStackTest {

    public static void main(String[] args) {

        LinkedListStack stack = new LinkedListStack<Integer>();

        /* Creates a new stack and tries to pop from the empty stack */

        try {
            stack.pop();
        } catch (Exception ex) {
            print(ex.getMessage());
        }

        /* Pushes 12 items on the stack using a loop, and then prints the stack contents and its size afterwards */

        for(int i = 0; i<13; i++) {
            stack.push(i);
        }

        print(stack);
        print(stack.getSize());

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

        Stack test = new LinkedListStack<Double>();



//        for(double i = 2; i<50; i*=2) {
//            if(i == 8.0) {test.push(3.0); continue;}
//            test.push(i);
//        }

        test.push(50.0);
        test.push(18.0);
        test.push(19.0);

        print(test);

        print(isIncreasing(test));

        print(test);

    }

    public static void print(Object obj) {
        System.out.println(obj);
    }

    public static boolean isIncreasing(Stack<Double> st) {
        if(st.getSize() == 0 || st.getSize() == 1) return true;
        else {
            Boolean result = true;
            Stack backup = new ArrayStack();
            int size = st.getSize();
            double temp = 0;
            double current = 0;

            try {
                temp = st.pop();
                backup.push(temp);
            } catch (Exception ex) {
                print(ex);
            }

            for(int i = 1; i< size; i++) {



                try {
                    current = st.pop();
                } catch (Exception ex) {
                    print(ex);
                    break;
                }

//                print("Temp: " + temp + "\nCurrent: " + current);

                backup.push(current);

                if(current == temp || current < temp)
                {
                    temp = current;
                    continue;
                }
                else {result = false; break;}
            }

           while(true) {
                try {
//                    print(backup.pop());
                    st.push((double) backup.pop());
                } catch (Exception ex) {
//                    print(ex);
                    break;
                }
           }

//            print(st);

            return result;
        }
    }

}
