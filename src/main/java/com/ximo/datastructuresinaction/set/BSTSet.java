package com.ximo.datastructuresinaction.set;

import com.ximo.datastructuresinaction.bst.BinarySearchTree;

/**
 * 用树来实现链表
 * @author Ximo
 * @date 2018/11/12 21:31
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BinarySearchTree<E> binarySearchTree = new BinarySearchTree<>();

    @Override
    public void add(E e) {
        binarySearchTree.add(e);
    }

    @Override
    public void remove(E e) {
        binarySearchTree.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return binarySearchTree.contains(e);
    }

    @Override
    public int getSize() {
        return binarySearchTree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return binarySearchTree.isEmpty();
    }
}
