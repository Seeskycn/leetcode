package com.scn.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-07-07
 */
public class Question6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int num = sc.nextInt();

        System.out.println(print2(line, num));
    }

    private static String print2(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    private static String print(String s, int numRows) {
        int size = s.length();
        String[][] str = new String[numRows][size];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < size; j++) {
                str[i][j] = " ";
            }
        }
        int count1 = 0;
        int count2 = 0;
        boolean turn = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            str[count1][count2] = String.valueOf(c);
            if (turn) {
                count1--;
                count2++;
                if (count1 < 0) {
                    count2--;
                    count1++;
                    count1++;
                    turn = false;
                }
            } else {
                count1++;
                if (count1 == numRows) {
                    count1--;
                    count1--;
                    count2++;
                    turn = true;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sj = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(str[i][j]);
            }
            sj.append(sb.toString().trim() + "\r\n");
            sb = new StringBuilder();
        }
        return sj.toString();
    }
}
