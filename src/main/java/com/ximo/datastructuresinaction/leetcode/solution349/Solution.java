package com.ximo.datastructuresinaction.leetcode.solution349;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xikl
 * @date 2018/12/28
 */
public class Solution {


    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        set1.retainAll(set2);


        return set1.stream().mapToInt(Integer::intValue).toArray();
    }



}
