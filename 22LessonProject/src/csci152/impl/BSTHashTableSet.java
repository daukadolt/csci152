package csci152.impl;

import csci152.adt.HashTableStats;
import csci152.adt.Queue;
import csci152.adt.Set;

import static java.lang.StrictMath.sqrt;

public class BSTHashTableSet<T extends Comparable> implements Set<T>, HashTableStats {

    private BSTSet<T>[] buckets;
    private int size, k;

    public BSTHashTableSet(int numOfBuckets) {
        buckets = new BSTSet[numOfBuckets];
        this.size = 0;
        this.k = numOfBuckets;
    }

    @Override
    public void add(T value) {
        int hash = value.hashCode(), rem = hash%k;
        if(buckets[rem] == null){
            buckets[rem] = new BSTSet<>();
        }
        int prevsize = buckets[rem].getSize();
        buckets[rem].add(value);
        if(buckets[rem].getSize()>prevsize) size++;
    }

    @Override
    public boolean contains(T value) {
        boolean result = false;
        int hash = value.hashCode(), rem = hash%k;
        if(buckets[rem] != null) {
            if(buckets[rem].contains(value)) result = true;
        }
//        System.out.println("Contains(" + value + ")=" + result);
        return result;
    }

    @Override
    public boolean remove(T value) {
        boolean result = contains(value);
        int hash = value.hashCode(), rem = hash%k;
        if(result) {
            this.size--;
            buckets[rem].remove(value);
        }
        return result;
    }

    @Override
    @SuppressWarnings("Duplicates")
    public T removeAny() throws Exception {
        T val;
        for(int i = 0; i<k; i++) {
            if(buckets[i] != null) {
                val = buckets[i].removeAny();
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
        buckets = new BSTSet[buckets.length];
        this.size = 0;
    }

    @Override
    public int getNumberOfBuckets() {
        return k;
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        if(index>k || index<0) throw new Exception("Index out of range");
        else if(buckets[index] == null) throw new Exception("Bucket is empty");
        return buckets[index].getSize();
    }

    @Override
    public double getLoadFactor() {
        return this.size/k;
    }

    @Override
    @SuppressWarnings("Duplicates")
    public double getBucketSizeStandardDev() {
        double sum = getSum();
        sum = 0;
        for(int i = 0; i<k; i++) {
            sum += buckets[i].getSize();
        }
//        System.out.println("Sum: " + sum);
//        System.out.println("Size: " + size);
        double mean = sum/this.k, stdev = 0, a = 0;
//        double a = getA(mean);
        for(int i = 0; i<k; i++) {
            a+=(buckets[i].getSize() - mean)*(buckets[i].getSize() - mean);
        }
        return sqrt(a/(this.size));
    }

    @SuppressWarnings("Duplicates")
    public int getSum() {
        System.out.println("Getting sum");
        int size = 0, sum = 0;
        Queue<T> back = new LinkedListQueue();
        T val;
        for(int i = 0; i<k; i++) {
            if(buckets[i] != null) {
                size = buckets[i].getSize();
                for(int j = 0; j<size; j++) {
                    try {
                        val = buckets[i].removeAny();
                        sum+=val.hashCode();
                        back.enqueue(val);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                for(int j = 0; j<size; j++) {
                    try {
                        buckets[i].add(back.dequeue());
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }
        return sum;
    }

    @SuppressWarnings("Duplicates")
    private double getA(double mean) {
        int size = 0;
        double a = 0;
        Queue<T> back = new LinkedListQueue();
        T val;
        for(int i = 0; i<k; i++) {
            if(buckets[i] != null) {
                size = buckets[i].getSize();
                for(int j = 0; j<size; j++) {
                    try {
                        val = buckets[i].removeAny();
                        a+=(val.hashCode()-mean)*(val.hashCode()-mean);
                        back.enqueue(val);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                for(int j = 0; j<size; j++) {
                    try {
                        buckets[i].add(back.dequeue());
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }
        return a;
    }

    @Override
    public String toString() {
        String contents = "", filler = "";
        for(int i = 0; i<k; i++) {
            if(buckets[i] != null) contents += i+":"+buckets[i].toString()+"\n";
        }
        return contents;
    }

    @Override
    public String bucketsToString() {
        return toString();
    }
}
