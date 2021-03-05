package com.scn.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-04
 */
public class Question357 {

    private static List<Integer> res = new ArrayList();
    private static LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(3));
    }

    public static int countNumbersWithUniqueDigits(int n) {
        if(n == 0){
            return 1;
        }

        backtracking(n,res,path);
        Collections.sort(res);
        return res.size();

    }

    private static void backtracking( int n, List<Integer> res, LinkedList<Integer> path) {
        if(path.size() == n){

            return;
        }
        for (int j = 0; j <= 9; j++) {
            if(path.contains(j)){
                continue;
            }
            path.addLast(j);
            if(path.size()==n){
                if(path.getFirst() != 0){
                    res.add(getInt(path));
                }
            }else{
                res.add(getInt(path));
            }

            backtracking(n,res,path);
            path.removeLast();
        }

    }

    public static int getInt(LinkedList<Integer> path){
        StringBuilder sb = new StringBuilder();
        for (Integer integer : path) {
            sb.append(integer.toString());
        }
       return Integer.valueOf(sb.toString());
    }
}
