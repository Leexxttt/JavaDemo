package com.lxt.tree;


public class BinaryTree {
    /**
     * 左节点
     */
    public BinaryTree left;
    /**
     * 右节点
     */
    public BinaryTree right;
    /**
     * 内容
     */
    public String data;

    public BinaryTree getLeft() {
        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public BinaryTree() {
    }

    public BinaryTree(String data, BinaryTree left, BinaryTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinaryTree(String data) {
        this(data, null, null);
    }

    public void insertLeft(BinaryTree node, String value) {
        if (node != null) {
            if (node.getLeft() == null) {
                node.setLeft(new BinaryTree(value));
            }else{
                BinaryTree newNode = new BinaryTree(value);
                newNode.setLeft(node.getLeft());
                node.setLeft(newNode);
            }
        }
    }
    public void insertRight(BinaryTree node, String value) {
        if (node != null) {
            if (node.getRight() == null) {
                node.setRight(new BinaryTree(value));
            }else{
                BinaryTree newNode = new BinaryTree(value);
                newNode.setRight(node.getLeft());
                node.setRight(newNode);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree nodeA = new BinaryTree("a");
        nodeA.insertRight(nodeA,"c");
        nodeA.insertLeft(nodeA,"b");
        //获取nodeB
        BinaryTree nodeB = nodeA.getLeft();
        nodeB.insertRight(nodeB,"d");
        //获取nodeC
        BinaryTree nodeC = nodeA.getRight();
        nodeC.insertLeft(nodeC,"e");
        nodeC.insertRight(nodeC,"f");

        BinaryTree nodeD = nodeB.getRight();
        BinaryTree nodeE = nodeC.getLeft();
        BinaryTree nodeF = nodeC.getRight();


        System.out.println("a:" + nodeA.getData());
        System.out.println("b:" + nodeB.getData());
        System.out.println("c:" + nodeC.getData());
        System.out.println("d:" + nodeD.getData());
        System.out.println("e:" + nodeE.getData());
        System.out.println("f:" + nodeF.getData());
        //前序遍历
        System.out.println("=============================================");
        BinaryTreeOrder.preOrder(nodeA);
        //中序遍历
        System.out.println("=============================================");
        BinaryTreeOrder.inOrder(nodeA);
        //后序遍历
        System.out.println("=============================================");
        BinaryTreeOrder.postOrder(nodeA);
        //广度优先搜索
        System.out.println("=============================================");
        BinaryTreeOrder.bfsOrder(nodeA);
    }
}
