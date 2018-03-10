package csci152.impl;

import csci152.adt.Set;

public class LLQueueSet<T extends Comparable> implements Set<T> {

    private LinkedListQueue<T> vals;
    private int size;

    public LLQueueSet() {
        vals = new LinkedListQueue<T>();
        size = 0;
    }


    @Override
    public void add(T value) {
        LinkedListQueue<T> backup = new LinkedListQueue<T>();
        boolean found = false;
        if(size == 0) {vals.enqueue(value); size++;}
        else {
            found = contains(value);
//            System.out.println("Found: " + found);
            if(!found) {
                vals.enqueue(value);
                size++;
            }
//            size++;
        }
    }

    @Override
    public boolean contains(T value) {
        boolean found = false;
        T val;
        for(int i = 0; i<size; i++) {
            try {
//                System.out.println("Step 2. Iteration: " + i);
                val = vals.dequeue();
                vals.enqueue(val);
                if(val.equals(value)) {
                    found = true;
                    break;
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        return found;
    }

    @Override
    public boolean remove(T value) {
        boolean found = false;
        T val;
            for(int i = 0; i<size; i++) {
                try {
                    val = vals.dequeue();
                    if(val.equals(value)) {found = true; continue;}
                    vals.enqueue(val);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
            if(found) size--;
            return found;
    }

    @Override
    public T removeAny() throws Exception {
        return vals.dequeue();
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void clear() {
        vals.clear();
        size = 0;
    }

    @Override
    public String toString() {
        return vals.toString();
    }

}
