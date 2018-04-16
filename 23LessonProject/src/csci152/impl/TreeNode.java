package csci152.impl;

public class TreeNode<T> {

    private T value;

    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T val) {
        value = val;
        left = null;
        right = null;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T val) {
        this.value = val;
    }

    public TreeNode<T> getLeft() {
        return this.left;
    }

    public TreeNode<T> getRight() {
        return this.right;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
