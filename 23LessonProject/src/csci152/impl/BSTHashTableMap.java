package csci152.impl;

import csci152.adt.HashTableStats;
import csci152.adt.KeyValuePair;
import csci152.adt.Map;

public class BSTHashTableMap<K extends Comparable, V> implements Map<K, V>, HashTableStats {

    private TreeNode<KeyValuePair<K, V>>[] buckets;
    int size, k;

    public BSTHashTableMap(int numOfBuckets) {
        buckets = new TreeNode[numOfBuckets];
        size = 0;
        k = numOfBuckets;
    }

    @Override
    public void define(K key, V value) {
        KeyValuePair<K, V> thePair = null;
        int hash = key.hashCode(), rem = hash%k;
        if(buckets[rem] == null){
            buckets[rem] = new TreeNode<>(new KeyValuePair(key, value));
            size++;
        }
        if((thePair = search(key, buckets[rem])) == null) {
            addValue(buckets[rem], new KeyValuePair<>(key, value));
            size++;
        } else {
            thePair.setValue(value);
        }

    }

    private void addValue(TreeNode<KeyValuePair<K, V>> root, KeyValuePair<K, V> pair) {

        if(root == null) return;

        TreeNode<KeyValuePair<K, V>> previous = root;
        TreeNode<KeyValuePair<K, V>> current = root;
        boolean smaller = false;

        while(true) {
            if(current == null) {
                if(smaller) previous.setLeft(new TreeNode<>(pair));
                else previous.setRight(new TreeNode<>(pair));
                size++;
                break;
            } else if(current.getValue().getKey().equals(pair.getKey())) break;
            else if(pair.getKey().compareTo(current.getValue().getKey())<0) {
                smaller = true;
                previous = current;
                current = current.getLeft();
            } else if(pair.getKey().compareTo(current.getValue().getKey())>0) {
                smaller = false;
                previous = current;
                current = current.getRight();
            }
        }

    }

    @SuppressWarnings("Duplicates")
    private KeyValuePair<K, V> search(K key, TreeNode<KeyValuePair<K, V>> root) {
        if(root == null) return null;
        KeyValuePair<K, V> result = null;
        TreeNode<KeyValuePair<K, V>> current = root;
        while(true) {
            if(current == null) break;
            if(current.getValue().getKey().equals(key)) {
                result = current.getValue();
                break;
            }
            if(key.compareTo(current.getValue().getKey())<0) {
                current = current.getLeft();
            } else if(key.compareTo(current.getValue().getKey())>0) {
                current = current.getRight();
            }
        }
        return result;
    }


    @Override
    public V getValue(K key) {
        int hash = key.hashCode(), rem = hash%k;
        KeyValuePair<K, V> result = search(key, buckets[rem]);
        if(result!=null) return result.getValue();
        return null;
    }

    @Override
    public V remove(K key) {
        int hash = key.hashCode(), rem = hash%k;
        V result = delete(key, buckets[rem]);
        return result;
    }

