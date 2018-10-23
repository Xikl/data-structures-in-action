package com.ximo.datastructuresinaction.leetcode.solution20;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Ximo
 * @date 2018/10/23 21:44
 */
public class SolutionTest {

    @Test
    public void isValid() {
        String s = "(]";
        Solution solution = new Solution();
        boolean valid = solution.isValid(s);
        System.out.println(valid);
    }
}