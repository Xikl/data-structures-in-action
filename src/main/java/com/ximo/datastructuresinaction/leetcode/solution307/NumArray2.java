package com.ximo.datastructuresinaction.leetcode.solution307;

import com.ximo.datastructuresinaction.segmenttree.SegmentTree;

import java.util.Arrays;

/**
 * @author xikl
 * @date 2019/1/19
 */
public class NumArray2 {

    private SegmentTree<Integer> segmentTree;


    public NumArray2(int[] nums) {
        Integer[] newNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        segmentTree = new SegmentTree<>(newNums, (prev, next) -> prev + next);

    }

    public int sumRange(int i, int j) {
        return segmentTree.queryRangeClose(i, j);
    }


    /**
     * 更新其中的一个值
     *
     * @param i 需要被更新的位置
     * @param val 新的值
     */
    public void update(int i, int val) {
        segmentTree.set(i, val);
    }



}
