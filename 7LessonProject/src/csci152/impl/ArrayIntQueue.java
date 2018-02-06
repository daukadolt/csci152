package csci152.impl;

import csci152.adt.IntQueue;

public class ArrayIntQueue implements IntQueue {

    private int[] values;
    private int size;
    private int maxSize = 5;
    private int front;
    private int back;

    public ArrayIntQueue() {
        values = new int[maxSize];
        size = 0;
        front = 0;
        back = 0;
    }

    @Override
    public void enqueue(int value) {

        if(size >= maxSize) {

            int[] backup = values;
            maxSize *= 2;
            values = new int[maxSize];
            System.arraycopy(backup, 0, values, 0, size);
            enqueue(value);

        } else {
            values[back] = value;
            size++;
            back++;
        }

    }

    @Override
    public int dequeue() throws Exception {

        if(size == 0) throw new Exception("Size = 0");

        int result = values[front];
        values[front] = 123;

        front++;
//        size--;


        return result;


    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {

//        for(int i = 0; i<maxSize; i++) {
//            values[i] = 0;
//        }

        size = 0;

        front = 0;

        back = 0;

        maxSize = 5;

        values = new int[maxSize];

    }

    @Override
    public String toString() {
        String contents = "";
        for(int i = front; i<back; i++) {
            contents+=values[i];
            if(i==back-1) continue;
            contents+=",";
        }
        return "front["+contents+"]back\nlength: "+ this.values.length;
    }
}
