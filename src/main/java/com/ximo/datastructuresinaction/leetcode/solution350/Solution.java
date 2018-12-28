package com.ximo.datastructuresinaction.leetcode.solution350;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author xikl
 * @date 2018/12/28
 */
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums1) {
//            if (!map.containsKey(num)) {
//                map.put(num, 1);
//            } else {
//                map.put(num, map.get(num) + 1);
//            }

            map.compute(num, (key, value) -> value == null ? 1 : value + 1);
        }

        List<Integer> list = new LinkedList<>();
        for (int num : nums2) {
//            if (map.containsKey(num)) {
//                list.add(num);
//                map.put(num, map.get(num) - 1);
//                if (map.get(num) == 0) {
//                    map.remove(num);
//                }
//            }
            map.computeIfPresent(num, (key, value) -> {
                list.add(key);
                value = value - 1;
                if (value == 0) {
                    map.remove(key);
                }
                return value;
            });
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }


}
