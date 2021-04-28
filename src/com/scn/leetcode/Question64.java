package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-04-12
 */
public class Question64 {
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1}}));
    }


    public static int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] dp = new int[row][column];
        dp[row - 1][column - 1] = grid[row - 1][column - 1];

        for (int i = row - 1; i >= 0; i--) {
            for (int j = column - 1; j >= 0; j--) {
                if(i == row-1 && j== column-1){
                    continue;
                }
                dp[i][j] = grid[i][j] + Math.min(i+1>=row ? Integer.MAX_VALUE:dp[i+1][j],j+1>=column?Integer.MAX_VALUE:dp[i][j+1]);
            }
        }
        return dp[0][0];

    }
}
