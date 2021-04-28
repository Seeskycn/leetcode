package com.scn.sort;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-02-23
 */
public class SortUtils {

    public static void swap(int[] ints , int i , int j){
        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }

    public static void print(int[] ints){
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
