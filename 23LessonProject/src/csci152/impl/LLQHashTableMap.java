package csci152.impl;

import csci152.adt.HashTableStats;
import csci152.adt.KeyValuePair;
import csci152.adt.Map;

public class LLQHashTableMap<K extends Comparable, V> implements Map<K, V>, HashTableStats {


    private LinkedListQueue<KeyValuePair<K, V>>[] buckets;
    private int size, k;

    public LLQHashTableMap(int numOfBuckets) {
        buckets = new LinkedListQueue[numOfBuckets];
        this.size = 0;
        k = numOfBuckets;
    }

    @Override
    public void define(K key, V value) {
        KeyValuePair<K, V> thePair = null;
        int hash = key.hashCode(), rem = hash%k;
        if(buckets[rem] == null){
            buckets[rem] = new LinkedListQueue();
        }
        if((thePair = search(key, buckets[rem])) == null) {
            buckets[rem].enqueue(new KeyValuePair<>(key, value));
            this.size++;
        } else {
            thePair.setValue(value);
        }

    }

    @SuppressWarnings("Duplicates")
    private KeyValuePair<K, V> search(K key, LinkedListQueue<KeyValuePair<K, V>> buc) {
        if(buc == null) return null;
        KeyValuePair<K, V> result = null;
        int size = buc.getSize();
        LinkedListQueue<KeyValuePair<K, V>> back = new LinkedListQueue<>();
        KeyValuePair<K, V> val;
        for(int i = 0; i<size; i++) {
            try {
                val = buc.dequeue();
                buc.enqueue(val);
                if(val.getKey().equals(key)) {
                    result = val;
                    break;
                }

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return result;
    }

    @Override
    public V getValue(K key) {
        int hash = key.hashCode(), rem = hash%k;
        KeyValuePair result = null;
        if(buckets[rem] != null) {
            result = search(key, buckets[rem]);
        }
        if(result != null) return (V) result.getValue();
        return null;
    }

    @Override
    public V remove(K key) {
        System.out.println("Remove received key=" + key);
        int hash = key.hashCode(), rem = hash%k;
        if(buckets[rem] == null) return null;
        int size = buckets[rem].getSize();
        KeyValuePair<K, V> val = null;
        for(int i = 0; i<size; i++) {
            try {
                val = buckets[rem].dequeue();
                System.out.println("Loop. Val=" + val);
                if(val.getKey().equals(key)) break;
                buckets[rem].enqueue(val);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        size--;
        return val.getValue();
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        if(size == 0) throw new Exception("Hashtable is empty!");
        for(int i = 0; i<k; i++) {
            if(buckets[i] != null && buckets[i].getSize() != 0) {size--; return buckets[i].dequeue();}
        }
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        buckets = new LinkedListQueue[k];
        size = 0;
    }

    @Override
    public String toString() {
        String contents = "";
        for(int i = 0; i<k; i++) {
            if(buckets[i] != null) contents += i+":"+buckets[i].toString()+"\n";
        }
        return contents;
    }

    @Override
    public int getNumberOfBuckets() {
        return k;
    }

    @Override
    public int getBucketSize(int index) throws Exception {
        if(index > k || index < 0) throw new Exception("Index out of range");
        if(buckets[index] == null) return 0;
        return buckets[index].getSize();
    }

    @Override
    public double getLoadFactor() {
        return ((double)size)/k;
    }

    @Override
    @SuppressWarnings("Duplicates")
    public double getBucketSizeStandardDev() {
        double result = 0, mean = getLoadFactor();
//        System.out.println("Mean = " + mean);
        for(int i = 0; i<k; i++) {
            try {
                result += (getBucketSize(i) - mean)*(getBucketSize(i) - mean);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        result = result/((double)k);
        result = Math.sqrt(result);
        return result;
    }

    @Override
    public String bucketsToString() {
        return null;
    }
}
