package com.ximo.datastructuresinaction.bst;

/**
 * @author Ximo
 * @date 2018/11/5 23:23
 */
public class BinarySearchTree<E extends Comparable<E>> {

    private Node root;

    private int size;

    public BinarySearchTree() {
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
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
