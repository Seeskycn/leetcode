package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-04-28
 */
public class Question419 {

    public static int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X' && (i - 1 >= 0 ? board[i - 1][j] != 'X' : true )&& (j - 1 >= 0 ? board[i][j - 1] != 'X' : true)) {
                    count++;
                }
            }
        }
        return count;
    }
}