    @SuppressWarnings("Duplicates")
    private V delete(K key, TreeNode<KeyValuePair<K, V>> root) {
        if(root == null) return null;
        // TODO Auto-generated method stub
//        System.out.println("Removing key="+key);
//        System.out.println("Root="+root);
        TreeNode<KeyValuePair<K, V>> previous = root;
        TreeNode<KeyValuePair<K, V>> current = root;
        boolean smaller = false;
        V value = null;
        TreeNode<KeyValuePair<K, V>> result = null;
        int iter = 0;
        while(true) {
            if(current == null) {
                break;
            }
//            System.out.println("Iteration #" + iter);
//            System.out.println("Previous = " + previous.getValue());
//            System.out.println("Current = " + current.getValue());
            if(key.compareTo(current.getValue().getKey()) < 0) {
//                System.out.println("Less");
                smaller = true;
                previous = current;
                current = current.getLeft();
            } else if(key.compareTo(current.getValue().getKey()) > 0) {
//                System.out.println("Larger");
                smaller = false;
                previous = current;
                current = current.getRight();
            } else if (key.equals(current.getValue().getKey())) {
//                System.out.println("EQUALS");
                if(current.getValue().getKey() == previous.getValue().getKey()) {
                    if(current.getLeft() == null && current.getRight() == null) buckets[key.hashCode()%k] = null;
                    else if(current.getLeft() == null && current.getRight() != null) buckets[key.hashCode()%k] = root.getRight();
                    else if(current.getLeft() != null && current.getRight() == null) buckets[key.hashCode()%k] = root.getLeft();
                    else if(current.getRight() != null && current.getLeft() != null) current.setValue(minVal(current));
                }
//                System.out.println("Found the value! key:val = " + current.getValue().getKey()+":"+current.getValue().getValue());
//                System.out.println("Previous = " + previous.getValue());
                result = current;
                break;
            }
            iter++;
        }
        if(result != null) {
//            System.out.println("not null result");
            value = result.getValue().getValue();
            if(current.getLeft() == null && current.getRight() == null) {
                if(smaller) previous.setLeft(null);
                else previous.setRight(null);
            } else if(current.getLeft() != null && current.getRight() == null) {
                if(smaller) previous.setLeft(current.getLeft());
                else previous.setRight(current.getLeft());
            } else if(current.getLeft() == null && current.getRight() != null) {
//                    System.out.println("Right not null");
//                    System.out.println("Previous = " + previous.getValue());
//                    System.out.println("Current = " + current.getValue());
                if(smaller) previous.setLeft(current.getRight());
                else previous.setRight(current.getRight());
            } else {
//                    System.out.println("Else");
                current.setValue(minVal(current));
            }
            size--;
            return value;
        }
        return null;
    }

    @SuppressWarnings("Duplicates")
    private KeyValuePair<K, V> minVal(TreeNode<KeyValuePair<K, V>> previous) {
        TreeNode theNode = previous;
        TreeNode current = previous.getRight();
        KeyValuePair<K, V> val = (KeyValuePair<K, V>) current.getValue();
        while(current.getLeft() != null) {
            previous = current;
            current = current.getLeft();
            val = (KeyValuePair<K, V>) current.getValue();
        }
        remove(val.getKey());
        theNode.setValue(val);
        return val;
    }


    @Override
    public KeyValuePair<K, V> removeAny() throws Exception {
        if(size == 0) throw new Exception("The BSTHashTableMap is empty!");
        KeyValuePair<K, V> result = null;
        for(int i = 0; i<k; i++) {
            if(buckets[i] != null) {result = buckets[i].getValue(); remove(buckets[i].getValue().getKey()); break;}
        }
        return result;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        buckets = new TreeNode[k];
        size = 0;
    }

    @SuppressWarnings("Duplicates")
    private String inOrder(TreeNode<KeyValuePair<K, V>> node) {
        if(node == null) return "";
        String contents = "";
        if(node.getLeft() != null) contents += inOrder(node.getLeft());
        contents += node.getValue() + " ";
        if(node.getRight() != null) contents += inOrder(node.getRight());
        return contents;
    }

    @Override
    public String toString() {
        String contents = "";
        for(int i = 0; i<k; i++) {
            if(buckets[i]!=null) contents += i+":"+inOrder(buckets[i])+"\n";
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
        return bstCounter(buckets[index]);
    }

    private int bstCounter(TreeNode<KeyValuePair<K, V>> root) {
        if(root == null) return 0;
        else if(root.getLeft() == null && root.getRight() == null) return 1;
        else {
            return bstCounter(root.getRight()) + bstCounter(root.getLeft());
        }
    }


    @Override
    public double getLoadFactor() {
        return ((double)size)/((double)k);
    }

    @Override
    @SuppressWarnings("Duplicates")
    public double getBucketSizeStandardDev() {
        double result = 0, mean = getLoadFactor();
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
