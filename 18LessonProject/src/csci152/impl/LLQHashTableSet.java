package csci152.impl;

import csci152.adt.Queue;
import csci152.adt.Set;

import java.util.LinkedList;

public class LLQHashTableSet<T> implements Set<T> {

    private LinkedListQueue<T>[] buckets;
    private int size, k;
    public LLQHashTableSet(int size) {
        buckets = new LinkedListQueue[size];
        k = size;
        this.size = 0;
    }

    @Override
    public void add(T value) {
        int hash = value.hashCode(), rem = hash%k;
        if(buckets[rem] == null){
//            System.out.println("rem:" + rem);                      Debugging
            buckets[rem] = new LinkedListQueue();
        }
        if(!search(value, buckets[rem])) {
//            System.out.println("Enqueue");                         Debugging
            buckets[rem].enqueue(value);
            this.size++;
        }
    }

    @Override
    public boolean contains(T value) {
        boolean result = false;
        int hash = value.hashCode(), rem = hash%k;
        LinkedListQueue theBucket = buckets[rem];
        if(theBucket != null) {
            result = search(value, theBucket);
        }
        return result;
    }

    @Override
    public boolean remove(T value) {
        boolean result = false;
        if(contains(value)) {
            result = true;
            int hash = value.hashCode(), rem = hash%k;
            LinkedListQueue theBucket = buckets[rem];
            if(buckets[rem] != null) removeFromQueue(value, buckets[rem]);
            this.size--;
        }
        return result;
    }

    @Override
    public T removeAny() throws Exception {
        T val;
        for(int i = 0; i<k; i++) {
            if(buckets[i] != null) {
                val = buckets[i].dequeue();
                this.size--;
                return val;
            }
        }
        throw new Exception("All buckets are empty");
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void clear() {
        buckets = new LinkedListQueue[buckets.length];
        size = 0;
    }

    @SuppressWarnings("Duplicates")
    private boolean search(T value, LinkedListQueue<T> buc) {
        boolean result = false;
        int size = buc.getSize();
        LinkedListQueue<T> back = new LinkedListQueue<>();
        T val;
        for(int i = 0; i<size; i++) {
            try {
                val = buc.dequeue();
                back.enqueue(val);
                if(val.equals(value)) {
                    result = true;
                    break;
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        for(int i = 0; i<size; i++) {
            try {
                buc.enqueue(back.dequeue());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return result;
    }

    private boolean removeFromQueue(T value, Queue<T> q) {
        boolean result = false;
        int size = q.getSize(), left = 0;
        T val;
        Queue<T> back = new LinkedListQueue();
        for(int i = 0; i<size; i++) {
            try {
                val = q.dequeue();
                if(val.equals(value)) {
                    left = size - i - 1;
                    break;
                }
                back.enqueue(val);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        size = back.getSize();
        for(int i = 0; i<size; i++) {
            try {
                q.enqueue(back.dequeue());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String contents = "";
        for(int i = 0; i<k; i++) {
            if(buckets[i] != null) contents += i+":"+buckets[i].toString()+"\n";
        }
        return contents;
    }

}
