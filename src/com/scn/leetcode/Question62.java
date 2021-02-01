package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-01-27
 */
public class Question62 {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(i == 1&& j == 1){
                    continue;
                }
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m][n];
    }

}
