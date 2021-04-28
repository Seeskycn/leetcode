package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-04-13
 */
public class Question96 {

    public static void main(String[] args) {
        System.out.println(numTrees(5));
    }
    public static int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
