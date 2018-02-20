package csci152.adt_tests;

import csci152.adt.Queue;
import csci152.adt.Stack;
import csci152.impl.LinkedListQueue;
import csci152.impl.LinkedListStack;

public class LinkedListQueueTest {

    public static void main(String[] args) {

        /* Creates a new queue and tries to dequeue from the empty queue */

        print("Creates a new queue and tries to dequeue from the empty queue:");

        Queue test = new LinkedListQueue();

        try {
            test.dequeue();
        } catch (Exception ex) {
            print(ex.getMessage());
        }

        /* Enqueues 8 items on the queue using a loop, and then prints its contents and size afterwards */

        print("\n\n\n\n\nEnqueues 8 items on the queue using a loop, and then prints its contents and size afterwards: ");

        for(int i = 0; i<9; i++) {
            test.enqueue(i);
        }

        print(test);

        /* Dequeue 3 items from the queue, and print its contents and resulting size */

        print("\n\n\n\n\nDequeue 3 items from the queue, and print its contents and resulting size");

        try {
            test.dequeue();
            test.dequeue();
            test.dequeue();
        } catch (Exception ex) {
            print(ex);
        }

        print(test);
        print("Size: " + test.getSize());

        /* Create a for loop that iterates 9 times, where the body enqueues two items, and then dequeues two items.
         Print the queue’s contents and size after each iteration. */


        print("\n\n\n\n\nCreate a for loop that iterates 9 times, where the body enqueues two items, and then dequeues two items.\n" +
                "         Print the queue’s contents and size after each iteration.");

        for(int i = 0; i<10; i++) {
            test.enqueue(i);
            test.enqueue(i);
            try {
                test.dequeue();
                test.dequeue();
            } catch (Exception ex) {
                print(ex);
            }
            print(test);
        }

        /* Clear the queue, and print its contents and resulting size */

        print("\n\n\n\n\nClear the queue, and print its contents and resulting size");

        test.clear();
        print(test);


        /* Enqueue 22 more items to the queue using a loop, and again print its contents and resulting size */

        print("\n\n\n\n\nEnqueue 22 more items to the queue using a loop, and again print its contents and resulting size");

        for(int i = 0; i<22; i++) {

            test.enqueue(i);

        }

        print(test);
        print("Size: " + test.getSize());

        /* Task #2 */

        print("\n\n\n\n\nisBalanced test:\n\n");

        Queue chars = new LinkedListQueue();
        chars.enqueue('{');
        chars.enqueue('[');
        chars.enqueue(']');
        chars.enqueue('(');
        chars.enqueue(')');
        chars.enqueue('{');
        chars.enqueue('}');

        try{
            print(isBalanced(chars));
        } catch (Exception ex) {
            print(ex);
        }

        print(chars);

        Queue empty_chars = new LinkedListQueue();

        try{
            print(isBalanced(chars));
        } catch (Exception ex) {
            print(ex);
        }

        print(empty_chars);

        /* isPalindrome test */

        print("\n\n\n\n\nisPalindrome test:\n\n");

        chars.clear();

        chars.enqueue('[');
        chars.enqueue(']');
        chars.enqueue(']');
        chars.enqueue('[');

        print(isPalindrome(chars));

        print(chars);

    }

    /* WARNING, YOU'RE LEAVING MAIN METHOD! */


    /* FUNCTIONS START HERE */

    public static void print(Object val) {
        System.out.println(val);
    }

    public static boolean isBalanced(Queue<Character> q) throws Exception {
        if(q.getSize()%2 != 0) return false;
        else if(q.getSize() == 0) return true;
        else {
        boolean result = true;
        Queue bkp = new LinkedListQueue();
        Stack op_brkts = new LinkedListStack<Character>();
        Queue cls_brkts = new LinkedListQueue<Character>();
        int size = q.getSize();
        char val = '|', op = '|', cls = '|';

        for(int i = 0; i<size; i++) {
            try {
                val = q.dequeue();
            } catch (Exception ex) {
                print(ex.getMessage());
                break;
            }

            bkp.enqueue(val);

            if(val == '{' || val == '(' || val == '[') {
                print(val);
                op_brkts.push(val);
            }
            else if (val == '}' || val == ')' || val == ']') {
                print(val);
                cls = val;
            }

            if(op_brkts.getSize() != 0) {
                if (cls != '|') {
                    try {
                        op = (char) op_brkts.pop();
                    } catch (Exception ex) {
                        print(ex.getMessage());
                        break;
                    }

                    print("Comparing " + op + " and " + cls);

                    if( (op == '{' && cls == '}') || (op == '[' && cls == ']') || (op == '(' && cls == ')') ) {
                        cls = '|';
                    } else {
                        return false;
                    }
                } else if (i == size - 1) return false;

            }
        }

        for(int i = 0; i<size; i++) {
            try {
                q.enqueue((char)bkp.dequeue());
            } catch (Exception ex) {
                print(ex.getMessage());
                break;
            }
        }

        return result;
        }
    }

    public static boolean isPalindrome(Queue<Character> q) {
        if(q.getSize() == 0) return true;
        int size = q.getSize();
        boolean result = true;
        char val, a, b;

        Stack stack = new LinkedListStack();
        Queue queue = new LinkedListQueue();

        for(int i = 0; i<size; i++) {
            try {
                val = q.dequeue();
//                print("Val: " + val);
                stack.push(val);
//                print(stack);
                queue.enqueue(val);
                q.enqueue(val);
//                print(queue);

            } catch (Exception ex) {
                print(ex);
                break;
            }
        }

        for(int i = 0; i<size; i++) {
            try {
                a = (char) queue.dequeue();
                b = (char) stack.pop();
//               print("Comparing " + a + " and " + b);
            } catch (Exception ex) {
                print(ex);
            }
        }


        return result;

    }

}
