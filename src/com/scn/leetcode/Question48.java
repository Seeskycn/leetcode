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
 * @Date: 2021/2/28 13:08
 * @Description:
 */
public class Question48 {

    public static void main(String[] args) {
        int[][] ints = {{1}};
        rotate(ints);
        for (int i = 0; i < ints.length; i++) {
            for (int num : ints[i]) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        if(matrix == null || matrix[0].length == 1){
            return;
        }
        int begin = 0;
        int end = matrix.length -1;
        while (begin<end){
            transfer(matrix,begin,end);
            begin++;
            end--;

        }

    }

    private static void transfer(int[][]matrix, int begin, int end) {
        int L = begin;
        int R = end;
        while (L < end){

            int temp = matrix[begin][L];
            matrix[begin][L] = matrix[R][begin];
            matrix[R][begin] = matrix[end][R];
            matrix[end][R] =  matrix[L][end];
            matrix[L][end] = temp;
            L++;
            R--;
        }

    }
}
