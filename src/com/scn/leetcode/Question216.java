package com.scn.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-04-20
 */
public class Question216 {

    public static void main(String[] args) {
        System.out.println(combinationSum3(2, 18));
    }


    /**
     * 相加之和为 n 的 k 个数的组合
     * @param k
     * @param n
     * @return
     */
    public static List<List<Integer>> combinationSum3(int k, int n) {

        return getLists(k, n,1);
    }

    private static List<List<Integer>> getLists(int k, int n, int begin) {
        List<List<Integer>> res = new ArrayList<>();
        if(k==0){
            if(n == 0){
                res.add(new ArrayList<>());
                return res;
            }else {
                return null;
            }
        }


        for (int i = begin; i <= n && i<=9; i++) {

            List<List<Integer>> subArray = getLists(k - 1, n - i,i+1);
            if (subArray == null) {
                continue;
            }
            for (List<Integer> list : subArray) {
                ArrayList<Integer> integers = new ArrayList<>(list);
                integers.add(i);
                res.add(integers);
            }
        }
        return res;
    }
}
