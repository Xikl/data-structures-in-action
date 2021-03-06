package com.ximo.datastructuresinaction.leetcode.solution303;

import com.ximo.datastructuresinaction.segmenttree.SegmentTree;

import java.util.Arrays;

/**
 * @author xikl
 * @date 2019/1/8
 */
public class NumArray2 {


    private SegmentTree<Integer> segmentTree;

    public NumArray2(int[] nums) {
        Integer[] newNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        segmentTree = new SegmentTree<>(newNums, (next, prev) -> next + prev);
    }

    public int sumRange(int i, int j) {
        return segmentTree.queryRangeClose(i, j);
    }


}
