package com.scn.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-30
 */
public class Question395 {

    public static void main(String[] args) {
        System.out.println(longestSubstring("abcabcda", 3));
    }
    public static int longestSubstring(String s, int k) {
        if (s == null  || s.length() < k ) {
            return 0;
        }
        if(k == 0 || k == 1){
            return s.length();
        }
        return getMaxLength(s.toCharArray(),0,s.length(),k);

    }

    private static int getMaxLength(char[] chars, int begin, int end, int k) {
        if(end -begin < k){
            return 0;
        }
        Map<Character,Integer> map = new HashMap();
        for (int i = begin; i < end; i++) {
            map.put(chars[i],map.get(chars[i]) == null ? 1 : map.get(chars[i])+1);
        }
        int size1 = map.size();
        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            if (iterator.next().getValue()<k) {
                iterator.remove();
            }
        }

        if(size1 == map.size()){
            return end-begin;
        }
        int left = 0;
        int right = 0;

        int maxLength = 0;

        for (; right < chars.length; right++) {
            if(!map.containsKey(chars[right])){
                maxLength = Math.max(maxLength,getMaxLength(chars,left,right,k));
                left = right + 1;
            }
        }


        return Math.max(maxLength,getMaxLength(chars,left,right,k));
    }
}
