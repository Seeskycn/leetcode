package com.scn.sort;

import javax.swing.text.EditorKit;

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
 * @Date: 2021/2/21 22:53
 * @Description: 归并排序
 */
public class MergeSort {

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
        sort(ints, 0, ints.length - 1);
    }

    private static void sort(int[] ints, int begin, int end) {
        if (begin == end) {
            return;
        }
        int mid = (begin + end) / 2;
        sort(ints, begin, mid);
        sort(ints, mid + 1, end);
        merge(ints, begin, mid, end);


    }

    private static void merge(int[] ints, int begin, int mid, int end) {
        int[] temp = new int[end - begin+1];
        int p1 = begin;
        int p2 = mid + 1;
        int index = 0;
        while (p1 <= mid && p2 <= end) {
            temp[index++] = ints[p1] < ints[p2] ? ints[p1++] : ints[p2++];
        }

        while (p1 <= mid) {
            temp[index++] = ints[p1++];
        }
        while (p2 <= end) {
            temp[index++] = ints[p2++];
        }


        // 拷贝到原数组
        for (int m = 0; m < temp.length; m++) {
            ints[begin + m] = temp[m];
        }

    }
}
