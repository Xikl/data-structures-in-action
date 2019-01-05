package com.ximo.datastructuresinaction.map;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * @author xikl
 * @date 2019/1/5
 */
public class MapTest {


    @Test
    public void testGroupingBy() {
        Integer[] nums = {1, 1, 1, 2, 2, 3};
        Map<Integer, Long> collect = Arrays.stream(nums).collect(groupingBy(Function.identity(), counting()));
        System.out.println(collect);
    }
}
