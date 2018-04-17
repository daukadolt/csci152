package csci152.impl;

import csci152.adt.Stack;

import java.util.ArrayList;

public class ArrayListStack<T> implements Stack<T> {

    private ArrayList<T> values;

    public ArrayListStack() {
        values = new ArrayList<>();
    }

    @Override
    public void push(T value) {

        values.add(value);

    }

    @Override
    public T pop() throws Exception {
        if(getSize()==0) throw new Exception("The stack is empty");
        T val = values.get(getSize()-1);
        values.remove(getSize()-1);
        return val;
    }

    @Override
    public int getSize() {
        return values.size();
    }

    @Override
    public void clear() {
        values = new ArrayList<>();
    }

    @Override
    public String toString() {
        return values.toString();
    }
}
