package csci152.impl;

import csci152.adt.Deque;

public class LinkedListDeque<T> implements Deque<T> {

    private int size;

    private DoublyLinkedNode<T> front;
    private DoublyLinkedNode<T> back;

    public LinkedListDeque() {
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public void pushToFront(T value) {

       DoublyLinkedNode newNode = new DoublyLinkedNode(value);

       if (size == 0) {
           front = newNode;
           back = newNode;
       } else {
           front.setPrevious(newNode);
           newNode.setNext(front);
           front = newNode;
       }
       size++;


    }

    @Override
    public void pushToBack(T value) {

        DoublyLinkedNode newNode = new DoublyLinkedNode(value);

        if(size == 0) {
            front = newNode;
            back = newNode;
        } else {
            back.setNext(newNode);
            newNode.setPrevious(back);
            back = newNode;
        }

        size++;

    }

    @Override
    public T popFromFront() throws Exception {
        if(size == 0) throw new Exception("Empty!");
        T value = front.getValue();

        if(size == 1) {
            front = null;
            back = null;
        } else {
            DoublyLinkedNode next = front.getNext();
            next.setPrevious(null);
            front = next;
        }

        size--;

        return value;
    }

    @Override
    public T popFromBack() throws Exception {
        if(size == 0) throw new Exception("Empty!");
        T value = back.getValue();

        if(size == 1) {
            front = null;
            back = null;
        } else {
            DoublyLinkedNode prev = back.getPrevious();
            prev.setNext(null);
            back = prev;
        }

        size--;

        return value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {

        front = null;
        back = null;
        size = 0;

    }

    @Override
    public String toString() {

        String contents = "";

        if(size != 0) {
            DoublyLinkedNode current = front;

            while(true) {
                if(current == back) {
                    contents += current.getValue();
                    break;
                }
                contents += current.getValue() + ", ";
                current = current.getNext();
            }
        }



        return "front["+contents+"]back";
    }
}
