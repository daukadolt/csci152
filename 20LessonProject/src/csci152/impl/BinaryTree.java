package csci152.impl;

public class BinaryTree<T> {

    private TreeNode<T> root;

    public BinaryTree(TreeNode<T> root) {
        this.root = root;
    }

    public TreeNode<T> getRoot() {
        return this.root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    private String preOrder(TreeNode<T> node) {
        if(node == null) return "";
        String contents = "" + node.getValue() + "\n";
        if(node.getLeft() != null) contents += "/\n" + preOrder(node.getLeft());
        if(node.getRight() != null) contents += "\\ \n" + preOrder(node.getRight());
        return contents;
    }

    private String inOrder(TreeNode<T> node) {
        if(node == null) return "";
        String contents = "";
        if(node.getLeft() != null) contents += inOrder(node.getLeft());
        contents += node.getValue() + "\n";
        if(node.getRight() != null) contents += inOrder(node.getRight());
        return contents;
    }

    private String postOrder(TreeNode<T> node) {
        if(node == null) return "";
        String contents = "";
        if(node.getLeft() != null) contents += postOrder(node.getLeft());
        if(node.getRight() != null) contents += postOrder(node.getRight());
        contents += node.getValue() + "\n";
        return contents;
    }

    @Override
    public String toString() {
        return postOrder(root);
    }

}
