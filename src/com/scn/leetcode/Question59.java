package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-07
 */
public class Question59 {

    public static void main(String[] args) {
        for (int[] ints : generateMatrix(5)) {
            for (int anInt : ints) {
                System.out.print( anInt + " ");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int begin = 0 ;  int end = n-1 ; int cur = 0;
        int[][] res = new int[n][n];
        while (begin < end){
            for (int i = begin; i <= end; i++) {
                res[begin][i] = ++cur;
            }

            for (int i = begin+1; i <= end; i++) {
                res[i][end] = ++cur;
            }

            for (int i = end-1; i >=begin; i--) {
                res[end][i] = ++cur;
            }

            for (int i = end-1; i >= begin+1; i--) {
                res[i][begin] = ++cur;
            }
            begin++;
            end--;


        }
        if(begin == end){
            res[begin][begin] = ++cur;
        }


        return res;

    }


}
