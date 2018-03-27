package csci152.impl;

import csci152.adt.Queue;
import csci152.adt.Set;

public class LLStackSet<T> implements Set<T> {

    private LinkedListStack<T> vals;

    public LLStackSet() {
        vals = new LinkedListStack<T>();
    }

    @Override
    public void add(T value) {
        if(!contains(value)) {
            vals.push(value);
        }
    }

    @Override
    public boolean contains(T value) {
        int size = vals.getSize();
        Queue<T> backup = new LinkedListQueue<T>();
        boolean result = false;
        T val;
        for(int i = 0; i<size; i++) {
            try {
                val = vals.pop();
                backup.enqueue(val);

                if(val.equals(value)) {
                    result = true;
                    break;
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        size = backup.getSize();

        for(int i = 0; i<size; i++) {
            try {
                vals.push(backup.dequeue());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        return result;
    }

    @Override
    public boolean remove(T value) {
        boolean res = contains(value);
        Queue<T> backup = new LinkedListQueue<T>();
        int size = vals.getSize();
        T val;
        for(int i = 0; i<size; i++) {
            try {
                val = vals.pop();
                if(val.equals(value)) continue;
                backup.enqueue(val);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        size = backup.getSize();

        for(int i = 0; i<size; i++) {
            try {
                vals.push(backup.dequeue());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        return res;
    }

    @Override
    public T removeAny() throws Exception {
        return vals.pop();
    }

    @Override
    public int getSize() {
        return vals.getSize();
    }

    @Override
    public void clear() {
        vals.clear();
    }

    @Override
    public String toString() {
        return vals.toString();
    }
}
