package com.ximo.datastructuresinaction.list;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Ximo
 * @date 2018/10/28 15:07
 */
public class LinkListTest {

    @Test
    public void testAdd() {
        LinkList<Integer> list = new LinkList<>();

        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        System.out.println(list);

        list.add(2, 77);
        System.out.println(list);
    }
}