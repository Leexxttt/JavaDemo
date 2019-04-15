package com.lxt.tree;

public class BinaryTreeOrder {

    /**
     * 前序遍历
     */
    public static void preOrder(BinaryTree node) {
        if (node != null) {
            System.out.println(node.getData());
            if (node.getLeft() != null) {
                preOrder(node.getLeft());
            }
            if (node.getRight() != null) {
                preOrder(node.getRight());
            }
        }
    }

    /**
     * 中序遍历
     */
    public static void inOrder(BinaryTree node) {
        if (node != null) {
            if (node.getLeft() != null) {
                inOrder(node.getLeft());
            }
            System.out.println(node.getData());
            if (node.getRight() != null) {
                inOrder(node.getRight());
            }
        }
    }

    /**
     * 后序遍历
     */
    public static void postOrder(BinaryTree node) {
        if (node != null) {
            if (node.getLeft() != null) {
                postOrder(node.getLeft());
            }
            if (node.getRight() != null) {
                postOrder(node.getRight());
            }
            System.out.println(node.getData());
        }
    }

}
