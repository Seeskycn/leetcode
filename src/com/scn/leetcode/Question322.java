package com.scn.leetcode;

import java.util.Arrays;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-02-25
 */
public class Question322 {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422}, 9864));
    }

    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int result = getResult(coins, amount, coins.length - 1);

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int getResult(int[] coins, int amount, int index) {

        if (amount == 0) {
            return 0;
        }
        if (index < 0) {
            return Integer.MAX_VALUE;
        }
        int count = amount / coins[index];
        if (amount % coins[index] == 0) {
            return count;
        }
        int res = Integer.MAX_VALUE;
        while (count == 0) {
            count = amount / coins[index--];
            if (index < 0) {
                return res;
            }
        }

        for (int i = count; i >= 0; i--) {
            int result = getResult(coins, amount - i * coins[index], (index - 1));
            if (result != Integer.MAX_VALUE) {
                return i + result;
            }
        }

        return res;

    }

}
