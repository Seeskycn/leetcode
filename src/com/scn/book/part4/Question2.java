package com.scn.book.part4;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-16
 */
public class Question2 {


    public static int getResult(int[][] arr){
        if (arr == null || arr.length == 0 || arr[0] == null || arr[0].length == 0) {
            return 0 ;
        }
        int row = arr.length;
        int col = arr[0].length;

        int[][] dp = new int[row][col];
        dp[0][0] = arr[0][0];

        for (int i = 1; i < col; i++) {
            dp[0][i] = arr[0][i]+dp[0][i-1];
        }
        for (int i = 1; i < row; i++) {
            dp[i][0] = arr[i][0]+dp[i-1][0];
        }

        for (int i = 1; i < col; i++) {
            for (int j = 1; j < row; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[row-1][col-1];

    }
}
