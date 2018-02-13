package csci152.impl;

import csci152.adt.Stack;

public class ArrayStack<T> implements Stack<T> {

    private T[] values;
    private int size;
    private int maxSize = 10;

    public ArrayStack() {
        values = (T[])new Object[maxSize];
        size = 0;
    }

    @Override
    public void push(T value) {
        if(size + 1 >= maxSize) {
            T[] backup = values;
            maxSize += 10;
            values = (T[]) new Object[maxSize];
            System.arraycopy(backup, 0, values, 0, size);
            push(value);
        } else {
            values[size] = value;
            size++;
        }
    }

    @Override
    public T pop() throws Exception {
        if(size == 0) throw new Exception("The stack is empty!");
        T result = values[size-1];
        size--;
        return result;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void clear() {

        size = 0;

        maxSize = 10;

        values = (T[])new Object[maxSize];

    }

    @Override
    public String toString() {
        String contents = "";
        for(int i = 0; i<size; i++) {
            contents+=values[i];
            if(i==size-1) continue;
            contents+=",";
        }
        return "bottom["+contents+"]top\nlength: "+ this.values.length;
    }

    public void print(String txt) {
        System.out.println(txt);
    }

    public void print() {
        print(this.toString());
    }
}
