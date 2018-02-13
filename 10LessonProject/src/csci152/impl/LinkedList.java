package csci152.impl;

import csci152.adt.Stack;

public class LinkedList<T> implements Stack<T> {

    Node top;
    int size;

    public LinkedList() {

        top = null;
        size = 0;

    }
    @Override
    public void push(T value) {
        if(size == 0) {
            top = new Node(value);
        } else {
            Node newnode = new Node(value);
            newnode.setLink(top);
            top = newnode;
        }
        size++;
    }

    @Override
    public T pop() throws Exception {
        if(size == 0) throw new Exception("The list is empty!");
        size--;
        T value = (T) top.getValue();
        top = top.getLink();
        return value;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.top = null;
    }

    @Override
    public String toString() {

        if(this.size != 0) {
            Node current = top;
            String contents = top.getValue() + "\n";
            for(int i = 1; i<this.size; i++) {
                current = current.getLink();
                contents += current.getValue() + "\n";
            }

            return contents;
        } else {
            return "Empty";
        }


    }
}
