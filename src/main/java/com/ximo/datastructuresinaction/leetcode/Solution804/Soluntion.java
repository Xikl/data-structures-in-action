package com.ximo.datastructuresinaction.leetcode.Solution804;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * https://leetcode-cn.com/problems/unique-morse-code-words/description/
 * @author Ximo
 * @date 2018/11/14 22:54
 */
public class Soluntion {

    private static final String[] CODES = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};


    /**
     * 求给定的数组中的每个字符串的对应的摩斯密码
     * 并且返回不同的密码的个数
     *
     * @param words 不同字符串组成的数组
     * @return 不同的密码的个数
     */
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new TreeSet<>();
        for (String word : words) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                String code = CODES[word.charAt(i) - 'a'];
                res.append(code);
            }
            set.add(res.toString());
        }
        return set.size();
    }

}
