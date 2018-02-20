package csci152.impl;

import csci152.adt.Queue;

public class LinkedListQueue<T> implements Queue<T> {

    private Node front;
    private Node back;
    private int size;

    public LinkedListQueue() {
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public void enqueue(T value) {
        if(size == 0) {
            front = back = new Node(value);
        } else {
            back.setLink(new Node(value));
            back = back.getLink();
        }
        size++;
    }

    @Override
    public T dequeue() throws Exception {
        if(size == 0) throw new Exception("Empty you moron!");
        T result = (T) front.getValue();
        front = front.getLink();
        size--;
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
        front = null;
        back = null;
    }

    @Override
    public String toString() {
        String contents = "";

        if(size != 0) {
            Node current = front;
            while(true) {
                if(current.getLink() == null) {
                    contents += current.getValue();
                    break;
                }
                contents += current.getValue() + " ";
                current = current.getLink();
            }
        }

        return "front[   "+contents+"   ]back";
    }
}
