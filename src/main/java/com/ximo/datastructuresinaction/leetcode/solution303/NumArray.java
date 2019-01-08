package com.ximo.datastructuresinaction.leetcode.solution303;

/**
 * @author xikl
 * @date 2019/1/8
 */
public class NumArray {

    /**
     * sum[0] = 0
     * sum[i] 等于 前i个元素的和
     */
    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        sum[0] = 0;

        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }


}
