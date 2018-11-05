package com.ximo.datastructuresinaction.bst;

/**
 * 二分搜索树
 *
 * @author Ximo
 * @date 2018/11/5 23:23
 */
public class BinarySearchTree<E extends Comparable<E>> {

    /** 根节点的信息 */
    private Node root;

    /** 树的大小 */
    private int size;

    public BinarySearchTree() {
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E element) {
        if (root == null) {
            root = new Node(element);
            size++;
        }
        add(root, element);
    }

    private void add(Node node, E element) {
        // 递归调用终止条件
        int compareResult = element.compareTo(node.e);
        if (compareResult < 0) {
            if (node.left == null) {
                node.left = new Node(element);
                size++;
            } else {
                add(node.left, element);
            }
        } else if (compareResult > 0){
            // 大于零的时候
            if (node.right == null) {
                node.right = new Node(element);
                size++;
            } else {
                add(node.right, element);
            }
        }
    }

    private class Node {
        private E e;

        private Node left;

        private Node right;

        public Node(E e) {
            this.e = e;
        }
    }







}
