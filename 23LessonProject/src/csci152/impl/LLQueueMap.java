package csci152.impl;

import csci152.adt.KeyValuePair;
import csci152.adt.Map;

public class LLQueueMap<K, V> implements Map<K, V> {

    private LinkedListQueue<KeyValuePair<K, V>> pairs;
    private int size;

    public LLQueueMap() {
        pairs = new LinkedListQueue();
        size = 0;
    }

    @Override
    public void define(K key, V value) {
//        System.out.println("Received " + key + ":"+value);
        KeyValuePair<K, V> newPair;
        if(size == 0) {
            pairs.enqueue(new KeyValuePair<>(key, value));
            size++;
        } else {
            if((newPair = helper(key)) == null) {
//                System.out.println("Key="+key + " pair="+newPair);
                newPair = new KeyValuePair<>(key, value);
                pairs.enqueue(newPair);
                size++;
            } else {
//                System.out.println("Key="+key + " value = not null"+"pair="+newPair);
                newPair.setValue(value);
            }
        }

    }

    @Override
    public V getValue(K key) {
        V result = (V) helper(key).getValue();
        return result;
    }

    @SuppressWarnings("Duplicates")
    private KeyValuePair helper(K key) {
        KeyValuePair val = null;
        for(int i = 0; i<size; i++) {
            try {
                val = pairs.dequeue();
                pairs.enqueue(val);
                if(val.getKey().equals(key)) {
                    break;
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        if(val != null) if(val.getKey() != key) val = null;
        return val;
    }

    @Override
    @SuppressWarnings("Duplicates")
    public V remove(K key) {
        KeyValuePair val = null;
        V result = null;
        for(int i = 0; i<size; i++) {
            try {
                val = pairs.dequeue();
                if(val.getKey().equals(key)) {
//                    System.out.println("Found one! key = " + key + "object =" + val);
                    break;
                }
                pairs.enqueue(val);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        if(val != null) if(val.getKey() == key) {result = (V) val.getValue(); size--;}
        return result;
    }

    @Override
    public KeyValuePair removeAny() throws Exception {
        if(size == 0) throw new Exception("The map is empty");
        KeyValuePair result = pairs.dequeue();
        size--;
        return result;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void clear() {
        pairs = new LinkedListQueue<>();
        size = 0;
    }

    @Override
    public String toString() {
        String contents = "";
        KeyValuePair val = null;
        for(int i = 0; i<size; i++) {
            try {
                val = pairs.dequeue();
//                System.out.println("val = " + val);
                contents += val.toString();
                contents += ", ";
                pairs.enqueue(val);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        contents = "[ " + contents + " ]";
        return contents;
    }
}
