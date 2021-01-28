package com.scn.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

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
 * @Date: 2021/1/25 22:02
 * @Description:
 */
public class Question54 {
    public static void main(String[] args) {
        int[][] ints = new int[5][5];
        int begin = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                ints[i][j] = begin;
                begin++;
            }
        }
        List<Integer> integers = spiralOrder(ints);
        System.out.println(integers);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int hen = matrix[0].length;
        int shu = 0;
        for (int[] arr : matrix) {
            shu++;
        }
        List<Integer> res = new ArrayList<>();
        spiralOrder(matrix,0,hen,0,shu, res);
        return res;
    }

    private static void spiralOrder(int[][] matrix, int henStart, int hen, int shuStart, int shu, List<Integer> res) {
        if(hen == 1){
            for (int i = shuStart; i < shu; i++) {
                res.add(matrix[i][shuStart]);

            }
            return;
        }
        if(shu == 1){
            for (int i = henStart; i < hen; i++) {
                res.add(matrix[henStart][i]);
            }
            return;
        }

        // 上
        for (int i = shuStart; i < hen; i++) {
            res.add(matrix[henStart][i]);
        }


        // 右
        for (int i = shuStart+1; i < shu; i++) {
            res.add(matrix[i][henStart+hen-1]);
        }

        // 下
        for (int i =  henStart+hen - 1; i >henStart+1; i--) {
            res.add(matrix[i][shuStart+shu-1]);
        }
        // 左

        for (int i = shuStart+shu - 1-1; i >shuStart+1 ; i--) {
            res.add(matrix[henStart][i]);
        }
        spiralOrder(matrix,henStart+1,hen-2,shuStart+1,shu-2,res);
    }


}
