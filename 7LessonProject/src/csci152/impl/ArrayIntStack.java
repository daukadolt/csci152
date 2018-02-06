package csci152.impl;

import csci152.adt.IntStack;

public class ArrayIntStack implements IntStack {

    private int[] values;
    private int size;
    private int maxSize = 10;

    public ArrayIntStack() {
        values = new int[maxSize];
        size = 0;
    }

    @Override
    public void push(int value) {
        if(size + 1 >= maxSize) {
            int[] backup = values;
            maxSize += 10;
            values = new int[maxSize];
            System.arraycopy(backup, 0, values, 0, size);
            push(value);
        } else {
            values[size] = value;
            size++;
        }
    }

    @Override
    public int pop() throws Exception {
        if(size == 0) throw new Exception("The stack is empty!");
        int result = values[size-1];
        size--;
        return result;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void clear() {

        for(int i = 0; i<size; i++) {
            values[i] = 0;
        }

        size = 0;

        maxSize = 10;

        values = new int[maxSize];

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
