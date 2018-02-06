package csci152.adt_tests;

import csci152.adt.Stack;
import csci152.impl.ArrayStack;

public class ArrayStackTest {

    public static void main(String[] args) {

        ArrayStack<Integer> stack = new ArrayStack();

        stack.push(123);

        try{
            stack.pop();
            stack.push(4);
        } catch (Exception ex) {
            stack.print(ex+"");
        }

        stack.push(123);
        stack.print(stack.toString());

        ArrayStack<Integer> mystack = new ArrayStack();

        mystack.push(123);
        mystack.push(124);
        stack.print(mystack.toString());

    }

}
