package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-22
 */
public class Offer47 {

    public static void main(String[] args) {
        System.out.println(maxValue(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

    public static int maxValue(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = Math.max(i - 1 < 0 ? 0 : dp[i - 1][j], j - 1 < 0 ? 0 : dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[row-1][col-1];

    }

}
