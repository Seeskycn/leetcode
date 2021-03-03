package com.scn.leetcode;

/*
 *-----------------神兽保佑 -----------------
 *           ┌─┐        ┌─┐
 *       ┌─┘  ┴────┘  ┴─┐
 *       │                        │
 *       │        ───          │
 *       │  ─┬┘       └┬─   │
 *       │                        │
 *       │       ─┴─           │
 *       │                        │
 *       └───┐          ┌──┘
 *               │          │
 *               │          │
 *               │          │
 *               │          └────────────┐
 *               │                                    │
 *               │                                    ├─┐
 *               │                                    ┌─┘
 *               │                                    │
 *               └─┐  ┐  ┌─────┬─┐  ┌──┘
 *                   │  ┤  ┤          │  ┤  ┤
 *                   └─┴─┘          └─┴─┘
 *
 * ------------------代码无BUG!--------------
 * @Author: Seesky
 * @Date: 2021/3/3 21:13
 * @Description:
 */
public class Question200 {

    public static void main(String[] args) {
        char[][] arr =  {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        }
                ;
        System.out.println(numIslands(arr));
    }

    public static int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int count = 0;
        int high = grid.length;
        int len = grid[0].length;
        for (int i = 0; i < high; i++) {
            for (int j = 0; j < len; j++) {
                if (grid[i][j] == '1') {

                    G(high, len, i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 从当前节点开始所有能遇到的值为1的节点都感染为2
     *
     * @param high
     * @param len
     * @param i
     * @param j
     * @param grid
     */
    private static void G(int high, int len, int i, int j, char[][] grid) {
        if (i < 0 || i >=high || j >=len || j < 0 || grid[i][j] != '1' ) {
            return;
        }
        grid[i][j] = '2';
        // 上
        G(high, len, i - 1, j, grid);
        // 下
        G(high, len, i + 1, j, grid);
        // 左
        G(high, len, i, j - 1, grid);
        // 右
        G(high, len, i, j + 1, grid);


    }
}
