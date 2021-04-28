package com.scn.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-05
 */
public class Question131 {

    public static void main(String[] args) {
        List<List<String>> abc = partition("abc");
        System.out.println(abc);
    }
    public static List<List<String>> partition(String s) {
        LinkedList<Character> path = new LinkedList<>();

        return backtracking(s,0,s.length()-1);
    }

    private static List<List<String>> backtracking(String s, int begin, int end) {

        List<List<String>> res = new ArrayList<>();
        if(begin == end){
            List<String> subRes = new ArrayList<>();
            subRes.add(s.charAt(begin)+"");
            res.add(subRes);
            return res;
        }

        for (int i = begin; i < end; i++) {
            List<List<String>> list1 = backtracking(s, begin, i);
            List<List<String>> List2 = backtracking(s, i + 1, end);
            if(list1.size()>0){
                for (List<String> stringList1 : list1) {
                    for (List<String> stringList2 : List2) {
                        ArrayList<String> list = new ArrayList<>();
                        list.addAll(stringList1);
                        list.addAll(stringList2);
                        res.add(list);
                    }
                }
            }else {
                for (List<String> stringList2 : List2) {
                    ArrayList<String> list = new ArrayList<>();
                    list.addAll(stringList2);
                    res.add(list);
                }
            }
        }


        return res;

    }


}
