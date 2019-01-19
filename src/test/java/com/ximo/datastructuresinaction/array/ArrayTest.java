package com.ximo.datastructuresinaction.array;

import org.junit.Test;

import java.util.Arrays;

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

    @Test
    public void testArrToMyArray() {
        Integer[] arr = {1, 2, 3};
        Array<Integer> array = new Array<>(arr);
        System.out.println(array);
    }


    @Test
    public void testIntToInteger() {
        int[] intArray = {1, 2, 3, 4};

        Integer[] integerArrays = Arrays.stream(intArray).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(integerArrays));

    }
}