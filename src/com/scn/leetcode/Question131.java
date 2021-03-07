package com.scn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-05
 */
public class Question131 {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtracking(s.toCharArray(),res,sb,0);
        return res;
    }

    private void backtracking(char[] chars, List<List<String>> res, StringBuilder sb, int begin) {
        if(begin == chars.length){
            return;
        }

        for (int i = begin; i < chars.length; i++) {
            sb.append(chars[begin]);

        }

    }
}
