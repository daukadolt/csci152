package csci152.lesson8_tests;

import csci152.adt.Stack;
import csci152.adt.Queue;

import csci152.impl.ArrayStack;
import csci152.impl.ArrayQueue;

public class Main {

    public static void main(String[] args) {

        Stack<Integer> stack = new ArrayStack();


        /* #1 */

        for(int i = 0; i<10; i++) {
            stack.push(i);
        }

        print(evenCount(stack));
        print(stack);

        /* #4 */

        reverseStack(stack);

        print(stack);


        /* #6 */

        Queue<Integer> queue = new ArrayQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(2);
        print(isPalindrome(queue));

        /* #7 */
        stack.clear();
        for(int i = 0; i<10; i++) {
            stack.push(i);
        }

        insert(stack, 1, 999);

        print(stack);


    }

    // Methods start here

    public static void print(Object args) {
        System.out.println(args);
    }

    /* #1 */
    public static int evenCount(Stack<Integer> stk) {
        Stack<Integer> temp = new ArrayStack<>();
        int count = 0;
        int num;
        while(true) {
            try {
                num = stk.pop();
            } catch (Exception ex) {
                break;
            }
            temp.push(num);
            if(num % 2 == 0 && num != 0) count++;
        }
        while(true) {
            try {
                num = temp.pop();
            } catch (Exception ex) {
                break;
            }
            stk.push(num);
        }
        return count;
    }

    /* #4 */
    public static void reverseStack(Stack<Integer> stk) {
        Queue<Integer> queue = new ArrayQueue<>();
        int num;
        while(true) {
            try{
                num = stk.pop();
                queue.enqueue(num);
            } catch (Exception ex) {
                break;
            }
        }
        while(true) {
            try{
                num = queue.dequeue();
                stk.push(num);
            } catch (Exception ex) {
                break;
            }
        }
    }


    /* #6 */

    public static boolean isPalindrome(Queue<Integer> q) {
        Stack<Integer> stk = new ArrayStack<>();
        Queue<Integer> bkp = new ArrayQueue<>();
        boolean result = true;
        int num, a, b, size = q.getSize();
        for(int i = 0; i<size; i++){
            try {
                num = q.dequeue();
                bkp.enqueue(num);
                stk.push(num);
            } catch (Exception ex) {
                break;
            }
        }
        print(stk);
        for(int i = 0; i<size; i++){
            try {
                a = bkp.dequeue();
                b = stk.pop();
            } catch (Exception ex) {
                break;
            }

            if(a != b) {
                result = false;
                break;
            }
        }
        return result;
    }


    /* #7 */

    public static void insert(Stack<Integer> st, int pos, int val) {
        int size = st.getSize(), num;
        if(pos == 0) return;
        else if(pos>size) st.push(val);
        else {
            Stack<Integer> bkp = new ArrayStack<>();
            for(int i = 0; i<size-pos; i++) {
                try {
                    num = st.pop();
                    bkp.push(num);
                } catch (Exception ex) {
                    print("Exception caught");
                    break;
                }
            }
            st.push(val);
            size = bkp.getSize();
            for(int i = 0; i<size; i++) {
                try {
                    num = bkp.pop();
                    st.push(num);
                } catch (Exception ex) {
                    print("Exception caught");
                    break;
                }
            }
        }
    }

}
