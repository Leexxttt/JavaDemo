package com.lxt.tree;

/**
 * 二叉搜索树
 */
public class BinaryTreeSearch {
    /**
     * 二叉搜索树 节点插入
     * @param node
     * @param value
     */
    public static void insertNode(BinaryTree node, Integer value) {
        if (node != null) {
            String data = node.getData();
            if (value < Integer.valueOf(data) && node.getLeft() != null) {
                insertNode(node.getLeft(), value);
            } else if (value < Integer.valueOf(data)) {
                node.setLeft(new BinaryTree(String.valueOf(value)));
            } else if (value > Integer.valueOf(data) && node.getRight() != null) {
                insertNode(node.getRight(), value);
            } else if (value > Integer.valueOf(data)) {
                node.setRight(new BinaryTree(String.valueOf(value)));
            }
        }
    }

    /**
     * 搜索节点
     * @param node
     * @param value
     * @return
     */
    public static boolean findNode(BinaryTree node, Integer value){
        if(node!=null){
            if(value<Integer.valueOf(node.getData())&&node.getLeft()!=null){
                return findNode(node.getLeft(),value);
            }
            if(value>Integer.valueOf(node.getData())&&node.getRight()!=null){
                return findNode(node.getRight(),value);
            }
            return value==Integer.valueOf(node.getData());
        }
        return false;
    }


    public static boolean removeNode(BinaryTree node,Integer value,BinaryTree parentNode){
        if(value<Integer.valueOf(node.getData())&&node.getLeft()!=null){
            return removeNode(node.getLeft(),value,node);
        }else if(value<Integer.valueOf(node.getData())){
            return false;
        }else if(value>Integer.valueOf(node.getData())&&node.getRight()!=null){
            return removeNode(node.getRight(),value,node);
        }else if(value>Integer.valueOf(node.getData())){
            return false;
        }else{
            //TODO ........
        }

        return false;
    }
    public void clearNode(BinaryTree node){
        node.setLeft(null);
        node.setRight(null);
        node.setData(null);
    }

    public static void main(String[] args) {
        //现在想像一下我们有一棵空树，我们想将几个节点添加到这棵空树中，这几个结点的值为：50、76、21、4、32、100、64、52
        BinaryTree node = new BinaryTree("50");
        insertNode(node,76);
        insertNode(node,21);
        insertNode(node,4);
        insertNode(node,32);
        insertNode(node,100);
        insertNode(node,64);
        insertNode(node,52);
        //前序遍历一下
        BinaryTreeOrder.preOrder(node);
        System.out.println("=================================");

        System.out.println(findNode(node,4));

    }
}
