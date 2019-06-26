package com.ximo.datastructuresinaction.leetcode.recursive;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Stream;

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
     * @param index    索引
     * @param strArray 原始数组
     */
    private static void printReverse(int index, char[] strArray) {
        if (strArray == null || index > strArray.length - 1) {
            return;
        }

        // 我们假设先执行后面的
        printReverse(index + 1, strArray);
        // 然后再执行自己
        System.out.print(strArray[index]);
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
//        char[] s = {'h', 'e'};
//        printReverse(s);
        printReverse2(s);
    }

    /**
     * StringJoiner的添加
     *
     * @param strArray
     */
    private static void printReverse2(char[] strArray) {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        reverse(0, strArray, stringJoiner);
        System.out.println(stringJoiner.toString());
    }

    private static void reverse(int index, char[] strArray, StringJoiner stringJoiner) {
        if (strArray == null || index > strArray.length - 1) {
            return;
        }

        reverse(index + 1, strArray, stringJoiner);
        stringJoiner.add("\"" + strArray[index] + "\"");
    }





    public void reverseString(char[] s) {

        for (int i = 0, j = s.length - 1; i < s.length / 2; ) {
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }


}
