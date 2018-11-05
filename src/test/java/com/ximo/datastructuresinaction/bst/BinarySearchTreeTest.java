package com.ximo.datastructuresinaction.bst;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Ximo
 * @date 2018/11/6 0:29
 */
public class BinarySearchTreeTest {

    @Test
    public void add() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(2);
        bst.add(1);
        bst.add(0);
        bst.add(4);
        bst.add(3);
        System.out.println(bst);
    }
}