package com.ximo.datastructuresinaction;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author Ximo
 * @date 2018/10/22 0:01
 */
public class ArrayTest {

    @Test
    public void testToString() {
        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr.toString());

        arr.add(1, 100);
        arr.addFirst(30);
        System.out.println(arr.toString());

//        arr.remove(0);
//        System.out.println(arr.toString());
    }

}