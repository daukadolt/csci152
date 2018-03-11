package csci152.adt_tests;

import csci152.impl.BinaryTree;
import csci152.impl.TreeNode;

public class TreeNodeTest {

    public static void main(String[] args) {

    BinaryTree<Integer> test = new BinaryTree<Integer>(new TreeNode<Integer>(12));

    // Setting left subtree
        test.getRoot().setLeft(new TreeNode<Integer>(25));
        test.getRoot().getLeft().setLeft(new TreeNode<Integer>(85));

    // Setting right subtree
        test.getRoot().setRight(new TreeNode<Integer>(17));
        test.getRoot().getRight().setLeft(new TreeNode<Integer>(-46));
        test.getRoot().getRight().setRight(new TreeNode<Integer>(15));

        print(test);

    }

    public static void print(Object o) {
        System.out.println(o);
    }

}
