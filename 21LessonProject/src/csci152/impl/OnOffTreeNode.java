package csci152.impl;

public class OnOffTreeNode<T> {

    private T value;

    private OnOffTreeNode<T> left;
    private OnOffTreeNode<T> right;

    private boolean active;

    public OnOffTreeNode(T val) {
        value = val;
        left = null;
        right = null;
        active = true;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T val) {
        this.value = val;
    }

    public OnOffTreeNode<T> getLeft() {
        return this.left;
    }

    public OnOffTreeNode<T> getRight() {
        return this.right;
    }

    public void setLeft(OnOffTreeNode<T> left) {
        this.left = left;
    }

    public void setRight(OnOffTreeNode<T> right) {
        this.right = right;
    }

    public void activate() {
//        System.out.println("Node w/ val="+this.value + " activated");
        this.active = true;
    }

    public void deactivate() {
//        System.out.println("Node w/ val="+this.value + " deactivated");
        this.active = false;
    }

    public boolean isActive() {
        return this.active;
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
