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
        if(size<maxSize) {
            int index = (back)%maxSize;
            values[index] = value;
            back++;
            size++;
        } else {
            int[] backup = values;
            back = maxSize;
            maxSize *= 2;
            values = new int[maxSize];
            System.arraycopy(backup, 0, values, 0, size);
            enqueue(value);
        }
    }

    @Override
    public int dequeue() throws Exception {
        int result = values[front];
//        values[front] = 0;
        front++;
        size--;
        return result;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void clear() {
        maxSize = 5;
        back = 0;
        size = 0;
        front = 0;
        values = new int[maxSize];
    }

    public String toString() {
        String contents = "";
        for(int i =front; i<size; i++) {
            contents += values[i];
        }
        return "front["+contents+"]back";
    }
}
