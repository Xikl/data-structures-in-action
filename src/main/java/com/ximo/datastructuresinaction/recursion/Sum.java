package com.ximo.datastructuresinaction.recursion;

/**
 * @author Ximo
 * @date 2018/10/29 23:50
 */
public class Sum {

    private int sum(int[] arr) {
        return sum(arr, 0);
    }

    private static int sum(int[] arr, int l) {
        if (l == arr.length) {
            return 0;
        }
        return arr[l] + sum(arr, l + 1);
    }



}
