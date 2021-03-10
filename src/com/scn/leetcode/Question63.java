package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-10
 */
public class Question63 {

    public static void main(String[] args) {
        int[][] ints = {{0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,1,1,0,0,1,0,1,1,0,1,0,0,1,0,0,0,1,0,0},{0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,1,0,1,0,1,0,0,1,0,0,0},{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,1,0,0,0,1,0,0,0,0,0,0,1,0,0,1,0,1},{0,0,0,1,0,0,0,0,0,0,0,1,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,1,0,0,0,1,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,1,0,0,1,0,0},{0,0,0,0,0,0,1,0,0,0,1,1,0,1,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0},{1,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,1,1,0,0,0,1},{0,0,0,0,1,0,0,1,0,1,1,1,0,0,0,1,0,0,1,0,1,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0},{0,0,0,1,0,0,0,0,0,0,0,0,0,1,1,1,0,1,0,0,1,1,0,0,0,0,0,0,0,0,0,1,1,0,0,0},{1,0,1,0,1,1,0,1,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,1,1,1,0,0,0,0,1,0,0,0,1,0},{0,0,0,0,0,0,1,0,0,1,1,0,0,1,0,0,0,0,1,0,0,1,1,0,0,0,0,0,1,0,0,1,0,0,0,1},{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,1,0,0,1,0,0,0},{1,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},{0,1,0,0,1,0,0,0,0,0,1,0,1,1,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0},{0,0,0,0,1,0,0,0,1,0,0,0,0,1,0,0,1,1,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0,1,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0},{0,0,1,0,1,0,1,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0},{0,0,0,1,0,1,0,0,1,0,0,0,0,0,1,1,1,0,1,1,1,0,0,1,0,1,0,1,1,1,0,0,0,0,0,0},{0,0,1,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},{1,1,0,0,0,0,1,0,0,1,1,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},{0,1,0,0,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,1,0,0},{0,0,0,0,1,0,0,1,0,0,0,0,0,0,1,0,0,1,0,1,1,1,0,0,0,0,0,0,1,0,0,0,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0}};
        System.out.println(uniquePathsWithObstacles2(ints));
    }

    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int high = obstacleGrid.length;
        int length = obstacleGrid[0].length;
        long[][] dp = new long[high][length];

        if(obstacleGrid[high-1][length-1] == 1){
            return 0;
        }else {
            dp[high-1][length-1] = 1;
        }
        for (int i = high-2; i >=0; i--) {
            if (obstacleGrid[i][length-1] == 1) {
                dp[i][length-1] = 0;
            }else {
                dp[i][length-1] = dp[i+1][length-1];
            }
        }

        for (int i = length-2; i >=0; i--) {
            if (obstacleGrid[high-1][i] == 1) {
                dp[high-1][i] = 0;
            }else {
                dp[high-1][i] = dp[high-1][i+1];
            }
        }

        for (int i = high-2; i >=0; i--) {
            for (int j = length-2; j >=0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i+1][j]+dp[i][j+1];
                }
            }
        }



        return (int)dp[0][0];
    }



    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        return getResult(obstacleGrid,0,0);
    }

    private static int getResult(int[][] obstacleGrid, int i, int j) {
        if(obstacleGrid[i][j] == 1){
            return 0;
        }
        if(i == obstacleGrid.length-1 && j == obstacleGrid[0].length-1 ){

            return obstacleGrid[i][j] == 0 ? 1 : 0;
        }
        if(i == obstacleGrid.length-1){
            if (obstacleGrid[i][j+1]==1) {
                return 0;
            }else {
                return getResult(obstacleGrid,i,j+1);
            }
        }

        if(j == obstacleGrid[0].length-1){
            if (obstacleGrid[i+1][j] == 1) {
                return 0;
            }else {
                return getResult(obstacleGrid,i+1,j);
            }
        }

        if(obstacleGrid[i+1][j] == 1&& obstacleGrid[i][j+1]==1){
           return 0;
        }else if(obstacleGrid[i+1][j] == 1 && obstacleGrid[i][j+1]==0){
            return getResult(obstacleGrid,i,j+1);
        }else if(obstacleGrid[i+1][j] == 0&& obstacleGrid[i][j+1]==1){
            return getResult(obstacleGrid,i+1,j);
        }else{
            return getResult(obstacleGrid,i,j+1) + getResult(obstacleGrid,i+1,j);
        }
    }
}
