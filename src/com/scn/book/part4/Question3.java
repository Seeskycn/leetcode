package com.scn.book.part4;

import javax.crypto.AEADBadTagException;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-16
 */
public class Question3 {

    public int minCoins1(int[] arr, int aim) {
        if (arr == null || aim <= 0 || arr.length == 0) {
            return 0;
        }

        return getResult(arr, 0, aim);
    }

    private int getResult(int[] arr, int index, int rest) {

        if (arr.length == index) {
            return rest == 0 ? 0 : -1;
        }

        int res = -1;
        for (int i = 0; i * arr[i] < rest; i++) {

            int next = getResult(arr, index + 1, rest - i*arr[index]);
            if (next != -1) {
                res = res == -1 ? next + i : Math.min(res, next + i);
            }
        }
        return res;
    }

    public int minCoins2(int[] arr, int aim) {
        int length = arr.length;
        if (arr == null || aim <= 0 || length == 0) {
            return 0;
        }

        int[][] dp = new int[length +1][aim+1];

        for (int i = 1; i <= aim; i++) {
            dp[length][i] = -1;
        }
        for (int i = length-1; i >= 0; i--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[i][rest] = -1;
                if(dp[i+1][rest] != -1){
                    dp[i][rest] = dp[i+1][rest];
                }
                if(rest-arr[i]>0 && dp[i][rest-arr[i]] != -1){
                    if(dp[i][rest] == -1){
                        dp[i][rest] = dp[i][rest- arr[i]] + 1;
                    }else {
                        dp[i][rest] = Math.min(dp[i][rest],dp[i][rest-arr[i]] + 1);
                    }
                }
            }
        }



        return dp[0][aim];

    }

}
