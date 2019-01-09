package com.ximo.datastructuresinaction.leetcode.solution307;

import java.util.Arrays;

/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
 *
 * 示例:
 *
 * Given nums = [1, 3, 5]
 *
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * 说明:
 *
 * 数组仅可以在 update 函数下进行修改。
 * 你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。
 *
 * @author xikl
 * @date 2019/1/9
 */
public class NumArray {


    /**
     * sum[0] = 0
     * sum[i] 等于 前i个元素的和
     */
    private int[] sum;

    /** 保存我们的数据 */
    private int[] data;

    public NumArray(int[] nums) {
        data = Arrays.copyOf(nums, nums.length);

        sum = new int[nums.length + 1];
        sum[0] = 0;

        sumStartFromIndex(sum, nums, 1);
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

    /**
     * 更新其中的一个值
     *
     * @param i 需要被更新的位置
     * @param val 新的值
     */
    public void update(int i, int val) {
        data[i] = val;
        // 累加
        sumStartFromIndex(sum, data, i + 1);
    }

    private void sumStartFromIndex(int[] sumArr, int[] dataArr, int startIndex) {
        for (int i = startIndex; i < sumArr.length; i++) {
            sumArr[i] = sumArr[i - 1] + dataArr[i - 1];
        }
    }

}
