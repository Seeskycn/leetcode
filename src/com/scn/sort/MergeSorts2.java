package com.scn.sort;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-02-23
 */
public class MergeSorts2 {

    public static void main(String[] args) {
        int[] ints = new int[]{1, 5, 4, 2, 3};
        sort(ints);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    private static void sort(int[] ints) {
        if (ints == null || ints.length < 2) {
            return;
        }
        mergeSort(ints, 0, ints.length-1);
    }

    private static void mergeSort(int[] ints, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = (L+R) / 2;
        mergeSort(ints, L, mid);
        mergeSort(ints, mid + 1, R);
        merge(ints, L, mid, R);
    }

    private static void merge(int[] ints, int L, int mid, int R) {
        int[] temp = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        int index = 0;
        while (p1 <= mid && p2 <= R) {
            temp[index ++] = ints[p1] < ints[p2] ? ints[p1 ++] : ints[p2 ++];
        }
        while (p1<=mid){
            temp[index ++] = ints[p1++];
        }
        while (p2<=R){
            temp[index ++] = ints[p2++];
        }

        // 拷贝回原数组
        for (int i = 0; i < temp.length; i++) {
            ints[L+i] = temp[i];
        }

    }
}
