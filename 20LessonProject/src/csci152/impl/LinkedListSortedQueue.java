package csci152.impl;

import csci152.adt.SortedQueue;

public class LinkedListSortedQueue<T extends Comparable> implements SortedQueue<T> {

    private Node<T> front;

    private int size;

    public LinkedListSortedQueue() {
        front = null;
        size = 0;
    }

    @Override
    public void insert(T value) {

        Node<T> newNode = new Node(value);

        if (size == 0) front = newNode;
        else {
            if(value.compareTo(front.getValue()) <= 0) {
                newNode.setLink(front);
                front = newNode;
            } else if(value.compareTo(front.getValue()) > 0) {
                Node current = front;
                while(current.getLink() != null) {
                    if(value.compareTo(current.getLink().getValue()) <= 0) break;
                    current = current.getLink();
                }
                newNode.setLink(current.getLink());
                current.setLink(newNode);
            }
        }

        size++;

    }

    @Override
    public T dequeue() throws Exception {
        if(size == 0) throw new Exception("Empty");
        T result = front.getValue();
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
        front = null;
        size = 0;
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
