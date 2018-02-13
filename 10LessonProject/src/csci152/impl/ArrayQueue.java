package csci152.impl;

import csci152.adt.Queue;

public class ArrayQueue<T> implements Queue<T> {

    private T[] values;
    private int size;
    private int maxSize = 5;
    private int front;
    private int back;

    public ArrayQueue() {
        values = (T[])new Object[maxSize];
        size = 0;
        front = 0;
        back = 0;
    }

    @Override
    public void enqueue(T value) {
        if(size<maxSize) {
            int index = (back)%maxSize;
            values[index] = value;
            back++;
            size++;
        } else {
            T[] backup = values;
            back = maxSize;
            maxSize *= 2;
            values = (T[])new Object[maxSize];
            System.arraycopy(backup, 0, values, 0, size);
            enqueue(value);
        }
    }

    @Override
    public T dequeue() throws Exception {
        if(size == 0) throw new Exception("The queue is empty!");
        T result = values[front];
        values[front] = null;
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
        values = (T[])new Object[maxSize];
    }

    public String toString() {
        String contents = "";
        for(int i =front; i<size; i++) {
            contents += values[i];
        }
        return "front["+contents+"]back";
    }
}
