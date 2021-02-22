package com.scn.sort;

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
 * @Date: 2021/2/21 22:07
 * @Description:
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] ints = new int[]{1, 5, 3, 2, 6, 8};
        sort(ints);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    private static void sort(int[] ints) {
        if (ints == null || ints.length < 2) {
            return;
        }
        for (int i = 1; i < ints.length; i++) {
            for (int j = i -1; j > 0; j--) {
                if (ints[j]<ints[j+1]){
                    swap(ints,j,j+1);
                }else {
                    break;
                }
            }
        }
    }

    private static void swap(int[] ints, int i, int j) {
        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }
}
