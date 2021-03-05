package com.scn.offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-04
 */
public class Offer48 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcdbbbbwfghjkm"));
    }

    public static int lengthOfLongestSubstring(String s) {

        if(s == null || s.length() <=1){
            return s.length();
        }
        int max = 0;
        int begin = 0;
        int end = 0;
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        while (end <chars.length){
            if (set.contains(chars[end])) {
                max = Math.max(max,end-begin);
                while (begin<end){
                    set.remove(chars[begin]);
                    if(chars[begin] !=chars[end]){
                        begin++;
                    }else {
                        begin++;
                        break;
                    }
                }
            }else {
                set.add(chars[end]);
                end++;
            }
        }
        max = Math.max(max,end-begin);
        return max;
    }
}
