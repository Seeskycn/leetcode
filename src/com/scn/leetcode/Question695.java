package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-05-17
 */
public class Question695 {

    public static void main(String[] args) {
        System.out.println(maxAreaOfIsland(new int[][]{{0, 1}, {1, 1}}));
    }

    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 2;
                    maxArea = Math.max(maxArea, getMaxArea(grid, i, j) + 1);
                }
            }
        }
        return maxArea;
    }

    private static int getMaxArea(int[][] grid, int i, int j) {
        int area = 0;
        // 上
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            grid[i - 1][j] = 2;
            area += (getMaxArea(grid, i - 1, j) + 1);
        }
        // 下
        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
            grid[i + 1][j] = 2;
            area += (getMaxArea(grid, i + 1, j) + 1);
        }

        // 左
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            grid[i][j - 1] = 2;
            area += (getMaxArea(grid, i, j - 1) + 1);
        }
        // 右
        if (j + 1 < grid[i].length && grid[i][j + 1] == 1) {
            grid[i][j + 1] = 2;
            area += (getMaxArea(grid, i, j + 1) + 1);
        }

        return area;
    }
}
