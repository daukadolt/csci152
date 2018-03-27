package csci152.impl;

import csci152.adt.Set;

public class BST2Set<T extends Comparable> implements Set<T> {

    private OnOffTreeNode<T> root;
    private int size;

    @Override
    @SuppressWarnings("Duplicates")
    public void add(T value) {
//        System.out.println("Received: " + value);
        if(size == 0) root = new OnOffTreeNode<>(value);
        else {
//            System.out.println("Else chosen");
            OnOffTreeNode<T> prevNode = root;
            OnOffTreeNode<T> theNode = root;
            boolean lessthan = false;

            while(true) {
//                System.out.println("Loop iteration");
                if(theNode == null) {
//                    System.out.println("The node == null");
                    if(lessthan) prevNode.setLeft(new OnOffTreeNode<>(value));
                    else prevNode.setRight(new OnOffTreeNode<>(value));
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
        OnOffTreeNode<T> theNode = root;
        boolean lessthan = false, res = true;

        while(true) {
            if(theNode == null || (!theNode.isActive() && theNode.getLeft() == null && theNode.getRight() == null)) {
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

    @Override
    @SuppressWarnings("Duplicates")
    public boolean remove(T value) {
//        System.out.println("Reached?");
        OnOffTreeNode<T> theNode = root;
        OnOffTreeNode<T> prevNode = root;
        boolean lessthan = false, res = false;
        while(true) {
//            System.out.println("Reached?");
            if(theNode == null) {
//                System.out.println("Reached?");
                res = false;
                break;
            }
            else if (value.compareTo(theNode.getValue()) == 0) {
//                System.out.println("Reached?");
                res = true;
                /* <------- Removes the val -------> */

                /*
                if(theNode.getValue() == root.getValue()) {
                    if(size == 1) {
                        root = null;
                    }
                    else {
                        OnOffTreeNode<T> holder = theNode;
                        while(true) {
                            if(theNode == null) {
                                break;
                            }
                            else if(theNode.isActive()) {
                                theNode.deactivate();
                                root.setValue(theNode.getValue());
                                size--;
                                return res;
                            }
                            holder = theNode;
                            theNode = theNode.getRight();
                        }
                        theNode = root;
                        while(true) {
                            if(theNode.isActive()) {
                                theNode.deactivate();
                                root.setValue(theNode.getValue());
                                size--;
                                return res;
                            }
                            holder = theNode;
                            theNode = theNode.getLeft();
                        }
                    }
                } else theNode.deactivate();
                */

                res = true;
                /* <------- Removes the val -------> */
                if (theNode.getRight() == null && theNode.getLeft() == null) {
                    if(theNode.getValue().compareTo(prevNode.getValue()) > 0) {
                        prevNode.getRight().deactivate();
                    } else {
                        prevNode.getLeft().deactivate();
                    }
                    break;

                }
                else if(theNode.getLeft() != null) {
                    System.out.println("LEFT. Replacing " + theNode.getValue() + " by " + theNode.getLeft().getValue());
                    OnOffTreeNode<T> holder = theNode;
                    while(true) {
//                        System.out.println("Val: " + theNode.getValue() );
                        if(theNode.getLeft() == null) {
                            holder.getLeft().deactivate();
                            break;
                        }
                        theNode.setValue(theNode.getLeft().getValue());
                        holder = theNode;
                        theNode = theNode.getLeft();
                    }
                } else if(theNode.getRight() != null) {
                    System.out.println("RIGHT. Replacing " + theNode.getValue() + " by " + theNode.getRight().getValue());
                    OnOffTreeNode<T> holder = theNode;
                    while(true) {
                        if(theNode.getRight() == null) {
                            holder.getRight().deactivate();
                            break;
                        }
                        theNode.setValue(theNode.getRight().getValue());
                        holder = theNode;
                        theNode = theNode.getRight();
                    }
                }


                /* <------- Removes the val -------> */
                break;
            }
            else {
                prevNode = theNode;
                if(value.compareTo(theNode.getValue()) < 0) {
                    lessthan = true;
                    theNode = theNode.getLeft();
                }
                else {
                    theNode = theNode.getRight();
                    lessthan = false;
                }
            }
        }
        if(res) size--;
        return res;
    }

    @Override
    @SuppressWarnings("Duplicates")
    public T removeAny() throws Exception {
        if(size == 0) throw new Exception("Empty!");
        T val = root.getValue();
        remove(root.getValue());
        return val;
    }

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
    private String inOrder(OnOffTreeNode<T> node) {
//        Integer a = 11;
//        if(node != null && node.getValue() == a) return "GOT IT";
        if(node == null) return "";
        String contents = "";
        if(node.getLeft() != null) contents += inOrder(node.getLeft());
        if(node.isActive()) contents += node.getValue() + "\n";
        if(node.getRight() != null) contents += inOrder(node.getRight());
        return contents;
    }

    @Override
    public String toString() {
        return inOrder(root);
    }
}
