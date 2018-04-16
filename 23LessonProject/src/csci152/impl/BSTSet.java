package csci152.impl;

import csci152.adt.Set;

public class BSTSet<T extends Comparable> implements Set<T> {

    private TreeNode<T> root;
    private int size;

    @Override
    @SuppressWarnings("Duplicates")
    public void add(T value) {

        if(root == null) {
            root = new TreeNode(value);
            size++;
        }
        if(value.compareTo(root.getValue())<0) {

            TreeNode current = root;
            TreeNode prev = root;
            boolean smaller = true;

            while(true) {
                if(current == null) {
                    if(smaller) prev.setLeft(new TreeNode(value));
                    else prev.setRight(new TreeNode(value));
                    size++;
                    break;
                }
                prev = current;
                if(value.compareTo(current.getValue())<0) {
                    current = current.getLeft();
                    smaller = true;
                } else if(value.compareTo(current.getValue())>0) {
                    current = current.getRight();
                    smaller = false;
                }
                else if(value.compareTo(current.getValue()) == 0) break;
            }


        } else if(value.compareTo(root.getValue())>0) {

            TreeNode current = root;
            TreeNode prev = root;
            boolean smaller = false;

            while(true) {
                if(current == null) {
                    if(smaller) prev.setLeft(new TreeNode(value));
                    else prev.setRight(new TreeNode(value));
                    size++;
                    break;
                }
                prev = current;
                if(value.compareTo(current.getValue())<0) {
                    current = current.getLeft();
                    smaller = true;
                } else if(value.compareTo(current.getValue())>0) {
                    current = current.getRight();
                    smaller = false;
                }
                else if(value.compareTo(current.getValue()) == 0) break;
            }

        }

    }


    @Override
    @SuppressWarnings("Duplicates")
    public boolean contains(T value) {
        TreeNode current = root;
        boolean res = false;
        while(true) {
            if(current == null) break;
            else if(value.compareTo(current.getValue())<0) current = current.getLeft();
            else if(value.compareTo(current.getValue())>0) current = current.getRight();
            else if(value.compareTo(current.getValue())==0) {res = true; break;}
        }
        return res;
    }

    @Override
    @SuppressWarnings("Duplicates")
    public boolean remove(T value) {
        TreeNode previous = root;
        TreeNode current = root;
        boolean res = false, smaller = true;
//        System.out.println("Val before while:" + value);
        while(true) {
//            System.out.println("iterating");
            if(current == null) break;
            if(value.compareTo(current.getValue())==0) {
                if(previous.getValue() != current.getValue()) {
                    if(current.getLeft() == null && current.getRight() == null) {
                        if(smaller) previous.setLeft(null);
                        else previous.setRight(null);
                    } else if(current.getRight() == null && current.getLeft() != null) {
//                        System.out.println("Val:" + value);
//                        System.out.println("Prev:" + previous);
                        if(smaller) {
//                            System.out.println("Setting smaller" + current.getLeft());
                            previous.setLeft(current.getLeft());
                        }
                        else {
//                            System.out.println("Setting larger");
                            previous.setRight(current.getLeft());
                        }
                    } else if(current.getRight() != null && current.getLeft() == null) {
                        if(smaller) previous.setLeft(current.getRight());
                        else previous.setRight(current.getRight());
                    } else if(current.getRight() != null && current.getLeft() != null) {
//                        System.out.println("Val:" + value);
                        current.setValue(minVal(current));
                    }
                } else {
                    if(current.getLeft() == null && current.getRight() == null) root = null;
                    else if(current.getLeft() == null && current.getRight() != null) root = root.getRight();
                    else if(current.getLeft() != null && current.getRight() == null) root = root.getLeft();
                    else if(current.getRight() != null && current.getLeft() != null) current.setValue(minVal(current));
                }
                res = !res;
                size--;
                break;
            }
            previous = current;
            if(value.compareTo(current.getValue())<0) {
                current = current.getLeft();
                smaller = true;
            }
            else if(value.compareTo(current.getValue())>0) {
                current = current.getRight();
                smaller = false;
            }
        }
        return res;
    }

    @SuppressWarnings("Duplicates")
    private T minVal(TreeNode previous) {
//        System.out.println("Minval");
        TreeNode theNode = previous;
        TreeNode current = previous.getRight();
        T val =(T) current.getValue();
        while(current.getLeft() != null) {
            previous = current;
            current = current.getLeft();
            val = (T) current.getValue();
        }
        remove(val);
        theNode.setValue(val);
        return val;
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

