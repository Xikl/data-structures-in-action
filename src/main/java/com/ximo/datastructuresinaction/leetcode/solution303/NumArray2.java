package com.ximo.datastructuresinaction.leetcode.solution303;

import com.ximo.datastructuresinaction.segmenttree.SegmentTree;

/**
 * @author xikl
 * @date 2019/1/8
 */
public class NumArray2 {


    private SegmentTree<Integer> segmentTree;

    public NumArray2(int[] nums) {
        Integer[] newNums = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i];
        }

        segmentTree = new SegmentTree<>(newNums, (next, prev) -> next + prev);
    }

    public int sumRange(int i, int j) {
        return segmentTree.queryRangeClose(i, j);
    }


}
