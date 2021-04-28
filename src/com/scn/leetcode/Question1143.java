package com.scn.leetcode;

import com.scn.sort.SortUtils;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-10
 */
public class Question1143 {

    public static void main(String[] args) {

        System.out.println(longestCommonSubsequence("abc","abc"));

    }
    public static int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text1 == "" ||text1.length() == 0 || text2 == null || text2 == "" ||text2.length() == 0){
            return 0;
        }

        int[][] dp = getDp(text1, text2);
        return dp[text1.length()-1][text2.length()-1];
    }
    public static int[][] getDp(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];

        boolean flag = false;
        for (int i = 0; i < text1.length(); i++) {
            if(text2.charAt(0) == text1.charAt(i)){
                flag = true;
            }
            if(flag){
                dp[i][0] = 1;
            }
        }

        flag = false;
        for (int i = 0; i < text2.length(); i++) {
            if(text1.charAt(0) == text2.charAt(i)){
                flag = true;
            }
            if(flag){
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = Math.max(dp[i][j],dp[i-1][j-1]+1);
                }
            }
        }


        return dp;
    }
}
