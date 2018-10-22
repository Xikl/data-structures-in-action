package com.ximo.datastructuresinaction.array;

import com.ximo.datastructuresinaction.array.Array;
import org.junit.Test;

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