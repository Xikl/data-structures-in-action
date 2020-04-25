package com.ximo.datastructuresinaction.algorithmsfourthedition.chapter01;

import java.util.Arrays;

/**
 * @author xikl
 * @date 2020/4/25
 */
public class BinarySearch {

    public static int binarySearchByRecursive(int[] array, int key) {
        if (array == null || array.length == 0) {
            return -1;
        }

        // 排序
        Arrays.sort(array);
        return binarySearchByRecursive(array, key, 0, array.length);
    }

    /**
     * 递归实现 二分搜索
     *
     * @param array
     * @param key
     * @param low
     * @param high
     * @return
     */
    public static int binarySearchByRecursive(int[] array, int key, int low, int high) {
        if (low > high) {
            return -1;
        }

        // 优化 为了看懂 high + ((low - high) >> 1);
        int mid = high + (low - high) / 2;

        // 卫语句
        if (key < array[mid]) {
            return binarySearchByRecursive(array, key, low, mid - 1);
        }

        if (key > array[mid]) {
            return binarySearchByRecursive(array, key, mid + 1, high);
        }

        // 那就是等于
        return mid;
    }


}
