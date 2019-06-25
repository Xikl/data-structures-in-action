package com.ximo.datastructuresinaction.leetcode.recursive;

/**
 * @author xikl
 * @date 2019/6/26
 */
public class PrintReverse {

    public static void printReverse(char[] strArray) {
        printReverse(0, strArray);
    }

    /**
     * 递归调用
     *
     * @param index 索引
     * @param strArray 原始数组
     */
    private static void printReverse(int index, char[] strArray) {
        if (strArray == null || index > strArray.length) {
            return;
        }

        // 我们假设先执行后面的
        printReverse(index + 1, strArray);
        // 然后再执行自己
        System.out.println(strArray[index]);
    }


}
