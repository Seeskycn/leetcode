package com.scn.leetcode;

import jdk.nashorn.internal.ir.IfNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-08
 */
public class Question60 {

    public static void main(String[] args) {
        System.out.println(getPermutation(9, 233794));
    }

    public static String getPermutation(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        getResult(n,k,res,path,set);

        List<Integer> list = res.get(k-1);
        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            sb.append(integer);
        }
        return sb.toString();

    }

    private static void getResult(int n, int k, List<List<Integer>> res, LinkedList<Integer> path, Set<Integer> set) {
        if(path.size() == n){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) {
                continue;
            }
            if(res.size() == k){
                return;
            }
            set.add(i);
            path.addLast(i);
            getResult(n,k,res,path,set);

            path.removeLast();
            set.remove(i);
        }
    }
}
