package com.ximo.datastructuresinaction.list;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Ximo
 * @date 2018/11/5 21:46
 */
public class DoubleLinkedListTest {

    @Test
    public void add() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        for (int i = 0; i < 3; i++) {
            list.add(i, i);
        }
        System.out.println(list);

        list.add(1, 100);
        System.out.println(list);
        list.addFirst(1000);
        list.addLast(90);
        System.out.println(list);
    }
}