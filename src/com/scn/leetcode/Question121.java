package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-18
 */
public class Question121 {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }

    public static int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(prices[i]-minPrice,max);
            minPrice = Math.min(minPrice,prices[i]);

        }
        return max;
    }
}
