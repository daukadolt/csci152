package csci152;

import csci152.adt.IntQueue;
import csci152.adt.IntStack;
import csci152.impl.ArrayIntQueue;
import csci152.impl.ArrayIntStack;
import sun.jvm.hotspot.utilities.IntArray;

public class Main {

    public static void main(String[] args) {

        ArrayIntStack stack = new ArrayIntStack();


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

        IntQueue queue = new ArrayIntQueue();
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

    public static void print(Object args) {
        System.out.println(args);
    }

    /* #1 */
    public static int evenCount(IntStack stk) {
        ArrayIntStack temp = new ArrayIntStack();
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
    public static void reverseStack(IntStack stk) {
        IntQueue queue = new ArrayIntQueue();
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

    public static boolean isPalindrome(IntQueue q) {
        IntStack stk = new ArrayIntStack();
        IntQueue bkp = new ArrayIntQueue();
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

    public static void insert(IntStack st, int pos, int val) {
        int size = st.getSize(), num;
        if(pos == 0) return;
        else if(pos>size) st.push(val);
        else {
            IntStack bkp = new ArrayIntStack();
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
