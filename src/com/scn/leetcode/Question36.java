package com.scn.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-01-14
 */
public class Question36 {

    public boolean isValidSudoku(char[][] board) {
        if(!checkHen(board)){
            return false;
        }
        if(!checkShu(board)){
            return false;
        }
        if(!checkNine(board)){
            return false;
        }
        return true;
    }

    private boolean checkNine(char[][] board) {
        return true;
    }

    private boolean checkShu(char[][] board) {
        char[] chars = new char[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                chars[j] = board[i][j];
            }
            if(!checkRepeat(chars)){
                return false;
            }
        }
        return true;
    }

    private boolean checkHen(char[][] board) {
        for (int i = 0; i < 9; i++) {
            char[] chars = board[i];
            if(!checkRepeat(chars)){
                return false;
            }
        }
        return true;
    }

    private boolean checkRepeat(char[] chars) {
        Set<Character> cSet = new HashSet<>();
        for (char c : chars) {
            if(cSet.contains(c)){
                return false;
            }
        }
        return true;
    }

}
