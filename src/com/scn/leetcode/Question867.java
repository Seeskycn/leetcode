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
 * @Date: 2021/2/25 22:40
 * @Description:
 */
public class Question867 {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6}};
        transpose(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int arr : matrix[i]) {
                System.out.print(arr);
            }
            System.out.println();
        }
    }

    public static int[][] transpose(int[][] matrix) {
        int ai = 0;
        int aj = 0;
        int bi = 0;
        int bj = 0;
        while (true){

            tran(matrix,ai,aj,bi,bj);
            aj =  ai == matrix[0].length -1 ? aj+1:aj;
            ai = ai == matrix[0].length -1 ? ai:ai+1;


            bi = bj == matrix.length-1 ? bi+1:bi;
            bj = bj == matrix.length-1 ? bj:bj+1;

            if(aj == matrix.length){
                break;
            }

        }
        return matrix;

    }

    private static void tran(int[][] matrix, int ai, int aj, int bi, int bj) {
        while (bi<ai){
            int temp = matrix[aj][ai];
            matrix[aj][ai] = matrix[bj][bi];
            matrix[bj][bi]=temp;
            ai--;
            aj++;
            bi++;
            bj--;

        }
    }
}
