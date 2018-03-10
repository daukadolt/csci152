package csci152.impl;

import csci152.adt.Set;
public class BSTSet<T extends Comparable> implements Set<T> {

    private TreeNode<T> root;
    private int size;

    @Override
    @SuppressWarnings("Duplicates")
    public void add(T value) {
//        System.out.println("Received: " + value);
        if(size == 0) root = new TreeNode<>(value);
        else {
//            System.out.println("Else chosen");
            TreeNode<T> prevNode = root;
            TreeNode<T> theNode = root;
            boolean lessthan = false;

            while(true) {
//                System.out.println("Loop iteration");
                if(theNode == null) {
//                    System.out.println("The node == null");
                    if(lessthan) prevNode.setLeft(new TreeNode<>(value));
                    else prevNode.setRight(new TreeNode<>(value));
                    break;
                }
                else if (value.compareTo(theNode.getValue()) == 0) {
//                    System.out.println("CompareTo == 0");
                    return;
                }
                else {
//                    System.out.println("Second else chosen");
//                    System.out.println(value.compareTo(theNode.getValue()));
                    prevNode = theNode;
                    if(value.compareTo(theNode.getValue()) < 0) {
//                        System.out.println("CompareTo < 0");
                        lessthan = true;
                        theNode = theNode.getLeft();
                    }
                    else {
//                        System.out.println("CompareTo > 0");
                        theNode = theNode.getRight();
                        lessthan = false;
                    }
                }
            }
        }
        size++;
    }


    @Override
    @SuppressWarnings("Duplicates")
    public boolean contains(T value) {
        TreeNode<T> theNode = root;
        boolean lessthan = false, res = true;

        while(true) {
            if(theNode == null) {
                res = false;
                break;
            }
            else if (value.compareTo(theNode.getValue()) == 0) {
                res = true;
                break;
            }
            else {
                if(value.compareTo(theNode.getValue()) < 0) {
                    lessthan = true;
                    theNode = theNode.getLeft();
                }
                else if (value.compareTo(root.getValue()) > 0) {
                    theNode = theNode.getRight();
                    lessthan = false;
                }
            }
        }
        return res;
    }

    /* <----- Ignored -----> */

    @Override
    public boolean remove(T value) {
        return false;
    }

    @Override
    public T removeAny() throws Exception {
        return null;
    }

    /* <----- Ignored -----> */

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @SuppressWarnings("Duplicates")
    private String inOrder(TreeNode<T> node) {
        if(node == null) return "";
        String contents = "";
        if(node.getLeft() != null) contents += inOrder(node.getLeft());
        contents += node.getValue() + "\n";
        if(node.getRight() != null) contents += inOrder(node.getRight());
        return contents;
    }

    @Override
    public String toString() {
        return inOrder(root);
    }
}
