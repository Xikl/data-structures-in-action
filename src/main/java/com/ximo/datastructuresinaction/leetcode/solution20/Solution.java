package com.ximo.datastructuresinaction.leetcode.solution20;


import java.util.HashMap;
import java.util.Stack;

/**
 * @author Ximo
 * @date 2018/10/23 21:33
 */
public class Solution {

    private static HashMap<Character, Character> mappings = new HashMap<>();

    static {
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
    }


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValidByMap(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 包含的时候
            if (mappings.containsKey(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (topChar != mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }



}
