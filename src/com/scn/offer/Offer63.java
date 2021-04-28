package com.scn.offer;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-29
 */
public class Offer63 {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int length = prices.length;

        // dp[i][j] 标示 第 i天买入 第j天卖出
        int[] dp = new int[length];
        dp[0] = 0;

        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
        }

        return dp[length - 1];

    }
}
