package com.scn.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-04-30
 */
public class Question474 {

    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"11","11","0","0","10","1","1","0","11","1","0","111","11111000","0","11","000","1","1","0","00","1","101","001","000","0","00","0011","0","10000"}, 90, 66));
    }


    public static int findMaxForm(String[] strs, int m, int n) {
        Map<String,Integer> cacheMap = new HashMap<>();
        return backTrack(strs, m, n, 0,cacheMap);
    }

    private static int backTrack(String[] strs, int m, int n, int index, Map<String, Integer> cacheMap) {

        int max = 0;

        for (int i = index; i < strs.length; i++) {
            String str = strs[i];
            int countOne = 0;
            for (char c : str.toCharArray()) {
                if (c == '1') {
                    countOne++;
                }
            }
            int countZero = str.length() - countOne;
            if (m - countZero >= 0 && n - countOne >= 0) {
                String key = (m - countZero) + "_" + (n - countOne) + "_" + (i + 1);
                if (cacheMap.get(key) == null) {
                    cacheMap.put(key,backTrack(strs, m - countZero, n - countOne, i + 1, cacheMap) + 1);
                }
                max = Math.max(cacheMap.get(key), max);
            }

        }

        return max;
    }
}
