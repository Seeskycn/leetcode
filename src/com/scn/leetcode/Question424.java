package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-04-28
 */
public class Question424 {
    public static void main(String[] args) {
        System.out.println(characterReplacement("AAABABBA", 1));
    }

    public static int characterReplacement(String s, int k) {
        int[] num = new int[26];
        int n = s.length();
        int maxn = 0;
        int left = 0, right = 0;
        while (right < n) {
            num[s.charAt(right) - 'A']++;
            maxn = Math.max(maxn, num[s.charAt(right) - 'A']);
            if (right - left + 1 - maxn > k) {
                num[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}
