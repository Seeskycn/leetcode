package com.scn.datastructure.array;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-11
 */
public class Question130 {

    public void solve(char[][] board) {

        int H = board.length;
        int R = board[0].length;
        // 上边
        for (int i = 0; i < R; i++) {
            if(board[0][i] == 'O'){
                G(board,0,i);
            }
        }

        // 下边
        for (int i = 0; i < R; i++) {
            if(board[H-1][i] == 'O'){
                G(board,H-1,i);
            }
        }

        // 左边
        for (int i = 0; i < H; i++) {
            if(board[i][0] == 'O'){
                G(board,i,0);
            }
        }

        // 右边
        for (int i = 0; i < H; i++) {
            if(board[i][R-1] == 'O'){
                G(board,i,R-1);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'B'){
                    board[i][j] = 'O';
                }
            }
        }


    }
    public void G(char[][] board,int H, int R){
        if(H <0 || H>board.length-1 || R < 0 || R > board[0].length -1 || board[H][R] != 'O'){
            return;
        }

        board[H][R] = 'B';

        // 下
        G(board,H,R+1);
        // 上
        G(board,H,R-1);
        // 左
        G(board,H-1,R);
        // 右
        G(board,H+1,R);


    }
}
