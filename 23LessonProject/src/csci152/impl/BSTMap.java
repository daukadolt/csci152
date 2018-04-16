package csci152.impl;

import csci152.adt.KeyValuePair;
import csci152.adt.Map;

public class BSTMap<K extends Comparable, V> implements Map<K, V> {
    private TreeNode<KeyValuePair<K,V>> root;
    private int size;

    public BSTMap() {
        root = null;
        size = 0;
    }

    @Override
    @SuppressWarnings("Duplicates")
    public void define(K key, V value) {
//        System.out.println("Define called. key:val = " + key + ":"+ value);
        // TODO Auto-generated method stub
        if(size == 0) {root = new TreeNode<>(new KeyValuePair<>(key, value)); size++;}
        else {
            TreeNode<KeyValuePair<K, V>> previous = root;
            TreeNode<KeyValuePair<K, V>> current = root;
            boolean smaller = false;
//            System.out.println("Define while init");
            while(true) {
//                System.out.println("Loop. Current = " + current);
                if(current == null) {
//                    System.out.println("Current == null");
                    if(smaller) previous.setLeft(new TreeNode<>(new KeyValuePair<>(key, value)));
                    else previous.setRight(new TreeNode<>(new KeyValuePair<>(key, value)));
                    size++;
                    break;
                }
                previous = current;
                if(key.compareTo(current.getValue().getKey()) < 0) {
                    smaller = true;
                    current = current.getLeft();
                } else if(key.compareTo(current.getValue().getKey()) > 0) {
                    smaller = false;
                    current = current.getRight();
                } else if (key.equals(current.getValue().getKey())) {
//                    System.out.println("Such a key-value pair already exists");
                    current.getValue().setValue(value);
                    break;
                }
            }
        }
    }


    @Override
    @SuppressWarnings("Duplicates")
    public V getValue(K key) {
        // TODO Auto-generated method stub
        TreeNode<KeyValuePair<K, V>> previous = root;
        TreeNode<KeyValuePair<K, V>> current = root;
        boolean smaller = false;
        TreeNode<KeyValuePair<K, V>> result = null;
        while(true) {
            if(current == null) {
                break;
            }
            previous = current;
            if(key.compareTo(current.getValue().getKey()) < 0) {
                smaller = true;
                current = current.getLeft();
            } else if(key.compareTo(current.getValue().getKey()) > 0) {
                smaller = false;
                current = current.getRight();
            } else if (key.equals(current.getValue().getKey())) {
                System.out.println("Found the value!");
                result = current;
                break;
            }
        }
        if(result != null) return result.getValue().getValue();
        return null;
    }

    @Override
    @SuppressWarnings("Duplicates")
    public V remove(K key) {
        // TODO Auto-generated method stub
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
                if(current.getValue().getKey() == previous.getValue().getKey()) {
                    if(current.getLeft() == null && current.getRight() == null) root = null;
                    else if(current.getLeft() == null && current.getRight() != null) root = root.getRight();
                    else if(current.getLeft() != null && current.getRight() == null) root = root.getLeft();
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
        // TODO Auto-generated method stub
        if (size == 0) throw new Exception("The BSTMap is empty!");
//        System.out.println("Removing root with key:val = " + root.getValue().getKey()+":"+root.getValue().getValue());
        KeyValuePair result = root.getValue();
        remove(root.getValue().getKey());
        return result;
    }

    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        return size;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        root = null;
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
        // TODO Implement me!
        return "[ " + inOrder(root) + " ]";
    }
}
