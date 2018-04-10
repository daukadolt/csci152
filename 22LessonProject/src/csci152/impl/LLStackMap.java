package csci152.impl;

import csci152.adt.KeyValuePair;
import csci152.adt.Map;

public class LLStackMap<K, V> implements Map<K, V> {

    private LinkedListStack<KeyValuePair<K, V>> pairs;

    public LLStackMap() {
        pairs = new LinkedListStack<>();
    }

    @Override
    public void define(K key, V value) {
    KeyValuePair newPair;
    int size = pairs.getSize();

    if(size == 0) {
        pairs.push(new KeyValuePair<>(key, value));
    } else {
        if((newPair = helper(key)) == null) {
            newPair = new KeyValuePair<>(key, value);
            pairs.push(newPair);
        } else {
            newPair.setValue(value);
        }
    }

    }

    @SuppressWarnings("Duplicates")
    private KeyValuePair helper(K key) {
        KeyValuePair val = null;
        LinkedListStack<KeyValuePair<K, V>> backup = new LinkedListStack();
        int size = pairs.getSize();
        for(int i = 0; i<size; i++) {
            try {
                val = pairs.pop();
//                if(val.getKey().equals(key)) continue;
                backup.push(val);
                if(val.getKey().equals(key)) break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        size = backup.getSize();
        for(int i = 0; i<size; i++) {
            try {
                val = backup.pop();
                pairs.push(val);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        if(val != null) if(val.getKey() != key) val = null;
        return val;
    }

    @Override
    public V getValue(K key) {
        V result = (V) helper(key).getValue();
        return result;
    }

    @Override
    @SuppressWarnings("Duplicates")
    public V remove(K key) {
        KeyValuePair val = null, copy = null;
        LinkedListStack<KeyValuePair<K, V>> backup = new LinkedListStack();
        int size = pairs.getSize();
        for(int i = 0; i<size; i++) {
            try {
                val = pairs.pop();
                if(val.getKey().equals(key)) {copy = val;continue;}
                backup.push(val);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        size = backup.getSize();
        for(int i = 0; i<size; i++) {
            try {
                pairs.push(backup.pop());
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
//        System.out.println("Copy = " + copy);
        if(copy != null) {return (V) copy.getValue();}
        return null;
    }

    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        if(pairs.getSize() == 0) throw new Exception("LLStackMap is empty!");
        return pairs.pop();
    }

    @Override
    public int getSize() {
        return pairs.getSize();
    }

    @Override
    public void clear() {
        pairs = new LinkedListStack<>();
    }

    @Override
    public String toString() {
        String contents = "";
        KeyValuePair val = null;
        LinkedListStack<KeyValuePair<K, V>> backup = new LinkedListStack<>();
        int size = pairs.getSize();
        for(int i = 0; i<size; i++) {
            try {
                val = pairs.pop();
                contents += val + " ";
                backup.push(val);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        for(int i = 0; i<size; i++) {
            try {
                val = backup.pop();
                pairs.push(val);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        return "[ " + contents + " ]";
    }

}
